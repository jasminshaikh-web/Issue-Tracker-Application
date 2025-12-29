package com.IssueTracker.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
	@Table(name = "teams", schema = "issue_tracker")
	@Data	
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public class Team {
	    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(unique = true)
	    private String name;

	    @ManyToMany
	    @JoinTable(
	        name = "team_users",
	        joinColumns = @JoinColumn(name = "team_id"),
	        inverseJoinColumns = @JoinColumn(name = "user_id")
	    )
	    private Set<Users> members = new HashSet<>();
	}

