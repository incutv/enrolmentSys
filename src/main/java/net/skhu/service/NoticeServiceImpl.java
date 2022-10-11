package net.skhu.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.skhu.dto.Message;
import net.skhu.dto.req.ReqCriteria;
import net.skhu.dto.req.ReqNotice;
import net.skhu.dto.res.ResNotice;
import net.skhu.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService{

	private final NoticeMapper noticeMapper;

	public NoticeServiceImpl(NoticeMapper noticeMapper) {
		this.noticeMapper = noticeMapper;
	}

	@Override
	@Cacheable(cacheNames="findAll")
	public List<ResNotice> findAll(ReqCriteria criteria) {
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {
			throw new IllegalStateException(e);
		}

		//List<Map<String, String>> notices =noticeMapper.findAll(criteria);
		List<ResNotice> notices =noticeMapper.findAll(criteria);

		if ( notices.size() == 0) {
			throw new IllegalArgumentException(Message.NOT_FOUND_LIST.getMessage());
		}

		return notices;
	}

	@Override
	@Cacheable(cacheNames="countNotice")
	public int countNotice() {
		return noticeMapper.countNotice();
	}

	@Override
	public ResNotice findOne(int seq) {
		ResNotice notice = noticeMapper.findOne(seq);

		if (notice == null) {
			throw new IllegalArgumentException(Message.NOT_FOUND_ONE.getMessage());
		}

		return notice;
	}

	@Override
	public int insertNotice(ReqNotice notice) {
		return noticeMapper.insertNotice(notice);
	}

	@Override
	public int viewCnt(int seq) {
		return noticeMapper.viewCnt(seq);
	}

	@Override
	@Transactional
	public int updateNotice(ReqNotice notice) {
		return noticeMapper.updateNotice(notice);
	}

	@Override
	@Transactional
	public int deleteNotice(int seq) {
		return noticeMapper.deleteNotice(seq);
	}

}
