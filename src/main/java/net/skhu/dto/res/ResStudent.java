package net.skhu.dto.res;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResStudent {

	private int id;
	private String studentNo;
	private String name;
	private int departmentId;
	private String phone;
	private String sex;
	private String email;
	private String seatCnt;
	private String password;
	private Date update_date;

	private String title;
	private int credit;
	private String room;
	private int lectureId;

	private ResSugang sugang;
	private ResProfessor professor;
	private List<ResLecture> lecture;
	private ResDepartment department;
}
