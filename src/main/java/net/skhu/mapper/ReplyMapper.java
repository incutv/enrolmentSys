package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.req.ReqReply;
import net.skhu.dto.res.ResReply;

@Mapper
public interface ReplyMapper {

	List<ResReply> selectReply(int seq, int amount, int pageNum);
	int countReply(int seq);
	int insertReply(ReqReply reply);
	int updateReply(ReqReply reply);
	int deleteReply(int seq);
}
