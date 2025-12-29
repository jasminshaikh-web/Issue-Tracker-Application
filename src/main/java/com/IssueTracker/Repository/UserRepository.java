package com.IssueTracker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IssueTracker.Entity.Users;


public interface UserRepository extends JpaRepository<Users, Long>{

}
