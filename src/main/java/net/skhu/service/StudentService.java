package net.skhu.service;

import net.skhu.dto.req.ReqStudent;

public interface StudentService {
	// 로그인
	int loginStudent(String studentNo, String password);

	// 회원가입
	int insertStudent(ReqStudent reqStudent);
}
