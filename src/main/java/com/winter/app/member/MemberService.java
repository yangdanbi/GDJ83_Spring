package com.winter.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;

	public int join(MemberDTO memberDTO) {
		return memberDAO.join(memberDTO);
	}

	public MemberDTO login(MemberDTO memberDTO) throws Exception { // 사용자가 입력한 id,pw
		MemberDTO result = memberDAO.login(memberDTO); // 새로운 dto에 입력받은 정보를 넣음

		if (result != null) {// null이 아니면 id는 일치
			if (result.getMember_pwd().equals(memberDTO.getMember_pwd())) { // 입력받은 pw랑 디비에 pw랑 일치하면
				return result;
			} else {
				return null; // pw틀리면 null리턴돼서 로그인 안됨
			}
		}
		return result;
	}

	public MemberDTO myPage(MemberDTO memberDTO) {
		return memberDAO.myPage(memberDTO);
	}

	public int update(MemberDTO memberDTO) {
		return memberDAO.update(memberDTO);
	}

	public int delete(MemberDTO memberDTO) {
		return memberDAO.delete(memberDTO);
	}

}
