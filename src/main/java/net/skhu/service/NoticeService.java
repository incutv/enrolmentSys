package net.skhu.service;

import java.util.List;

import net.skhu.dto.Criteria;
import net.skhu.dto.Notice;

public interface NoticeService {
	// 공지사항 조회
	List<Notice> findAll(Criteria criteria);

	// 공지사항 총 게시글 수
	int countNotice();

	// 공지사항 상세보기
	Notice findOne(int seq);

	// 공지사항 추가
	int insertNotice(Notice notice);

	// 조회수 증가
	int viewCnt(int seq);

	// 공지사항 수정
	int updateNotice(Notice notice);

	// 공지사항 삭제
	int deleteNotice(int seq);

}
