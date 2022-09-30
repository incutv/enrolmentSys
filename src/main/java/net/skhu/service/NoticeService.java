package net.skhu.service;

import java.util.List;

import net.skhu.dto.req.ReqCriteria;
import net.skhu.dto.req.ReqNotice;
import net.skhu.dto.res.ResNotice;

public interface NoticeService {
	// 공지사항 조회
	List<ResNotice> findAll(ReqCriteria criteria);

	// 공지사항 총 게시글 수
	int countNotice();

	// 공지사항 상세보기
	ReqNotice findOne(int seq);

	// 공지사항 추가
	int insertNotice(ReqNotice notice);

	// 조회수 증가
	int viewCnt(int seq);

	// 공지사항 수정
	int updateNotice(ReqNotice notice);

	// 공지사항 삭제
	int deleteNotice(int seq);

}
