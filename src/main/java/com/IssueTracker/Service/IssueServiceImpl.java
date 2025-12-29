package com.IssueTracker.Service;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.IssueTracker.Entity.Issue;
import com.IssueTracker.Entity.Label;
import com.IssueTracker.Entity.Project;
import com.IssueTracker.Entity.Status;
import com.IssueTracker.Entity.Users;
import com.IssueTracker.Exception.IssueException;
import com.IssueTracker.Repository.IssueRepository;
import com.IssueTracker.Repository.LabelRepository;
import com.IssueTracker.Repository.ProjectRepository;
import com.IssueTracker.Repository.StatusRepository;
import com.IssueTracker.Repository.UserRepository;
import com.IssueTracker.Request.CreateIssueRequest;
import com.IssueTracker.Request.UpdateIssueRequest;
import com.IssueTracker.Response.IssueResponse;
import com.IssueTracker.Response.ProjectResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IssueServiceImpl implements IssueServices {

	private final IssueRepository issueRepository;
	private final ProjectRepository projectRepository;
	private final UserRepository userRepository;
	private final StatusRepository statusRepository;
	private final LabelRepository labelRepository;

	@Override
	public IssueResponse createIssue(CreateIssueRequest request) {
		
		Project project = projectRepository.findById(request.getProjectId())
				.orElseThrow(() -> new IssueException("Project not found"));
		
		Users assignee = userRepository.findById(request.getAssigneeId())
				.orElseThrow(() -> new IssueException("Assignee not found"));
		
		Users reporter = userRepository.findById(request.getReporterId())
				.orElseThrow(() -> new IssueException("Reporter not found"));
		
		Status status = statusRepository.findById(request.getStatusId())
				.orElseThrow(() -> new IssueException("Status not found"));

		Set<Label> labels = new HashSet<>();
//		labels=request.getLabelIds().stream().collect(Collectors.toSet();
		if (request.getLabelIds() != null) {
			labels = labelRepository.findAllById(request.getLabelIds()).stream().collect(Collectors.toSet());
		}
		
//		Project project2=Project.builder().id(request.getProjectId()).build();
//		Users users=Users.builder().id(request.getAssigneeId()).build();
//		Users users2=Users.builder().id(request.getReporterId()).build();
//		Status status2=Status.builder().id(request.getStatusId()).build();

		Issue issue = Issue.builder().title(request.getTitle()).description(request.getDescription()).project(project)
				.assignee(assignee).reporter(reporter).status(status).priority(request.getPriority())
				.dueDate(request.getDueDate()).labels(labels).createdAt(LocalDateTime.now()).build();

		issueRepository.save(issue);

		return IssueResponse.builder()
							.id(issue.getId())
							.title(issue.getTitle())
							.description(issue.getDescription())
							.status(status.getName())
							.assignee(assignee.getName())
							.reporter(reporter.getName())
							.priority(issue.getPriority())
							.dueDate(issue.getDueDate())
							.createdAt(issue.getCreatedAt())
							.build();
	}

	@Override
	public IssueResponse getIssues(Long id) {
		Issue issue = issueRepository.findById(id)
                .orElseThrow(() -> new IssueException("Issue not found with id: " + id));
		return IssueResponse.builder()
                .id(issue.getId())
                .assignee(issue.getAssignee().getName())
                .reporter(issue.getReporter().getName())
                .priority(issue.getPriority())
                .dueDate(issue.getDueDate())
                .title(issue.getTitle())
                .description(issue.getDescription())
                .status(issue.getStatus().getName())
                .createdAt(issue.getCreatedAt())
                .build();
	}

	@Override
	public ProjectResponse getProject(Long id) {
		Project project=projectRepository.findById(id)
				.orElseThrow(()->new IssueException("Project not found for project id :"+id));
		List<IssueResponse> issueDtos = project.getIssues().stream().map(issue ->
		IssueResponse.builder()
					.id(issue.getId())
					.title(issue.getTitle())
					.description(issue.getDescription())
					.status(issue.getStatus().getName())
					.assignee(issue.getAssignee().getName())
					.reporter(issue.getReporter().getName())
					.priority(issue.getPriority())
					.dueDate(issue.getDueDate())
					.createdAt(issue.getCreatedAt())            
            .build()
    ).collect(Collectors.toList());
		
//		List<UsersResponse> usersResponses=project.getUsers().stream().map(user->
//		UsersResponse.builder()
//		.id(user.getId())
//		.name(user.getName())
//		.role(user.getRole().name())
//		.build()
//		).collect(Collectors.toList());
		
		return ProjectResponse.builder()
				.id(project.getId())
				.createdAt(project.getCreatedAt())
				.createdBy(project.getCreatedBy().getName())
				.description(project.getDescription())
				.issues(issueDtos)
				.name(project.getName())
//				.users(usersResponses)
				.build();
	}
	
	@Override
	public IssueResponse updateIssue(Long id, UpdateIssueRequest updateIssueRequest) {
		Optional<Issue> existingIssue= issueRepository.findById(id);
		if(existingIssue==null) {
			throw new IssueException("Issue Not found");
		}
			Issue issue=existingIssue.get();
			issue.setTitle(updateIssueRequest.getTitle());
			issue.setDescription(updateIssueRequest.getDescription());

		if(updateIssueRequest.getProjectId()!=null){
			Project project = projectRepository.findById(updateIssueRequest.getProjectId())
										.orElseThrow(()->new IssueException("Project not found"));
			issue.setProject(project);
		}
		if(updateIssueRequest.getAssigneeId()!=null) {
			Users assignee = userRepository.findById(updateIssueRequest.getAssigneeId())
							.orElseThrow(()-> new IssueException("Assignee not found."));
			issue.setAssignee(assignee);
		}
		if(updateIssueRequest.getReporterId()!=null) {
			Users reporter = userRepository.findById(updateIssueRequest.getReporterId())
							.orElseThrow(()->new IssueException("Reporter not found"));
			issue.setReporter(reporter);
		}
		if(updateIssueRequest.getStatusId()!=null) {
			Status status = statusRepository.findById(updateIssueRequest.getStatusId())
							.orElseThrow(()-> new IssueException("Status not found"));
			issue.setStatus(status);
		}

		issueRepository.save(issue);
		return IssueResponse. builder()
				.id(issue.getId())
				.title(issue.getTitle())
				.description(issue.getDescription())
				.status(issue.getStatus().getName())
				.assignee(issue.getAssignee().getName())
				.reporter(issue.getReporter().getName())
				.priority(issue.getPriority())
				.dueDate(issue.getDueDate())
				.createdAt(issue.getCreatedAt())
				.build();
	
	}
	}
