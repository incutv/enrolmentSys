package net.skhu.service;

import java.util.List;

import net.skhu.dto.Reply;

public interface ReplyService {
	// 댓글 조회
	List<Reply> selectReply(int seq);
}
