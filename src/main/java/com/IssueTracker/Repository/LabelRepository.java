package com.IssueTracker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IssueTracker.Entity.Label;

	
public interface LabelRepository extends JpaRepository<Label, Long>{

}
