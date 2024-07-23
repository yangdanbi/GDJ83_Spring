package com.winter.app.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.util.Pager;

@Repository
public class ProductDAO {
	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.winter.app.product.ProductDAO.";

	public List<ProductDTO> getList(Pager pager) throws Exception {

		return sqlSession.selectList(NAMESPACE + "getList", pager);

	}

	public Long getTotalCount(Pager pager) throws Exception {

		return sqlSession.selectOne(NAMESPACE + "getTotalCount", pager);

	}

	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getDetail", productDTO);

	}

	public int add(ProductDTO productDTO) throws Exception {

		return sqlSession.insert(NAMESPACE + "add", productDTO);
	}

	public int addFile(ProductFileDTO productFileDTO) throws Exception {

		return sqlSession.insert(NAMESPACE + "addFile", productFileDTO);
	}

	public Integer getNum() throws Exception {

		return sqlSession.selectOne(NAMESPACE + "getNum");
	}

	public int delete(ProductDTO productDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "delete", productDTO);
	}

	public int update(ProductDTO productDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "update", productDTO);
	}
}
