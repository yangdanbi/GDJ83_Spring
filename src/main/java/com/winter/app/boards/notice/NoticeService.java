package com.winter.app.boards.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.boards.BoardDAO;
import com.winter.app.boards.BoardDTO;
import com.winter.app.boards.BoardFileDTO;
import com.winter.app.boards.BoardService;
import com.winter.app.files.FileManager;
import com.winter.app.util.Pager;

@Service
public class NoticeService implements BoardService {
//	@Autowired
//	private NoticeDAO noticeDAO;

	@Autowired
	@Qualifier("noticeDAO") // 원하는 dao이름을 써줘야함
	private BoardDAO boardDAO;

	@Autowired
	private FileManager fileManager;

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

	public int add(BoardDTO boardDTO, MultipartFile[] multipartFiles, HttpSession session) throws Exception {
		int result = boardDAO.add(boardDTO);
		String path = session.getServletContext().getRealPath("resources/upload/Notice");

		if (multipartFiles == null) {
			return result;
		}

		for (MultipartFile f : multipartFiles) {
			if (f.isEmpty()) {
				continue;
			}
			String fileName = fileManager.fileSave(path, f);
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFile_name(fileName);
			boardFileDTO.setOri_name(f.getOriginalFilename());
			result = boardDAO.addFile(boardFileDTO);
		}

		return result;

	}

	public int update(BoardDTO boardDTO) throws Exception {
		return boardDAO.update(boardDTO);

	}

}
