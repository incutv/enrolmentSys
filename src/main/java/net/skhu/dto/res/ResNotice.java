package net.skhu.dto.res;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResNotice  {
	private int seq;
	private String subject;
	private String contents;
	private Date date = new Date();
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date start_date = new Date();
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date end_date = new Date();
	private int views;
	private String writer;
}
