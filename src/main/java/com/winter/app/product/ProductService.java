package com.winter.app.product;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.files.FileManager;
import com.winter.app.util.Pager;

@Service
public class ProductService {
	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private FileManager fileManager;

	public List<ProductDTO> getList(Pager pager) throws Exception {
		// page가 1이면 2 3 4
		// 첫번째 숫자 1 11 21 31
		// 두번째 숫자 10 20 30 40
		pager.makeRow();

		long totalCount = productDAO.getTotalCount(pager);

		pager.makeNum(totalCount);

		// System.out.println("totalPage " + totalPage);
		return productDAO.getList(pager);
	}

	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		return productDAO.getDetail(productDTO);

	}

	public int add(ProductDTO productDTO, MultipartFile[] files, HttpSession session) throws Exception {
		Integer num = productDAO.getNum();
		productDTO.setProduct_id(num);
		System.out.println("Product_id " + productDTO.getProduct_id());
		int result = productDAO.add(productDTO);
		if (files == null) {
			return result;
		}
		// 1. 저장할 폴더 지정
		ServletContext servletContext = session.getServletContext();
		String path = servletContext.getRealPath("resources/upload/products");

		System.out.println("path " + path);

//		File file = new File(path);
//
//		if (!file.exists()) {
//			file.mkdir();
//		}

		// 2. 저장할 파일명 생성
		for (MultipartFile f : files) {
			if (f.isEmpty()) {
				continue;
			}

			// 2. 저장할 파일명 생성
			String fileName = fileManager.fileSave(path, f);
//			String fileName = UUID.randomUUID().toString();
//			fileName = fileName + " " + f.getOriginalFilename();
//
//			// 3. HDD에 파일 저장
//			File f2 = new File(file, fileName);
//			f.transferTo(f2);

			// 4. 파일 정보를 db에 저장
			ProductFileDTO productFileDTO = new ProductFileDTO();
			productFileDTO.setFile_name(fileName);
			productFileDTO.setOri_name(f.getOriginalFilename());
			// productFileDTO.setFile_name(fileName);
			result = productDAO.addFile(productFileDTO);

			System.out.println("fileName" + productFileDTO.getFile_name());
		}

		return result;
	}

	public int delete(ProductDTO productDTO) throws Exception {
		return productDAO.delete(productDTO);
	}

	public int update(ProductDTO productDTO) throws Exception {
		return productDAO.update(productDTO);
	}

}
