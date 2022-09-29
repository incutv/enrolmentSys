package net.skhu.service;

import java.util.List;

import net.skhu.dto.req.ReqReply;

public interface ReplyService {
	// 댓글 조회
	List<ReqReply> selectReply(int seq);
}
