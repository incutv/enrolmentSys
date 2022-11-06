package net.skhu.mapper.read;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.req.ReqCriteria;
import net.skhu.dto.res.ResNotice;

@Mapper
public interface NoticeReadMapper {
	// 공지사항 조회
	List<ResNotice> findAll(ReqCriteria cri);

	// 공지사항 총 게시글 수
	int countNotice();

	// 공지사항 상세보기
	ResNotice findOne(int seq);
}
