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
	public String countSugang(int lectureId) {
		return sugangMapper.countSugang(lectureId);
	}

	@Override
	@Transactional
	public synchronized int insertSugang(ReqSugang sugang) {
		int credit = studentCredit(sugang.getStudentId(), sugang.getYear(), sugang.getSemester()) + sugang.getCredit();

		//최대학점 체크
		if ( credit > 20 ) {
			throw new NullPointerException(Message.SUGANG_CREDIT_FULL.getMessage());
		}

		//해당과목 자리 비었나 한번더 확인
		if ( countSugang(sugang.getLectureId()).equals("OK")) {
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
}
