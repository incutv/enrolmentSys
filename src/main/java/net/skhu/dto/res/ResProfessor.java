package net.skhu.dto.res;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResProfessor {

	private int id;
	private String name;
	private int departmentId;
	private String phone;
	private String email;
	private String office;
}
