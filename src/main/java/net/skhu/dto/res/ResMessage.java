package net.skhu.dto.res;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResMessage {

	private String message;
	private String href ;

	public ResMessage() {}

	public ResMessage(String message, String href) {
		this.message = message;
		this.href = href;
	}
}
