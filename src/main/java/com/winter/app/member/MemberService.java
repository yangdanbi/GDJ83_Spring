package com.winter.app.member;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.account.AccountDAO;
import com.winter.app.files.FileManager;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private AccountDAO accountDAO;
	@Autowired
	private FileManager fileManager;

	public int join(MemberDTO memberDTO, MultipartFile files, HttpSession session) throws Exception {
		int result = memberDAO.join(memberDTO);

		if (files == null) {
			return result;
		}

		ServletContext servletContext = session.getServletContext();
		// 1. 어디에 저장?? 운영체제가 알고 있는 경로
		String path = servletContext.getRealPath("resources/upload/members");

		System.out.println(path);

		File file = new File(path);

		if (!file.exists()) {
			file.mkdirs();
		}

		// 2. 파일명??
		// 1) 시간
		Calendar calendar = Calendar.getInstance();
		long n = calendar.getTimeInMillis();

		// subString
		String fileName = files.getOriginalFilename();
		fileName = fileName.substring(fileName.lastIndexOf("."));
		System.out.println(fileName);

		// split, StringTokenizer
		fileName = files.getOriginalFilename();
		String[] names = fileName.split("\\.");
		fileName = names[names.length - 1];

		System.out.println(fileName);
		fileName = n + "." + fileName;

		fileName = n + "_" + files.getOriginalFilename();

		// 2)
		fileName = UUID.randomUUID().toString() + "_" + files.getOriginalFilename();
		System.out.println(fileName);

		// 3. HDD에 파일 저장
		file = new File(file, fileName);

		// 1) MultipartFile
		// files.transferTo(file);

		// 2) FileCopyUtils
		FileCopyUtils.copy(files.getBytes(), file);

		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setMember_id(memberDTO.getMember_id());
		memberFileDTO.setFile_name(fileName);
		memberFileDTO.setOri_name(files.getOriginalFilename());

		result = memberDAO.addFile(memberFileDTO);

		return result;// memberDAO.join(memberDTO);
	}

	public MemberDTO login(MemberDTO memberDTO) throws Exception { // 사용자가 입력한 id,pw
		// Map<String, Object> map = new HashMap<String, Object>();// 객체를 만들 수 있는 클래스 =
		// 구현클래스
		MemberDTO result = memberDAO.login(memberDTO); // 새로운 dto에 입력받은 정보를 넣음

		if (result != null) {// null이 아니면 id는 일치
			if (result.getMember_pwd().equals(memberDTO.getMember_pwd())) { // 입력받은 pw랑 디비에 pw랑 일치하면
				// 로그인 성공시점
				// List<AccountDTO> ar = accountDAO.list(memberDTO);
				// map.put("member", result); // memberDTO넣음
				// map.put("account", ar);
				return result;
			} else {
				result = null; // pw틀리면 null리턴돼서 로그인 안됨
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

	public MemberDTO detail(MemberDTO memberDTO) throws Exception {
		return memberDAO.detail(memberDTO);
	}

}
