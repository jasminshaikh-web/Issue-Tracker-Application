//package com.issue.tracker.issue.tracker.dozer;
//
//import org.springframework.stereotype.Component;
//
//import com.github.dozermapper.core.*;
//import com.github.dozermapper.core.loader.api.BeanMappingBuilder;
//import com.issue.tracker.issue.tracker.Entity.Issue;
//import com.issue.tracker.issue.tracker.Response.IssueResponse;
//@Component
//public class IssueMapper extends BeanMappingBuilder {
//
//	@Override
//	protected void configure() {
//		mapping(Issue.class, IssueResponse.class)
//		.fields("id", "id")
//        .fields("title", "title")
//        .fields("description", "description")
//        .fields("status", "status")
//        .fields("assignee.name", "assignee")
//        .fields("createdAt", "createdAt");
//		}
//
//}
