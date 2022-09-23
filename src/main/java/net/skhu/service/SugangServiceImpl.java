package net.skhu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.skhu.dto.Lecture;
import net.skhu.dto.Student;
import net.skhu.dto.Sugang;
import net.skhu.mapper.SugangMapper;

@Service
public class SugangServiceImpl implements SugangService{

	private final SugangMapper sugangMapper;

	public SugangServiceImpl(SugangMapper sugangMapper) {
		this.sugangMapper = sugangMapper;
	}

	@Override
	public List<Student> studentSugangList(int id) {
		return sugangMapper.studentSugangList(id);
	}


	@Override
	public List<Lecture> sugangList(){
		return sugangMapper.sugangList();
	}

	@Override
	public String countSugang(int lectureId) {
		return sugangMapper.countSugang(lectureId);
	}

	@Override
	public int insertSugang(Sugang sugang) {
		return sugangMapper.insertSugang(sugang);
	}
}
