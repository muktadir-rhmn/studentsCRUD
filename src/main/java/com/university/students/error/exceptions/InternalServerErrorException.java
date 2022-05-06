package com.university.students.error.exceptions;

public class InternalServerErrorException extends RuntimeException {
	public static InternalServerErrorException EMPTY_EXCEPTION = new InternalServerErrorException();

	protected InternalServerErrorException() { }
	public InternalServerErrorException(Throwable throwable) {
		super(throwable);
	}
}
