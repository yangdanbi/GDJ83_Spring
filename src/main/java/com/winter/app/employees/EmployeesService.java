package com.winter.app.employees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeesService {
	@Autowired
	private EmployeesDAO employeesDAO;
	
	public List<EmployeesDTO> getList() throws Exception {
		System.out.println("employeesService getList()");
		return employeesDAO.getList();
		
	}

}
