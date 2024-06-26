package com.winter.app.employees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/employees/*")
public class EmployeesController {

	@Autowired
	private EmployeesService employeesService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
		System.out.println("employeesController getList()"); //
		List<EmployeesDTO> ar = employeesService.getList();

		// jsp로 보내는 법 3가지

		// 1. void일때
		model.addAttribute("list", ar);// jsp로 보내기

		// 2. public String getList() 일때
		// return "emplyees/list";

		// 3.
		// ModelAndView mv = new ModelAndView();
		// mv.addObject("list",ar);
		// retrun mv;

	}

}
