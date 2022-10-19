package net.skhu.dto.req;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqStudent {

	private String studentNo;
	private String name;
	private int departmentId;
	private String phone;
	private String sex;
	private String email;
	private String password;

}
