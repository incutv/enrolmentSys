package net.skhu.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {

	private int id;
	private String studentNo;
	private String name;
	private int departmentId;
	private String phone;
	private String sex;
	private String email;
	private String seatCnt;

	private Sugang sugang;
	private Professor professor;
	private List<Lecture> lecture;
	private Department department;
}
