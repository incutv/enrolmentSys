package net.skhu.dto.req;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqCriteria {
	private int pageNum;
	private int amount;
	private int startNum;

	public ReqCriteria() {
		//객체 생성시 기본 생성자를 호출하여 매개변수를 줘서 매개변수를 가지고 있는 생성자 함수 호출
		this(1, 10); //생성자에서 pageNum=1, amount=10으로 설정
	}

	// 기본 생성자 설정
	public ReqCriteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ReqCriteria [pageNum=" + pageNum + ", amount=" + amount + "]";
	}
}
