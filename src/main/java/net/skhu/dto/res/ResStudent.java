package net.skhu.dto.res;

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

	private ResSugang sugang;
	private ResProfessor professor;
	private List<ResLecture> lecture;
	private ResDepartment department;
}
