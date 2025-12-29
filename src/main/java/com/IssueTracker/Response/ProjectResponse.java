package com.IssueTracker.Response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectResponse {
	private Long id;
	private String name;
	private String description;
	private String createdBy;
	private LocalDateTime createdAt;
//	private List<UsersResponse> users;
	private List<IssueResponse> issues;
}
