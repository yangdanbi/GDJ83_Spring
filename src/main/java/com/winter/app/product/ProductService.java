package com.winter.app.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductDAO productDAO;

	public Map<String, Object> getList(Long page) throws Exception {
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

		if (totalCount % perPage != 0) {
			// totalPage = totalCount / perPage + 1;
			totalPage++;
		}
		//
		long perBlock = 5L; // 한페이지에 보여질 페이번호의 갯수
		long totalBlock = 0; // 총 블럭의 수

		totalBlock = totalPage / perBlock;
		if (totalPage % perBlock != 0) {
			totalPage++;
		}
		// 3. 현재 페이지 번호로 현재블럭 번호를 구하기
		// page 1 2 3 4 5 6 10 11
		// 블럭번호 1 1 1 1 1 2 2 3
		long curBlock = 0;
		curBlock = page / perBlock;

		if (page % perBlock != 0) {
			curBlock++;
		}

		// 4. 현재 블럭 번호로 시작번호와 끝 번호 구하기

		// curBLock 1 2 3 4
		// start 1 6 11 16
		// last 5 10 15 20
		long startNum = (curBlock - 1) * perBlock + 1;
		long lastNum = curBlock * perBlock;

		// page 1 2 3 4 5 6 7 10
		// start 1 1 1 1 1 6 6 6
		// last 5 5 5 5 5 10 10 10

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", productDAO.getList(ar));
		map.put("totalPage", totalPage);
		map.put("startNum", startNum);
		map.put("lastNum", lastNum);

		// System.out.println("totalPage " + totalPage);
		return map;
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
