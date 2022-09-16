package net.skhu.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Notice implements Serializable {
	private static final long serialVersionUID = 1L;

	private int seq;
	private String subject;
	private String contents;
	private Date date;
	private Date start_date;
	private Date end_date;
	private int views;
	private String writer;
}
