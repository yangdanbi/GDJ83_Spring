package com.winter.app.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.winter.app.member.MemberDAO.";

	// ㅇemberDTO를 보내줘야함
	public int join(MemberDTO memberDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "join", memberDTO);

	}

	public int addFile(MemberFileDTO memberFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "addFile", memberFileDTO);
	}

	public MemberDTO login(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "login", memberDTO);
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

	public MemberDTO detail(MemberDTO memberDTO) {
		return sqlSession.selectOne(NAMESPACE + "detail", memberDTO);
	}

}
