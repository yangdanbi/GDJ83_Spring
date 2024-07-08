package com.winter.app.member;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.winter.app.member.MemberDAO.";

	// ㅇemberDTO를 보내줘야함
	public int join(MemberDTO memberDTO) {
		return sqlSession.insert(NAMESPACE + "join", memberDTO);

	}

	public List<Map<String, Object>> login(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE + "login", memberDTO);
	}

	public MemberDTO myPage(MemberDTO memberDTO) {
		return sqlSession.selectOne(NAMESPACE + "mypage", memberDTO);
	}

	public int update(MemberDTO memberDTO) {
		return sqlSession.update(NAMESPACE + "update", memberDTO);

	}

	public int delete(MemberDTO memberDTO) {
		return sqlSession.delete(NAMESPACE + "delete", memberDTO);
	}

}
