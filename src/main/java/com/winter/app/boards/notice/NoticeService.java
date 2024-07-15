package com.winter.app.boards.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.util.Pager;

@Service
public class NoticeService {
	@Autowired
	private NoticeDAO noticeDAO;

	public List<NoticeDTO> list(Pager pager) throws Exception {

		pager.makeRow();

		long totalCount = noticeDAO.getTotalCount(pager);
		pager.makeNum(totalCount);

		return noticeDAO.list(pager);
	}

	public NoticeDTO detail(NoticeDTO noticeDTO) {
		return noticeDAO.detail(noticeDTO);

	}

	public int delete(NoticeDTO noticeDTO) {
		return noticeDAO.delete(noticeDTO);
	}

	public int add(NoticeDTO noticeDTO) {
		return noticeDAO.add(noticeDTO);

	}

	public int update(NoticeDTO noticeDTO) {
		return noticeDAO.update(noticeDTO);

	}

}
