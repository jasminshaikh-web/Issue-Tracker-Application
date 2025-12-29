package com.IssueTracker.IssueTracker.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IssueTracker.IssueTracker.Request.IssueRequest;
import com.IssueTracker.IssueTracker.Response.ApiResponse;
import com.IssueTracker.IssueTracker.Response.IssueResponse;
import com.IssueTracker.IssueTracker.Response.IssueWrapperResponse;
import com.IssueTracker.IssueTracker.service.IssueService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/issue")
public class IssueController {

	public IssueController(IssueService issueService) {
		super();
		this.issueService = issueService;
	}
	@Autowired
	private IssueService issueService;
	
	/*
	 * API to add issue details 
	 */
	@PostMapping("/add")
	public ResponseEntity<ApiResponse> saveIssue(@Valid @RequestBody IssueRequest issueRequest) {
		issueService.addIssues(issueRequest);
		ApiResponse apiResponse=new ApiResponse("Issue Created.", HttpStatus.CREATED.value());
		return ResponseEntity.ok(apiResponse);
	}
	/*
	 * API to get Issue details based on id 
	 */
	
	@GetMapping("/get/{Id}")
	public ResponseEntity<IssueResponse> getIssues(@PathVariable Long Id) {
		IssueResponse issueResponses=issueService.getIssue(Id);
		return new ResponseEntity<>(issueResponses,HttpStatus.OK) ;
	}
	/*
	 * API to get Issue details 
	 */
	
	@GetMapping("/get")
	public ResponseEntity<IssueWrapperResponse> getData() {
		IssueWrapperResponse response= issueService.getData();
		return new ResponseEntity<>(response, HttpStatus.OK) ;
	}
}
