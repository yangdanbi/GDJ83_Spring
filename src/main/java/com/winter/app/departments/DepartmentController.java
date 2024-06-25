package com.winter.app.departments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/department/*") // department로 시작하는 모든 애들은 여기로 오게 함
public class DepartmentController {
	// IOC : Inversion of Controll
	// 객체 생성, 메서드 호출
	// Controller, Service, Repository, Component
	@Autowired // 의존성주입
	private DepartmentService departmentService;

	@RequestMapping(value = "list", method = RequestMethod.GET) // @RequestMapping("/department/*") + list
	public void getList(Model model) throws Exception {
		System.out.println("departmentController - getList()");
		// return "department/list";
		// 리턴하는 jsp경로가 없으면 url경로를 jsp경로로 대체해서 알아서 리턴
		// jsp랑 url경로가 다르다면 리턴을 해줘야하지만 같다면 안해도 됨
		List<DepartmentDTO> ar = departmentService.getList();
		// 1.
		// ModelAndView mv = new ModelAndView();
		// mv.addObject("list",ar);
		// retrun mv;

		model.addAttribute("list", ar); // list라는 속성으로 ar을 담아줌
		// return ar;
	}

}
