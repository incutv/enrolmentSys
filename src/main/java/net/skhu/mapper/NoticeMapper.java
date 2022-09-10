package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.Criteria;
import net.skhu.dto.Notice;

@Mapper
@CacheNamespace(flushInterval=60000)	//1분
public interface NoticeMapper {
	// 공지사항 조회
	List<Notice> findAll(Criteria criteria);

	// 공지사항 총 게시글 수
	int count();

	// 공지사항 상세보기
	Notice findOne(int seq);

	// 공지사항 추가
	void insert(Notice notice);

	// 조회수 증가
	void viewCnt(int seq);

	// 공지사항 수정
	void update(Notice notice);

	// 공지사항 삭제
	void delete(int seq);


}
