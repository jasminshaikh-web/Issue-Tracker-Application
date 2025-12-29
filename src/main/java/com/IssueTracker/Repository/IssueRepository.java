package com.IssueTracker.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.IssueTracker.Entity.Issue;


public interface IssueRepository extends JpaRepository<Issue, Long>{

}
