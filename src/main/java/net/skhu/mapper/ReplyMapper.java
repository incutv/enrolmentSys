package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.req.ReqReply;

@Mapper
public interface ReplyMapper {

	List<ReqReply> selectReply(int seq);


}
