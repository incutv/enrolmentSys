package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.Reply;

@Mapper
public interface ReplyMapper {

	List<Reply> selectReply(int seq);


}
