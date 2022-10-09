package net.skhu.service;

import java.util.List;

import net.skhu.dto.req.ReqReply;
import net.skhu.dto.res.ResReply;

public interface ReplyService {
	//댓글 조회
	List<ResReply> selectReply(int seq, int amount, int pageNum);

	//댓글 카운팅
	int countReply(int seq);

	//댓글 저장
	int insertReply(ReqReply reply);

	//댓글 수정
	int updateReply(ReqReply reply);

	//댓글 삭제
	int deleteReply(int seq);
}
