package com.IssueTracker.Entity;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users", schema = "issue_tracker")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToMany(mappedBy = "members")
    @JsonIgnore
    private Set<Team> teams = new HashSet<>();

    @ManyToMany(mappedBy = "users")
    @JsonIgnore
    private Set<Project> projects = new HashSet<>();
    
    public enum Role {
        ADMIN,
        PROJECT_MANAGER,
        DEVELOPER
    }
}


