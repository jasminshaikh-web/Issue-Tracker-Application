package com.IssueTracker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IssueTracker.Entity.Status;


public interface StatusRepository extends JpaRepository<Status, Long>{

}
