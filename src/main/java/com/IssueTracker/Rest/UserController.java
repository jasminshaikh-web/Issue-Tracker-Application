package com.IssueTracker.IssueTracker.Rest;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IssueTracker.IssueTracker.Request.TeamUserRequest;
import com.IssueTracker.IssueTracker.Response.UserResponse;
import com.IssueTracker.IssueTracker.Response.UserWrapperResponse;
import com.IssueTracker.IssueTracker.service.ProjectService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	ProjectService projectService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addUsera(@RequestBody TeamUserRequest teamUserRequest) throws SQLException{
		 projectService.addUsers(teamUserRequest);
		return new ResponseEntity<>(HttpStatus.OK) ;
	}
	
	@GetMapping("/get/{Id}")
	public ResponseEntity<UserResponse> getUser(@PathVariable Long Id){
		UserResponse response=projectService.getUserByID(Id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/get")
	public ResponseEntity<UserWrapperResponse> getUser(){
		UserWrapperResponse userWrapperResponse=projectService.getUsers();
		return new ResponseEntity<>(userWrapperResponse, HttpStatus.OK);
	}
}
