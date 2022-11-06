package net.skhu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.skhu.dto.Message;
import net.skhu.dto.req.ReqSugang;
import net.skhu.dto.res.ResLecture;
import net.skhu.dto.res.ResStudent;
import net.skhu.mapper.master.SugangMasterMapper;
import net.skhu.mapper.read.SugangReadMapper;

@Service
public class SugangServiceImpl implements SugangService{

	private SugangMasterMapper sugangMasterMapper;
	private SugangReadMapper sugangReadMapper;

	public SugangServiceImpl(SugangMasterMapper sugangMasterMapper, SugangReadMapper sugangReadMapper) {
		this.sugangMasterMapper = sugangMasterMapper;
		this.sugangReadMapper = sugangReadMapper;
	}

	@Override
	public List<ResStudent> studentSugangList(int id) {
		List<ResStudent> students = sugangReadMapper.studentSugangList(id);

		if (students.size() == 0) {
			throw new IllegalArgumentException(Message.NOT_FOUND_STUDENT_SUGANG.getMessage());
		}

		return students;
	}


	@Override
	public List<ResLecture> sugangList(){
		List<ResLecture> sugangs = sugangReadMapper.sugangList();

		if (sugangs.size() == 0) {
			throw new NullPointerException(Message.NOT_FOUND_SUGANG.getMessage());
		}

		return sugangs;
	}


	@Override
	@Transactional
	public synchronized void insertSugang(ReqSugang sugang) {
		int studentId = sugang.getStudentId();
		int year = sugang.getYear();
		int semester = sugang.getSemester();
		int lectureCredit = sugang.getCredit();
		int lectureId = sugang.getLectureId();

		//중복체크
		if( duplicateCheck(studentId, year, semester, lectureId) > 0 ) {
			throw new NullPointerException(Message.SUGANG_DUPLICATE.getMessage());
		}

		//최대학점 체크
		if ( studentCredit(studentId, year, semester) + lectureCredit > 20 ) {
			throw new NullPointerException(Message.SUGANG_CREDIT_FULL.getMessage());
		}

		//해당과목 자리 비었나 한번더 확인
		if ( countSugang(year, semester, lectureId).equals("OK")) {
			sugangMasterMapper.insertSugang(sugang);
		}
		else {
			throw new NullPointerException(Message.SUGANG_FULL.getMessage());
		}
	}

	@Override
	public int studentCredit(int studentId, int year, int semester) {
		return sugangReadMapper.studentCredit(studentId, year, semester);
	}

	@Override
	public int deleteSugang(int studentId, int lectureId) {
		return sugangMasterMapper.deleteSugang(studentId, lectureId);
	}

	@Override
	public int duplicateCheck(int studentId, int year, int semester, int lectureId) {
		return sugangReadMapper.duplicateCheck(studentId, year, semester, lectureId);
	}

	@Override
	public String countSugang(int year, int semester, int lectureId) {
		return sugangReadMapper.countSugang(year, semester, lectureId);
	}

}
