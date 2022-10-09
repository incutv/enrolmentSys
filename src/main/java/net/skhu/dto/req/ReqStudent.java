package net.skhu.dto.req;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqStudent {

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
}
