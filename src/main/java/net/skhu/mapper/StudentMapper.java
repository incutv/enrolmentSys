package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.req.ReqStudent;
import net.skhu.dto.res.ResDepartment;
import net.skhu.dto.res.ResStudent;

@Mapper
public interface StudentMapper {
	// 로그인
	ResStudent loginStudent(ReqStudent student);

	// 아이디확인
	ResStudent findByStudentNo(String studentNo);

	// 회원가입
	int insertStudent(ReqStudent reqStudent);

	// 학과조회
	List<ResDepartment> selectDepartment();

	//중복체크
	int duplicateCheck(String studentNo, String phone, String email);
}
