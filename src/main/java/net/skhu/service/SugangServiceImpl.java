package net.skhu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
			throw new IllegalArgumentException("학생의 수강신청목록이 없습니다.");
		}

		return students;
	}


	@Override
	public List<ResLecture> sugangList(){
		List<ResLecture> sugangs = sugangMapper.sugangList();

		if (sugangs.size() == 0) {
			throw new NullPointerException("수강신청할 과목이 없습니다.");
		}

		return sugangs;
	}

	@Override
	public String countSugang(int lectureId) {
		return sugangMapper.countSugang(lectureId);
	}

	@Override
	@Transactional
	public int insertSugang(ReqSugang sugang) {
		return sugangMapper.insertSugang(sugang);
	}
}
