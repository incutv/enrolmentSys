package net.skhu.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Notice implements Serializable {
	private static final long serialVersionUID = 1L;

	int seq;
	String subject;
	String contents;
	Date date;
	Date start_date;
	Date end_date;
	int views;
	String writer;
}
