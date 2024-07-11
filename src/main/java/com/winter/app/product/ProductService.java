package com.winter.app.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductDAO productDAO;

	public List<ProductDTO> getList(Long page) throws Exception {
		// page가 1이면 2 3 4
		// 첫번째 숫자 1 11 21 31
		// 두번째 숫자 10 20 30 40
		if (page == null) {
			page = 1L;
		}
		long perPage = 10L;
		System.out.println("test perPage " + perPage);
		System.out.println("test page " + page);

		long startRow = (page - 1) * perPage + 1;
		System.out.println("test startRow " + startRow);

		long lastRow = page * perPage;
		System.out.println("test lastRow " + lastRow);

		List<Long> ar = new ArrayList<Long>();

		// ar.add(perPage);
		ar.add(startRow);
		ar.add(lastRow);

//		Pager pager = new Pager();
//		pager.setStratRow(page);
//		
//		pager.setLastRow(page);

		long totalCount = productDAO.getTotalCount();
		long totalPage = totalCount / perPage;
		System.out.println("totalPage " + totalPage);
		return productDAO.getList(ar);
	}

	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		return productDAO.getDetail(productDTO);

	}

	public int add(ProductDTO productDTO) throws Exception {
		return productDAO.add(productDTO);
	}

	public int delete(ProductDTO productDTO) throws Exception {
		return productDAO.delete(productDTO);
	}

	public int update(ProductDTO productDTO) throws Exception {
		return productDAO.update(productDTO);
	}

}
