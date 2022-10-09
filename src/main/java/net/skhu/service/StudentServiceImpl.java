package net.skhu.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.skhu.dto.req.ReqStudent;

@Service
public class StudentServiceImpl implements StudentService{

	@Override
	public int loginStudent(String studentNo, String password) {
		return 0;
	}

	@Override
	@Transactional
	public int insertStudent(ReqStudent reqStudent) {
		return 0;
	}

}
