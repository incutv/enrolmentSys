package net.skhu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.skhu.dto.Reply;
import net.skhu.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService {

	private final ReplyMapper replyMapper;

	public ReplyServiceImpl(ReplyMapper replyMapper) {
		this.replyMapper = replyMapper;
	}

	@Override
	public List<Reply> selectReply(int seq) {
		return replyMapper.selectReply(seq);
	}


}
