package net.skhu.dto.req;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqSugang {

	private int id;
	private int lectureId;
	private int studentId;
	private int cancel;
	private String grade;
	private int year;
	private int semester;
	private int credit;
}
