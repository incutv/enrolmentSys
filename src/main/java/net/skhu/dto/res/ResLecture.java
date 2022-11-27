package net.skhu.dto.res;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResLecture {

	private int id;
	private String title;
	private String room;
	private int credit;
	private int professorId;
	private int year;
	private int semester;
	private String seatCnt;
	private String name;
	private int entry;
	private int nowEntry;

	private ResProfessor professor;
}
