package net.skhu.dto;

import lombok.Getter;

@Getter
public enum Message {

	APPLY_MESSAGE("C1", "등록되었습니다."),
	FAIL_MESSAGE("C2", "작업이 실패하였습니다."),
	EDIT_MESSAGE("C3", "수정되었습니다."),
	DELETE_MESSAGE("C4", "삭제되었습니다."),
	NOT_FOUND_LIST("N1", "리스트가 없습니다."),
	NOT_FOUND_ONE("N2", "존재하지 않는 게시물입니다."),
	NOT_FOUND_STUDENT_SUGANG("S1", "학생의 수강신청목록이 없습니다."),
	NOT_FOUND_SUGANG("S2", "수강신청할 과목이 없습니다."),
	SUGANG_FULL("S3", "수강할 과목의 정원이 가득 찼습니다.");

	private String code;
	private String message;

	private Message(String code, String message) {
		this.code = code;
		this.message = message;
	}

}
