package com.winter.app.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.departments.DepartmentDTO;
import com.winter.app.utill.DBConnection;

@Repository
public class EmployeesDAO {
	@Autowired
	private DBConnection dbConnection;

	public List<EmployeesDTO> getList() throws Exception {
		System.out.println("employeesDAO getList()");
		Connection con = dbConnection.getConnection();
		System.out.println("EmployeesnDAO con : " + con);

		String sql = "SELECT * FROM EMPLOYEES ORDER BY EMPLOYEE_ID ASC";
		// 쿼리문 전송
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		ArrayList<EmployeesDTO> ar = new ArrayList<EmployeesDTO>();
		// 읽었을때 데이터가 있으면 true 없으면false
		while (rs.next()) {
			EmployeesDTO employeesDTO = new EmployeesDTO();

			employeesDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeesDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeesDTO.setLast_name(rs.getString("Last_name"));
			employeesDTO.setHire_date(rs.getDate("HIRE_DATE"));

			ar.add(employeesDTO);
			// System.out.println("DEPARTMENT_ID : " + id + ", DEPARTMENT_NAME : " + name);
		}
		// 자원해제
		rs.close();
		st.close();
		con.close();

		return ar;
	}

}
