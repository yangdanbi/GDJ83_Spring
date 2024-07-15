package com.winter.app.boards.qna;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/qna/*") // 이건 그대로 써줘야 함
public class QnaController {

	@GetMapping("list") // get방식 post 일땐 @PostMapping("list")
	public ModelAndView list(ModelAndView mv) throws Exception {
		mv.setViewName("board/list");
		return mv;
	}

	@GetMapping("detail")
	public String detail() throws Exception {
		return "board/detail";
	}

	@GetMapping("add")
	public String add() throws Exception {
		return "board/add";
	}

	@GetMapping("update")
	public String update() throws Exception {
		return "board/update";
	}
}
