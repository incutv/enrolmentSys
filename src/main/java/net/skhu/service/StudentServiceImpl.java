package net.skhu.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.skhu.dto.Message;
import net.skhu.dto.req.ReqStudent;
import net.skhu.dto.res.ResDepartment;
import net.skhu.dto.res.ResStudent;
import net.skhu.mapper.StudentMapper;

@Service
public class StudentServiceImpl implements StudentService{

	private StudentMapper studentMapper;
	private PasswordEncoder passwordEncoder;

	public StudentServiceImpl(StudentMapper studentMapper, PasswordEncoder passwordEncoder) {
		this.studentMapper = studentMapper;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public ResStudent loginStudent(ReqStudent reqStudent) {
		ResStudent student = studentMapper.findByStudentNo(reqStudent.getStudentNo());

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

		return studentMapper.insertStudent(student);
	}

	@Override
	public List<ResDepartment> selectDepartment() {
		return studentMapper.selectDepartment();
	}

	@Override
	public int duplicateCheck(String studentNo, String phone, String email) {
		return studentMapper.duplicateCheck(studentNo, phone, email);
	}

}
