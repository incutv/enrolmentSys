package net.skhu.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import net.skhu.dto.Criteria;
import net.skhu.dto.Notice;
import net.skhu.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService{

	private final NoticeMapper noticeMapper;

	public NoticeServiceImpl(NoticeMapper noticeMapper) {
		this.noticeMapper = noticeMapper;
	}

	@Override
	@Cacheable(cacheNames="getList")
	public List<Notice> findAll(Criteria criteria) {
		return noticeMapper.findAll(criteria);
	}

	@Override
	@Cacheable(cacheNames="getList")
	public int countNotice() {
		return noticeMapper.countNotice();
	}

	@Override
	public Notice findOne(int seq) {
		return noticeMapper.findOne(seq);
	}

	@Override
	public int insertNotice(Notice notice) {
		return noticeMapper.insertNotice(notice);
	}

	@Override
	public int viewCnt(int seq) {
		return noticeMapper.viewCnt(seq);
	}

	@Override
	public int updateNotice(Notice notice) {
		return noticeMapper.updateNotice(notice);
	}

	@Override
	public int deleteNotice(int seq) {
		return noticeMapper.deleteNotice(seq);
	}


}
