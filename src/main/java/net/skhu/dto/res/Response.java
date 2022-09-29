package net.skhu.dto.res;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response<T> {
	private String message;
	private String url;
	private T data;
}
