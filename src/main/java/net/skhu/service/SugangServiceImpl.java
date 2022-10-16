package net.skhu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.skhu.dto.Message;
import net.skhu.dto.req.ReqSugang;
import net.skhu.dto.res.ResLecture;
import net.skhu.dto.res.ResStudent;
import net.skhu.mapper.SugangMapper;

@Service
public class SugangServiceImpl implements SugangService{

	private final SugangMapper sugangMapper;

	public SugangServiceImpl(SugangMapper sugangMapper) {
		this.sugangMapper = sugangMapper;
	}

	@Override
	public List<ResStudent> studentSugangList(int id) {
		List<ResStudent> students = sugangMapper.studentSugangList(id);

		if (students.size() == 0) {
			throw new IllegalArgumentException(Message.NOT_FOUND_STUDENT_SUGANG.getMessage());
		}

		return students;
	}


	@Override
	public List<ResLecture> sugangList(){
		List<ResLecture> sugangs = sugangMapper.sugangList();

		if (sugangs.size() == 0) {
			throw new NullPointerException(Message.NOT_FOUND_SUGANG.getMessage());
		}

		return sugangs;
	}


	@Override
	@Transactional
	public synchronized int insertSugang(ReqSugang sugang) {
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
			return sugangMapper.insertSugang(sugang);
		}
		else {
			throw new NullPointerException(Message.SUGANG_FULL.getMessage());
		}
	}

	@Override
	public int studentCredit(int studentId, int year, int semester) {
		return sugangMapper.studentCredit(studentId, year, semester);
	}

	@Override
	public int deleteSugang(int studentId, int lectureId) {
		return sugangMapper.deleteSugang(studentId, lectureId);
	}

	@Override
	public int duplicateCheck(int studentId, int year, int semester, int lectureId) {
		return sugangMapper.duplicateCheck(studentId, year, semester, lectureId);
	}

	@Override
	public String countSugang(int year, int semester, int lectureId) {
		return sugangMapper.countSugang(year, semester, lectureId);
	}

}
