package com.winter.app.boards.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.winter.app.boards.BoardDTO;
import com.winter.app.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	@Autowired
	NoticeService noticeService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Pager pager, Model model) throws Exception {
		List<BoardDTO> ar = noticeService.list(pager);
		model.addAttribute("pager", pager);
		model.addAttribute("list", ar);
		return "board/list";

	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(BoardDTO boardDTO, NoticeDTO noticeDTO, Model model) throws Exception {
		boardDTO = noticeService.detail(boardDTO);
		String url = "";
		if (boardDTO != null) {
			model.addAttribute("dto", boardDTO);
			url = "board/detail";
		} else {
			model.addAttribute("result", "없는 게시글 입니다.");
			model.addAttribute("url", "board/list");
			url = "commons/message";
		}
		return url;
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(BoardDTO boardDTO, NoticeDTO noticeDTO, Model model) throws Exception {
		int result = noticeService.delete(boardDTO);
		String url = "";
		if (result > 0) {
			url = "commons/message";
			model.addAttribute("result", "게시글을 삭제하였습니다.");
			model.addAttribute("url", "/board/list");
		} else {
			model.addAttribute("result", "삭제에 실패했습니다.");
			model.addAttribute("url", "/board/list");
			url = "commons/message";
		}
		return url;

	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() {

	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(BoardDTO boardDTO, NoticeDTO noticeDTO, Model model) throws Exception {
		int result = noticeService.add(boardDTO);

		String url = "";
		if (result > 0) {
			url = "redirect:board/list";
		} else {
			url = "commons/message";
			model.addAttribute("result", "글쓰기에 실패했습니다.");
			model.addAttribute("url", "board/list");
		}
		return url;
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(BoardDTO boardDTO, Model model, NoticeDTO noticeDTO) throws Exception {
		boardDTO = noticeService.detail(boardDTO);
		System.out.println("notice update");
		String url = "";
		if (boardDTO != null) {
			model.addAttribute("dto", boardDTO);
			url = "board/update";
		} else {
			model.addAttribute("result", "없는 게시글입니다.");
			model.addAttribute("url", "board/list");
			url = "commons/message";
		}
		return url;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(BoardDTO boardDTO, NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.update(boardDTO);

		return "redirect:board/list";

	}

}
