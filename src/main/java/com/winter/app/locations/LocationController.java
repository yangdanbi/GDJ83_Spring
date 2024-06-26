package com.winter.app.locations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.winter.app.departments.DepartmentDTO;

@Controller
@RequestMapping("/location/*")
public class LocationController {

	@Autowired
	private LocationService locationService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
		System.out.println("LocationController - getList()");
		List<LocationDTO> ar = locationService.getList();

		model.addAttribute("list", ar);// jsp로 보내기
	}

	@RequestMapping("detail")
	public void getDetail(Model model, int location_id) throws Exception {
		LocationDTO locationDTO = locationService.getDetail(location_id);
		model.addAttribute("dto", locationDTO);// jsp로 보내기
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() {

	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(LocationDTO locationDTO, Model model) throws Exception {
		int result = locationService.add(locationDTO);
		String url = "";
		if (result > 0) {
			url = "redirect:./list";
		} else {
			url = "commons/message";
			model.addAttribute("result", "등록에 실패했습니다.");
			model.addAttribute("url", "./list");
		}
		return url;

	}

	@RequestMapping("delete")
	public String delete(LocationDTO locationDTO, Model model) throws Exception {
		int result = locationService.delete(locationDTO);
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

	@RequestMapping("update")
	public String update(int location_id,Model model) throws Exception {
		LocationDTO locationDTO = locationService.getDetail(location_id);
		String url = "commons/message";
		if (locationDTO != null) {
			model.addAttribute("dto", locationDTO);
			url = "location/update";
		} else {
			model.addAttribute("result", "없는 도시입니다.");
			model.addAttribute("url", "./list");
		}
		return url;
		
		
	}
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(LocationDTO locationDTO) throws Exception {
		int result = locationService.update(locationDTO);

		return "redirect:./list";
		
	}

}
