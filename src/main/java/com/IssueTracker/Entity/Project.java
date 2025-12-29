package com.IssueTracker.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

	@Entity
	@Table(name = "projects" , schema = "issue_tracker")
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public class Project {
	    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;
	    private String description;

	    @ManyToOne
	    @JoinColumn(name = "created_by")
	    private Users createdBy;

	    private LocalDateTime createdAt = LocalDateTime.now();

	    @ManyToMany
	    @JoinTable(
	        name = "project_users",
	        joinColumns = @JoinColumn(name = "project_id"),
	        inverseJoinColumns = @JoinColumn(name = "user_id")
	    )
	    @JsonIgnore
	    private Set<Users> users = new HashSet<>();

	    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	    @JsonManagedReference
	    private List<Issue> issues = new ArrayList<>();
	}

