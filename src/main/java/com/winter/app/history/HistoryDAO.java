package com.winter.app.history;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HistoryDAO {
	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.winter.app.history.HistoryDAO.";

	public int add(HistoryDTO historyDTO) {
		return sqlSession.insert(NAMESPACE + "add", historyDTO);
	}

	public int update(HistoryDTO historyDTO) {
		return sqlSession.update(NAMESPACE + "update", historyDTO);
	}

}
