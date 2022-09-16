package net.skhu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Lecture {

	private int id;
	private String title;
	private String room;
	private int credit;
	private int professorId;
	private int year;
	private String semaster;

	Professor professor;

}
