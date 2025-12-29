package  com.IssueTracker.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.IssueTracker.Entity.Project;


public interface ProjectRepository extends JpaRepository<Project, Long>{

}
