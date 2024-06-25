package com.winter.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.utill.DBConnection;

@Repository
public class DepartmentDAO {
	// 의존성 주입 DI,IOC- 스프링한테 해달라하는 것
	@Autowired
	private DBConnection dbConnection;

	public List<DepartmentDTO> getList() throws Exception {
		Connection con = dbConnection.getConnection();
		System.out.println("DepartmentDAO con : " + con);

		// sql문 작성
		String sql = "SELECT * FROM DEPARTMENTS ORDER BY DEPARTMENT_ID ASC";

		// 작성한 쿼리문을 미리 전송
		PreparedStatement st = con.prepareStatement(sql);

		// ? 값 세팅

		// 최종 전송 및 결과 처리
		// 미리보낸 쿼리문을 실행해라
		// rs에 받음 = 최종결과
		ResultSet rs = st.executeQuery();

		ArrayList<DepartmentDTO> ar = new ArrayList<DepartmentDTO>();
		// 읽었을때 데이터가 있으면 true 없으면false
		while (rs.next()) {
			DepartmentDTO departmentDTO = new DepartmentDTO();
			int id = rs.getInt("DEPARTMENT_ID");
			String name = rs.getString("DEPARTMENT_NAME");
			departmentDTO.setDepartment_id(id);
			departmentDTO.setDepartment_name(name);
			departmentDTO.setManager_id(rs.getLong("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));

			ar.add(departmentDTO);// 리스트에 하나씩 저장되어져있음
			// System.out.println("DEPARTMENT_ID : " + id + ", DEPARTMENT_NAME : " + name);
		}
		// 자원해제
		rs.close();
		st.close();
		con.close();

		return ar;

	}

}
