package net.skhu.dto.res;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResReply {

	private int reply_seq;
	private int notice_seq;
	private int parent_id;
	private int depth;
	private String reply_content;
	private String reply_writer;
	private String reply_password;
	private Date reply_date;

}
