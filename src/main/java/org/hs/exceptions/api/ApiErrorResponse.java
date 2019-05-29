package org.hs.exceptions.api;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiErrorResponse {

	public HttpStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	public LocalDateTime timestamp;
	public String message;
	public String debugMessage;

	public List<ApiSubErrorResponse> subErrors;

	public ApiErrorResponse(HttpStatus status) {
		this.timestamp = LocalDateTime.now();
		this.status = status;
	}

	public ApiErrorResponse(HttpStatus status, Throwable ex) {
		this.timestamp = LocalDateTime.now();
		this.status = status;
		this.message = "Unexpected error";
		this.debugMessage = ex.getLocalizedMessage();
	}

	public ApiErrorResponse(HttpStatus status, String message, Throwable ex) {
		this.timestamp = LocalDateTime.now();
		this.status = status;
		this.message = message;
		this.debugMessage = ex.getLocalizedMessage();
	}

	public void addSubErrorResponse(ApiSubErrorResponse subError) {
		if (subErrors == null) {
			subErrors = new ArrayList<>();
		}
		subErrors.add(subError);
	}
}
