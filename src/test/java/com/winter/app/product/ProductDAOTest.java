package com.winter.app.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.DefaultTest;

public class ProductDAOTest extends DefaultTest {
	@Autowired
	private ProductDAO productDAO;

	// @Test
	public void getDetailTest() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProduct_id(60);
		productDTO = productDAO.getDetail(productDTO);

		// 단정문
		assertNotNull(productDTO);// productDTO가 null이 아니면 좋겠다 희망하는 문

	}

	@Test
	public void insertTest() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProduct_type("적금");
		productDTO.setProduct_rate(3.2);
		productDTO.setProduct_detail("적금....");

		int result = productDAO.add(productDTO);

		assertEquals(1, result);

	}
}
