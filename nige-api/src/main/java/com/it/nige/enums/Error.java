package com.it.nige.enums;

public enum Error {
	SUCCESS(100,"성공적으로 수행했습니다.",200),
	DATABASE_UPDATE_FAIL(200,"데이터베이스 커밋 실패", 500)
	;
	private int code;
	private String message;
	private int statusCode;
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	Error(int code, String message, int statusCode) {
		this.code = code;
		this.message = message;
		this.statusCode = statusCode;
	}
}
