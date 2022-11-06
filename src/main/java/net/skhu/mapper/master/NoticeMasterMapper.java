package net.skhu.mapper.master;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.req.ReqNotice;

@Mapper
public interface NoticeMasterMapper {
	// 공지사항 추가
	int insertNotice(ReqNotice notice);

	// 조회수 증가
	int viewCnt(int seq);

	// 공지사항 수정
	int updateNotice(ReqNotice notice);

	// 공지사항 삭제
	int deleteNotice(int seq);
}
