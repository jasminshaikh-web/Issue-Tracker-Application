package com.IssueTracker.dozer;
import com.IssueTracker.Request.*;
import com.IssueTracker.Entity.Issue;
import com.IssueTracker.Response.IssueResponse;
import com.github.dozermapper.core.loader.api.BeanMappingBuilder;
import com.github.dozermapper.core.loader.api.FieldsMappingOptions;

public class IssueDozer extends BeanMappingBuilder {

    @Override
    protected void configure() {

        mapping(Issue.class, IssueResponse.class)
        .fields("assigneeId.id", "assigneeId")
        .fields("reporterId.id", "reporterId")
        .fields("status", "status")
        .fields("priorityLevel", "priorityLevel")
        .fields("createdBy.id", "createdById")
        .fields("createdDate", "createdDate",FieldsMappingOptions.copyByReference())
        .fields("activatedDate", "activatedDate",FieldsMappingOptions.copyByReference())
        .fields("projectId", "projectResponse");
        
        mapping(IssueRequest.class, Issue.class)
        .fields("assigneeId","assigneeId.id")
        .fields("reporterId","reporterId.id")
        .fields("status","status")
        .fields("storyPoint","storyPoint")
        .fields("priorityLevel","priorityLevel")
        .fields("createdById","createdBy.id")
        .fields("projectId", "projectId.id");    
        }
}