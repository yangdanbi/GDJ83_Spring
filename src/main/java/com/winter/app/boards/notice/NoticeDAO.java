package com.winter.app.boards.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.util.Pager;

@Repository
public class NoticeDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.winter.app.boards.notice.NoticeDAO.";

	public List<NoticeDTO> list(Pager pager) {
		return sqlSession.selectList(NAMESPACE + "list", pager);
	}

	public long getTotalCount(Pager pager) {
		return 0;
	}

	public NoticeDTO detail(NoticeDTO noticeDTO) {
		return sqlSession.selectOne(NAMESPACE + "detail", noticeDTO);
	}

	public int delete(NoticeDTO noticeDTO) {
		return sqlSession.delete(NAMESPACE + "delete", noticeDTO);
	}

	public int add(NoticeDTO noticeDTO) {
		return sqlSession.insert(NAMESPACE + "add", noticeDTO);
	}

	public int update(NoticeDTO noticeDTO) {
		return sqlSession.update(NAMESPACE + "update", noticeDTO);
	}

	public int hit(int board_num) {
		return sqlSession.update(NAMESPACE + "hit", board_num);
	}

}
