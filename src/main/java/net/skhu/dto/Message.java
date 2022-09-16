package net.skhu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {

	private String message;
	private String href ;

	public Message(String message, String href) {
		this.message = message;
		this.href = href;
	}
}
