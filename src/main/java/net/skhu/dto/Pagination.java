package net.skhu.dto;

import lombok.Getter;

@Getter
public class Pagination {

	private int startPage;
	private int endPage;
	private boolean prev, next;

	private int total;
	//현재 페이지 번호, 한 페이지에 표출할 데이터 개수
	private Criteria cri;

	public Pagination(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;

		//시작페이지, 마지막페이지 계산
		this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;
		this.startPage = this.endPage -9;

		int realEnd = (int) (Math.ceil(total * 1.0) / cri.getAmount());

		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}

		//이전, 다음 버튼 표출 여부 결정
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}


}
