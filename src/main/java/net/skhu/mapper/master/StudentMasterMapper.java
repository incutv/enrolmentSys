package net.skhu.mapper.master;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.req.ReqStudent;

@Mapper
public interface StudentMasterMapper {
	// 회원가입
	int insertStudent(ReqStudent reqStudent);


	//회원탈퇴
	int deleteStudent(String studentNo);
}
