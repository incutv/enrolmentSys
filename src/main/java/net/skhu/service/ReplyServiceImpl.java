package net.skhu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.skhu.dto.req.ReqReply;
import net.skhu.dto.res.ResReply;
import net.skhu.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService {

	private final ReplyMapper replyMapper;

	public ReplyServiceImpl(ReplyMapper replyMapper) {
		this.replyMapper = replyMapper;
	}

	@Override
	public List<ResReply> selectReply(int seq, int amount, int pageNum) {
		return replyMapper.selectReply(seq, amount, pageNum);
	}

	@Override
	public int countReply(int seq) {
		return replyMapper.countReply(seq);
	}

	@Override
	public int insertReply(ReqReply reply) {
		return replyMapper.insertReply(reply);
	}

	@Override
	public int updateReply(ReqReply reply) {
		return replyMapper.updateReply(reply);
	}

	@Override
	public int deleteReply(int seq) {
		return replyMapper.deleteReply(seq);
	}




}
