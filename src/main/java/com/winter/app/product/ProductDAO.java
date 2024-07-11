package com.winter.app.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {
	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.winter.app.product.ProductDAO.";

	public List<ProductDTO> getList(List<Long> ar) throws Exception {

		return sqlSession.selectList(NAMESPACE + "getList", ar);

	}

	public Long getTotalCount() throws Exception {

		return sqlSession.selectOne(NAMESPACE + "getTotalCount");

	}

	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getDetail", productDTO);

	}

	public int add(ProductDTO productDTO) throws Exception {

		return sqlSession.insert(NAMESPACE + "add", productDTO);
	}

	public int delete(ProductDTO productDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "delete", productDTO);
	}

	public int update(ProductDTO productDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "update", productDTO);
	}
}
