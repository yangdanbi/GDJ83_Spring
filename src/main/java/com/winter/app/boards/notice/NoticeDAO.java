package com.winter.app.boards.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.boards.BoardDAO;
import com.winter.app.boards.BoardDTO;
import com.winter.app.boards.BoardFileDTO;
import com.winter.app.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.winter.app.boards.notice.NoticeDAO.";

	@Override
	public Long getTotalCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getTotalCount", pager);
	}

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE + "list", pager);
	}

	@Override
	public int add(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", boardDTO);
	}

	@Override
	public int addFile(BoardFileDTO boardFileDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE + "addFile", boardFileDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "update", boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "delete", boardDTO);
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "detail", boardDTO);
	}

	public int hit(BoardDTO boardDTO) {
		return sqlSession.update(NAMESPACE + "hit", boardDTO);
	}

//	public List<BoardDTO> list(Pager pager) {
//		return sqlSession.selectList(NAMESPACE + "list", pager);
//	}
//
//	public Long getTotalCount(Pager pager) {
//
//		return sqlSession.selectOne(NAMESPACE + "getTotalCount", pager);
//	}
//
//	public NoticeDTO detail(BoardDTO boardDTO) {
//		return sqlSession.selectOne(NAMESPACE + "detail", boardDTO);
//	}
//
//	public int delete(BoardDTO boardDTO) {
//		return sqlSession.delete(NAMESPACE + "delete", boardDTO);
//	}
//
//	public int add(BoardDTO boardDTO) {
//		return sqlSession.insert(NAMESPACE + "add", boardDTO);
//	}
//
//	public int update(NoticeDTO noticeDTO) {
//		return sqlSession.update(NAMESPACE + "update", boardDTO);
//	}
//

}
