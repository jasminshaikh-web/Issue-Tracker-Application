package com.IssueTracker.Service;
import com.IssueTracker.Request.CreateIssueRequest;
import com.IssueTracker.Request.UpdateIssueRequest;
import com.IssueTracker.Response.IssueResponse;
import com.IssueTracker.Response.ProjectResponse;

public interface IssueServices{
	    IssueResponse createIssue(CreateIssueRequest request);
	    IssueResponse getIssues(Long id);
	    ProjectResponse getProject(Long id);
	    IssueResponse updateIssue(Long id, UpdateIssueRequest updateIssueRequest);
	}

