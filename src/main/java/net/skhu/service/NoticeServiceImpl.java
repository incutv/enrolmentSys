package net.skhu.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Cacheable(cacheNames="getList")
	public List<ResNotice> findAll(ReqCriteria criteria) {
		List<ResNotice> notices =noticeMapper.findAll(criteria);

		if ( notices.size() == 0) {
			throw new IllegalArgumentException("리스트가 없습니다.");
		}

		return notices;
	}

	@Override
	@Cacheable(cacheNames="getList")
	public int countNotice() {
		return noticeMapper.countNotice();
	}

	@Override
	public ReqNotice findOne(int seq) {
		ReqNotice notice = noticeMapper.findOne(seq);

		if (notice == null) {
			throw new IllegalArgumentException("존재하지 않는 게시물입니다.");
		}

//		try {
//
//		} catch (IllegalArgumentException e) {
//			System.out.println("1");
//		} catch (NullPointerException e) {
//			System.out.println("2");
//		}

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
