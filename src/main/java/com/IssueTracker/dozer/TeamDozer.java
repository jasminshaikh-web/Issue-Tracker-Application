package com.IssueTracker.dozer;


import com.IssueTracker.IssueTracker.Request.TeamUserRequest;
import com.IssueTracker.IssueTracker.Response.UserResponse;
import com.IssueTracker.Entity.Users;
import com.github.dozermapper.core.loader.api.BeanMappingBuilder;

public class TeamDozer extends BeanMappingBuilder{

    @Override
    protected void configure() {
//        mapping(TeamMemberRequest.class, TeamMember.class)
//        .fields("teamId","teamId.id")
//        .fields("teamUsers","teamUsers",FieldsMappingOptions.customConverter(TeamUserCustomConverter.class));
//        
        mapping(TeamUserRequest.class, Users.class)
        .fields("name", "name")
        .fields("email","email")
        .fields("designation","designation");
        
        mapping(Users.class, UserResponse.class)
        .fields("name", "name")
        .fields("email","email")
        .fields("designation","designation");
    }

}