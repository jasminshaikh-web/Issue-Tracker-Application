package com.IssueTracker.Exception;

public class IssueException extends RuntimeException {
	private String message;

    public IssueException() {}

    public IssueException(String msg) {
        super(msg);
        this.message = msg;
}
}
