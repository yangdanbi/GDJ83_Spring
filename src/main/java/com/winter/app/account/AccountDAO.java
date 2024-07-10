package com.winter.app.account;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.history.HistoryDTO;

@Repository
public class AccountDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.winter.app.account.AccountDAO.";

	public int add(AccountDTO accountDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", accountDTO);
	}

	public AccountDTO detail(AccountDTO accountDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "detail", accountDTO);
	}

	/*
	 * public List<AccountDTO> list(MemberDTO memberDTO) throws Exception { return
	 * sqlSession.selectList(NAMESPACE + "list", memberDTO); }
	 */
	public int transfer(HistoryDTO historyDTO) {
		return sqlSession.insert(NAMESPACE + "transfer", historyDTO);
	}

	public int transfer_u(HistoryDTO historyDTO) {
		return sqlSession.insert(NAMESPACE + "transfer_u", historyDTO);
	}

	public int pro_up(HistoryDTO historyDTO) {
		return sqlSession.update(NAMESPACE + "pro_up", historyDTO);
	}

	public int pro_up_u(HistoryDTO historyDTO) {
		return sqlSession.update(NAMESPACE + "pro_up_u", historyDTO);
	}

}
