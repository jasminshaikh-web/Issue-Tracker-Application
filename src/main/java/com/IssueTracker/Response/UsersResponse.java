package com.IssueTracker.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersResponse {
	 private Long id;
	 private String name;
	 private String role;
//	 private String title;
	 
}
