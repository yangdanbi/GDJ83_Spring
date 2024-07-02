package com.winter.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductDAO productDAO;

	public List<ProductDTO> getList() throws Exception {

		return productDAO.getList();
	}

	public ProductDTO detail(int id) throws Exception {
		return productDAO.detail(id);

	}

	public int add(ProductDTO productDTO) throws Exception {
		return productDAO.add(productDTO);
	}
}
