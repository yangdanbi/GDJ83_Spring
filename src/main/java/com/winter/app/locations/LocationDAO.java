package com.winter.app.locations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.utill.DBConnection;

@Repository
public class LocationDAO {
	@Autowired
	private DBConnection dbConnection;

	public List<LocationDTO> getList() throws Exception {
		System.out.println("locationDAO 실행");
		Connection con = dbConnection.getConnection();
		System.out.println("LocationDAO con : " + con);

		// 쿼리
		String sql = "SELECT * FROM LOCATIONS ORDER BY LOCATION_ID ASC";

		// 쿼리 미리 전송해놓기
		PreparedStatement st = con.prepareStatement(sql);
		// 처리
		ResultSet rs = st.executeQuery();

		// 결과값을 리스트에 저장해놓기 위해 리스트 선언
		ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();
		while (rs.next()) {
			LocationDTO locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));

			ar.add(locationDTO);
		}
		rs.close();
		st.close();
		con.close();

		return ar;
	}

}
