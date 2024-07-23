package com.winter.app.boards.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.boards.BoardDTO;
import com.winter.app.boards.BoardFileDTO;
import com.winter.app.boards.BoardService;
import com.winter.app.files.FileManager;
import com.winter.app.util.Pager;

@Service
public class QnaService implements BoardService {
	@Autowired
	private QnaDAO qnaDAO;

	@Autowired
	private FileManager fileManager;

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		// 1. rownum 계산
		pager.makeRow();
		// 2. pageing 계산
		pager.makeNum(qnaDAO.getTotalCount(pager));
		return qnaDAO.list(pager);
	}

	@Override
	public int add(BoardDTO boardDTO, MultipartFile[] multipartFiles, HttpSession session) throws Exception {

		int result = qnaDAO.add(boardDTO);

		String path = session.getServletContext().getRealPath("resources/upload/Qna");

		if (multipartFiles == null) {
			return result;
		}

		for (MultipartFile f : multipartFiles) {
			if (f.isEmpty()) {
				continue;
			}

			String fileName = fileManager.fileSave(path, f);
			BoardFileDTO boardFileDTO = new BoardFileDTO();

			boardFileDTO.setBoard_num(boardDTO.getBoard_num());

			boardFileDTO.setFile_name(fileName);
			boardFileDTO.setOri_name(f.getOriginalFilename());
			result = qnaDAO.addFile(boardFileDTO);
		}
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return qnaDAO.update(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		return qnaDAO.delete(boardDTO);

	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		qnaDAO.hit(boardDTO);
		return qnaDAO.detail(boardDTO);
	}

	public int reply(QnaDTO qnaDTO) throws Exception {
		QnaDTO parent = (QnaDTO) qnaDAO.detail(qnaDTO); // 부모의 정보
		// 1. step 1씩 업데이트
		int result = qnaDAO.replyUpdate(parent);// 부모의 정보를 보냄

		// 2. 답글의 REF, STEP, DEPTH를 세팅
		qnaDTO.setRef(parent.getRef());// 부모의 ref를 꺼내옴
		qnaDTO.setStep(parent.getStep() + 1);
		qnaDTO.setDepth(parent.getDepth() + 1);

		return qnaDAO.reply(qnaDTO);
	}

}
