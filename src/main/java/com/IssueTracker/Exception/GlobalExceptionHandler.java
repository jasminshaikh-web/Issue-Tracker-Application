package com.IssueTracker.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = IssueTrackerException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody IssueTrackerErrorResponse issueTrackerException(IssueTrackerException exception) {
		return new IssueTrackerErrorResponse(HttpStatus.BAD_REQUEST.value(),exception.getMessage());
	}
	
	@ExceptionHandler(value = UserNotFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody IssueTrackerErrorResponse handleException(UserNotFoundException exception) {
		return new IssueTrackerErrorResponse(HttpStatus.BAD_REQUEST.value(),exception.getMessage());
	}
}
