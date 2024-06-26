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

	@RequestMapping("detail") // 파라미터 이름에 num으로 넘어오면 (일치하지않는다면) department_id로 넣어줘라
	// url에 http://localhost/department/detail?num=90 해도 디테일페이지로 넘어감
	// @RequestParam(name = "num", defaultValue = "10")
	// department_id- 파라미터명과 변수명이 일치해야함
	public String getDetail(Model model, int department_id) throws Exception {
		System.out.println("EmployeesController getDetail()");
		DepartmentDTO departmentDTO = departmentService.getDetail(department_id);
		String path = "commons/message";
		if (departmentDTO != null) {
			// jsp로 뿌림
			model.addAttribute("dto", departmentDTO);
			// null이 아니면 detail로
			path = "department/detail";

		} else {
			model.addAttribute("result", "부서를 찾을 수 없습니다.");
			model.addAttribute("url", "./list");

		}
		return path;
	}

	// add
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() {

	}

//dto 변수명과 파라미터 명을 동일하게
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(DepartmentDTO departmentDTO, Model model) throws Exception {
		/*
		 * DepartmentDTO departmentDTO = new DepartmentDTO();
		 * departmentDTO.setDepartment_name(depatment_name);
		 */
		System.out.println(departmentDTO.getDepartment_id());
		int result = departmentService.add(departmentDTO);
		String url = "";
		if (result > 0) {
			url = "redirect:./list";
		} else {
			url = "commons/message";
			model.addAttribute("result", "부서등록에 실패했습니다.");
			model.addAttribute("url", "./list");
		}
		return url;
	}

	// delete
	@RequestMapping("delete")
	public String delete(DepartmentDTO departmentDTO, Model model) throws Exception {
		System.out.println("Department delete() 실행");
		int result = departmentService.delete(departmentDTO);
		String url = "commons/message"; // 실패했을때
		if (result > 0) {
			url = "redirect:./list";
		} else {
			url = "commons/message";
			model.addAttribute("result", "삭제에 실패했습니다.");
			model.addAttribute("url", "./list");

		}
		return url;
	}

	// update
	@RequestMapping("update") // 메서드 지정하지 않으면 get
	public String update(int department_id, Model model) throws Exception {
		System.out.println("Department update() 실행");

		DepartmentDTO departmentDTO = departmentService.getDetail(department_id);
		String url = "commons/message";
		if (departmentDTO != null) {
			model.addAttribute("dto", departmentDTO);
			url = "department/update";
		} else {
			model.addAttribute("result", "없는 부서입니다.");
			model.addAttribute("url", "./list");
		}
		return url;
	}

	// 오버로딩
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(DepartmentDTO departmentDTO) throws Exception {
		int result = departmentService.update(departmentDTO);

		return "redirect:list";

	}

}
