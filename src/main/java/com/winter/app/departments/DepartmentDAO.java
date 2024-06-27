package com.winter.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	// detail
	public DepartmentDTO getDetail(int num) throws Exception {
		// 1.db 접속
		Connection con = dbConnection.getConnection();
		// 2. 쿼리문
		// ?갯수는 여러개가 올수있음
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID=?";

		// 3. 미리전송
		PreparedStatement st = con.prepareStatement(sql);

		// 4. ? 세팅
		st.setInt(1, num);

		// 5. 최종전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		DepartmentDTO departmentDTO = null;
		if (rs.next()) {
			departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(rs.getInt(1));
			departmentDTO.setLocation_id(rs.getInt(4));
			departmentDTO.setDepartment_name(rs.getNString(2));
			departmentDTO.setManager_id(rs.getLong(3));
		}
		rs.close();
		st.close();
		con.close();

		return departmentDTO;

	}

	// add
	public int add(DepartmentDTO departmentDTO) throws Exception {
		// 1.db 접속
		Connection con = dbConnection.getConnection();
		// 2. 쿼리문
		// ?갯수는 여러개가 올수있음
		String sql = "INSERT INTO DEPARTMENTS " + "(DEPARTMENT_ID,DEPARTMENT_NAME,MANAGER_ID,LOCATION_ID) "
				+ "VALUES(DEPARTMENTS_SEQ.NEXTVAL,?,?,?)";

		// 3. 미리전송
		PreparedStatement st = con.prepareStatement(sql);

		// 4. ? 세팅
		st.setString(1, departmentDTO.getDepartment_name());// name 꺼내기
		st.setLong(2, departmentDTO.getManager_id());
		st.setInt(3, departmentDTO.getLocation_id());

		// 5. 최종전송 및 결과 처리
		int result = st.executeUpdate(); // result 가 0보다 크면 성공

		// 6. 자원해제
		st.close();
		con.close();

		return result;
	}

	public int delete(DepartmentDTO departmentDTO) throws Exception {
		Connection con = dbConnection.getConnection();

		String sql = "DELETE DEPARTMENTS WHERE DEPARTMENT_ID = ?";

		PreparedStatement st = con.prepareStatement(sql);

		// 4. ? 세팅
		st.setInt(1, departmentDTO.getDepartment_id());

		int result = st.executeUpdate();// insert,update,delete 는 int로 받아야ㅕ함

		st.close();
		con.close();

		return result;

	}

	public int update(DepartmentDTO departmentDTO) throws Exception {
		int result = 0;

		Connection con = dbConnection.getConnection();

		String sql = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME=?, MANAGER_ID=?, LOCATION_ID=?"
				+ "WHERE DEPARTMENT_ID = ?";
		PreparedStatement st = con.prepareStatement(sql);
		// 인덱스 번호는 ? 순서에 대한 번호
		st.setString(1, departmentDTO.getDepartment_name());// name 꺼내기
		st.setLong(2, departmentDTO.getManager_id());
		st.setInt(3, departmentDTO.getLocation_id());
		st.setInt(4, departmentDTO.getDepartment_id());

		result = st.executeUpdate();

		st.close();
		con.close();

		return result;

	}

	// 부서별 정보 조회
	public List<Map<String, Object>> getInfo() throws Exception {
		Connection con = dbConnection.getConnection();

		String sql = "SELECT DEPARTMENT_ID,SUM(SALARY),AVG(SALARY) FROM EMPLOYEES  " + "GROUP BY DEPARTMENT_ID";

		// 쿼리 미리 전송
		PreparedStatement st = con.prepareStatement(sql);

		ResultSet rs = st.executeQuery();

		// list 에 map을 담아야함
		List<Map<String, Object>> ar = new ArrayList<Map<String, Object>>();

		// 여러개니까
		while (rs.next()) {
			Map<String, Object> map = new HashMap<String, Object>();
			int id = rs.getInt("DEPARTMENT_ID");
			int sum = rs.getInt(2);
			double avg = rs.getDouble(3);
			map.put("id", id);
			map.put("sum", sum);
			map.put("avg", avg);

			ar.add(map);
		}

		rs.close();
		st.close();
		con.close();

		return ar;
	}

}
