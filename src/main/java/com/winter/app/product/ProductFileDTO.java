package com.winter.app.product;

import com.winter.app.files.FileDTO;

public class ProductFileDTO extends FileDTO {
	private Long product_id;

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

}
