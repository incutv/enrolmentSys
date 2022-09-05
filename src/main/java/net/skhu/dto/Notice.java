package net.skhu.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Notice {
	int seq;
	String subject;
	String contents;
	Date date;
	Date start_date;
	Date end_date;
	String views;
	String writer;

}
