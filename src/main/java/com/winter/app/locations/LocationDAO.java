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

	public LocationDTO getDetail(int num) throws Exception {

		Connection con = dbConnection.getConnection();
		String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ? ";

		// 쿼리 미리 전송해놓기
		PreparedStatement st = con.prepareStatement(sql);
		// 처리

		// ? 세팅
		st.setInt(1, num);
		ResultSet rs = st.executeQuery();
		LocationDTO locationDTO = null;
		if (rs.next()) {
			locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));

		}
		rs.close();
		st.cancel();
		con.close();

		return locationDTO;

	}

	public int add(LocationDTO locationDTO) throws Exception {
		// 1. db접속
		Connection con = dbConnection.getConnection();

		String sql = "INSERT INTO LOCATIONS "
				+ "(LOCATION_ID,STREET_ADDRESS,POSTAL_CODE,CITY,STATE_PROVINCE,COUNTRY_ID) "
				+ "VALUES(LOCATIONS_SEQ.NEXTVAL,?,?,?,?,?)";

		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, locationDTO.getStreet_address());
		st.setString(2, locationDTO.getPostal_code());
		st.setString(3, locationDTO.getCity());
		st.setString(4, locationDTO.getState_province());
		st.setString(5, locationDTO.getCountry_id());

		int result = st.executeUpdate(); // result 가 0보다 크면 성공

		st.close();
		con.close();

		return result;

	}

	public int delete(LocationDTO locationDTO) throws Exception {
		Connection con = dbConnection.getConnection();

		String sql = "DELETE LOCATIONS WHERE LOCATION_ID = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, locationDTO.getLocation_id());

		int result = st.executeUpdate();

		st.close();
		con.close();

		return result;

	}
	public int update(LocationDTO locationDTO) throws Exception{
		int result =0;
		
		Connection con = dbConnection.getConnection();//db연결
		
		String sql = "UPDATE LOCATIONS SET STREET_ADDRESS =?,POSTAL_CODE=?,CITY=?,STATE_PROVINCE=?,COUNTRY_ID=?"
				+ "WHERE LOCATION_ID = ?";
		System.out.println("LocationDAO update실행");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, locationDTO.getStreet_address());
		st.setString(2, locationDTO.getPostal_code());
		st.setString(3, locationDTO.getCity());
		st.setString(4, locationDTO.getState_province());
		st.setString(5, locationDTO.getCountry_id());
		st.setInt(6, locationDTO.getLocation_id());
		System.out.println(locationDTO.getLocation_id());
		System.out.println("수정:"+locationDTO.getStreet_address());

		result = st.executeUpdate();
		st.close();
		con.close();

		return result;
		
	}

}
