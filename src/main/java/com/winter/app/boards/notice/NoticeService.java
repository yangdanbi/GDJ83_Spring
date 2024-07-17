package com.winter.app.boards.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.winter.app.boards.BoardDAO;
import com.winter.app.boards.BoardDTO;
import com.winter.app.boards.BoardService;
import com.winter.app.util.Pager;

@Service
public class NoticeService implements BoardService {
//	@Autowired
//	private NoticeDAO noticeDAO;

	@Autowired
	@Qualifier("noticeDAO") // 원하는 dao이름을 써줘야함
	private BoardDAO boardDAO;

	public List<BoardDTO> list(Pager pager) throws Exception {

		pager.makeRow();

		long totalCount = boardDAO.getTotalCount(pager);
		pager.makeNum(totalCount);

		return boardDAO.list(pager);
	}

	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		boardDAO.hit(boardDTO);
		return boardDAO.detail(boardDTO);

	}

	public int delete(BoardDTO boardDTO) throws Exception {
		return boardDAO.delete(boardDTO);
	}

	public int add(BoardDTO boardDTO) throws Exception {
		return boardDAO.add(boardDTO);

	}

	public int update(BoardDTO boardDTO) throws Exception {
		return boardDAO.update(boardDTO);

	}

}
