package com.IssueTracker.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	@Table(name = "issues", schema = "issue_tracker")
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public class Issue {
	    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String title;

	    @Column(columnDefinition = "TEXT")
	    private String description;

	    @ManyToOne
	    @JoinColumn(name = "status_id")
	    private Status status;

	    @ManyToOne
	    @JoinColumn(name = "project_id")
	    @JsonBackReference
	    private Project project;

	    @ManyToOne
	    @JoinColumn(name = "assignee_id")
	    private Users assignee;

	    @ManyToOne
	    @JoinColumn(name = "reporter_id")
	    private Users reporter;

	    @Enumerated(EnumType.STRING)
	    private Priority priority;

	    private LocalDate dueDate;
	    private LocalDateTime createdAt = LocalDateTime.now();

	    @ManyToMany
	    @JoinTable(
	        name = "issue_labels",
	        joinColumns = @JoinColumn(name = "issue_id"),
	        inverseJoinColumns = @JoinColumn(name = "label_id")
	    )
	    private Set<Label> labels = new HashSet<>();

	    @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL)
	    private List<Comment> comments = new ArrayList<>();
	    
	    public enum Priority {
		    LOW,
		    MEDIUM,
		    HIGH,
		    CRITICAL
		}
	}

	

