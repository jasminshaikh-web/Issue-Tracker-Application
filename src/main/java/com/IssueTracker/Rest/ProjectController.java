package com.IssueTracker.IssueTracker.Rest;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.IssueTracker.IssueTracker.Entity.Team;
import com.IssueTracker.IssueTracker.Request.ProjectRequest;
import com.IssueTracker.IssueTracker.Request.TeamRequest;
import com.IssueTracker.IssueTracker.Response.ProjectResponse;
import com.IssueTracker.IssueTracker.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	private ProjectController(ProjectService projectService) {
		super();
		this.projectService = projectService;
	}
	/*
	 * API to get project details by ID 
	 */
	@GetMapping(value = "/get/{Id}")
	public ResponseEntity<ProjectResponse> getIssues(@PathVariable Long Id) {
		ProjectResponse projectResponse=projectService.getProject(Id);
		
		return new ResponseEntity<>(projectResponse,HttpStatus.OK) ;
	}

	/* 
	 * API to add project 
	 */
	@PostMapping("/add")
	public ResponseEntity<ProjectRequest> addProject(@RequestBody ProjectRequest projectRequest) throws SQLException{
		projectService.addProject(projectRequest);
		return new ResponseEntity<>(HttpStatus.OK);		
	}
	/*
	 * API to add team 
	 */
	@PostMapping("/addTeam")
	public ResponseEntity<Team> addTeam(@RequestBody TeamRequest teamRequest){
		Team teamName= projectService.addTeam(teamRequest);
		return new ResponseEntity<>(teamName,HttpStatus.OK);				
	}
}
