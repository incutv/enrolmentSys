package net.skhu.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.skhu.dto.Message;
import net.skhu.dto.req.ReqCriteria;
import net.skhu.dto.req.ReqNotice;
import net.skhu.dto.res.ResNotice;
import net.skhu.mapper.master.NoticeMasterMapper;
import net.skhu.mapper.read.NoticeReadMapper;

@Service
public class NoticeServiceImpl implements NoticeService{

	private NoticeMasterMapper noticeMasterMapper;
	private NoticeReadMapper noticeReadMapper;

	public NoticeServiceImpl(NoticeMasterMapper noticeMasterMapper, NoticeReadMapper noticeReadMapper) {
		this.noticeMasterMapper = noticeMasterMapper;
		this.noticeReadMapper = noticeReadMapper;
	}

	@Override
	@Cacheable(value="findAll" )
	public List<ResNotice> findAll(ReqCriteria criteria) {
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {
			throw new IllegalStateException(e);
		}

		//List<Map<String, String>> notices =noticeMapper.findAll(criteria);
		List<ResNotice> notices =noticeReadMapper.findAll(criteria);

		if ( notices.size() == 0) {
			throw new IllegalArgumentException(Message.NOT_FOUND_LIST.getMessage());
		}

		return notices;
	}

	@Override
	@Cacheable(value="countNotice")
	public int countNotice() {
		return noticeReadMapper.countNotice();
	}

	@Override
	public ResNotice findOne(int seq) {
		ResNotice notice = noticeReadMapper.findOne(seq);

		if (notice == null) {
			throw new IllegalArgumentException(Message.NOT_FOUND_ONE.getMessage());
		}

		return notice;
	}

	@Override
	@Transactional
//	@CacheEvict(value="findAll")
	@Caching(evict = {
		@CacheEvict(value="findAll", allEntries=true),
		@CacheEvict(value="countNotice", allEntries=true)
	})
	public int insertNotice(ReqNotice notice) {
		return noticeMasterMapper.insertNotice(notice);
	}

	@Override
	public int viewCnt(int seq) {
		return noticeMasterMapper.viewCnt(seq);
	}

	@Override
	@Transactional
	@Caching(evict = {
			@CacheEvict(value="findAll", allEntries=true),
			@CacheEvict(value="countNotice", allEntries=true)
		})
	public int updateNotice(ReqNotice notice) {
		return noticeMasterMapper.updateNotice(notice);
	}

	@Override
	@Transactional
	@Caching(evict = {
			@CacheEvict(value="findAll", allEntries=true),
			@CacheEvict(value="countNotice", allEntries=true)
		})
	public int deleteNotice(int seq) {
		return noticeMasterMapper.deleteNotice(seq);
	}

}
