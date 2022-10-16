package net.skhu.service;

import java.util.List;

import net.skhu.dto.req.ReqStudent;
import net.skhu.dto.res.ResDepartment;
import net.skhu.dto.res.ResStudent;

public interface StudentService {
	// 로그인
	ResStudent loginStudent(ReqStudent student);

	// 회원가입
	int insertStudent(ReqStudent student);

	// 학과조회
	List<ResDepartment> selectDepartment();

	// 중복체크
	int duplicateCheck(String studentNo, String phone, String email);
}
