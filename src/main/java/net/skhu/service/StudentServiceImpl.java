package net.skhu.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.skhu.dto.Message;
import net.skhu.dto.req.ReqStudent;
import net.skhu.dto.res.ResDepartment;
import net.skhu.dto.res.ResStudent;
import net.skhu.mapper.master.StudentMasterMapper;
import net.skhu.mapper.read.StudentReadMapper;

@Service
public class StudentServiceImpl implements StudentService{

	private StudentMasterMapper studentMasterMapper;
	private StudentReadMapper studentReadMapper;
	private PasswordEncoder passwordEncoder;

	public StudentServiceImpl(StudentMasterMapper studentMasterMapper, StudentReadMapper studentReadMapper, PasswordEncoder passwordEncoder) {
		this.studentMasterMapper = studentMasterMapper;
		this.studentReadMapper = studentReadMapper;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public ResStudent loginStudent(ReqStudent reqStudent) {
		ResStudent student = studentReadMapper.findByStudentNo(reqStudent.getStudentNo());

		if(student == null) {
			throw new RuntimeException(Message.NOT_FOUND_STUDENTNO.getMessage());
		}

		if(!passwordEncoder.matches(reqStudent.getPassword(), student.getPassword())) {
			throw new RuntimeException(Message.NOT_FOUND_PASSWORD.getMessage());
		}

		return student;
	}

	@Override
	@Transactional
	public int insertStudent(ReqStudent student) {
		String studentNo = student.getStudentNo();
		String phone = student.getPhone();
		String email = student.getEmail();

		//중복체크
		if( duplicateCheck(studentNo, phone, email) > 0 ) {
			throw new NullPointerException(Message.STUDENT_DUPLICATE.getMessage());
		}

		return studentMasterMapper.insertStudent(student);
	}

	@Override
	public List<ResDepartment> selectDepartment() {
		return studentReadMapper.selectDepartment();
	}

	@Override
	public int duplicateCheck(String studentNo, String phone, String email) {
		return studentReadMapper.duplicateCheck(studentNo, phone, email);
	}

}
