package com.winter.app.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.utill.DBConnection;

@Repository
public class ProductDAO {
	@Autowired
	private DBConnection dbConnection;

	public List<ProductDTO> getList() throws Exception {
		System.out.println("ProductDAO getList()");
		Connection con = dbConnection.getConnection();
		System.out.println("ProductDAO con : " + con);
		String sql = "SELECT * FROM PRODUCT ORDER BY PRODUCT_ID ASC";
		// 쿼리문 전송
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();

		ArrayList<ProductDTO> ar = new ArrayList<ProductDTO>();
		// 읽었을때 데이터가 있으면 true 없으면false
		while (rs.next()) {
			ProductDTO productDTO = new ProductDTO();

			productDTO.setProduct_id(rs.getInt("PRODUCT_ID"));
			productDTO.setProduct_type(rs.getString("PRODUCT_TYPE"));
			productDTO.setProduct_rate(rs.getDouble("PRODUCT_RATE"));
			productDTO.setProduct_detail(rs.getString("PRODUCT_DETAIL"));

			ar.add(productDTO);
		}
		// 자원해제
		rs.close();
		st.close();
		con.close();

		return ar;
	}

	public ProductDTO detail(int id) throws Exception {
		System.out.println("productDAO detail()");

		Connection con = dbConnection.getConnection();
		String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_ID = ?";

		// 쿼리 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		// ? 값 처리해주기
		st.setInt(1, id);
		// 최종 쿼리 처리
		ResultSet rs = st.executeQuery();
		ProductDTO productDTO = null;// 옳지 않은 값이 들어오면 없는 없는 페이지입니다 jsp로 보내기위해

		if (rs.next()) {
			productDTO = new ProductDTO();
			productDTO.setProduct_id(rs.getInt("PRODUCT_ID"));
			productDTO.setProduct_type(rs.getString("PRODUCT_TYPE"));
			productDTO.setProduct_rate(rs.getInt("PRODUCT_RATE"));
			productDTO.setProduct_detail(rs.getString("PRODUCT_DETAIL"));

		}
		rs.close();
		st.close();
		con.close();

		return productDTO;

	}

}
