//package com.IssueTracker.dozer;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.dozer.CustomConverter;
//
//import com.IssueTracker.IssueTracker.Entity.Users;
//import com.IssueTracker.IssueTracker.Request.TeamUserRequest; 
//
//public class TeamUserCustomConverter implements CustomConverter{
//
//  @Override
//  public Object convert(Object existingDestinationFieldValue, Object sourceFieldValue, Class<?> destinationClass,
//          Class<?> sourceClass) {
//      if(sourceFieldValue instanceof List) {
//          List<TeamUserRequest> memberRequests=(List<TeamUserRequest>) sourceFieldValue;
//          if(existingDestinationFieldValue instanceof List) {
//              List<Users> existingTeamList=(List<Users>) existingDestinationFieldValue;
//              existingTeamList.clear();    
//              memberRequests.forEach(
//                  teammemberrequest->existingTeamList.add(Users.builder()
//                          .name(teammemberrequest.getName())
//                          .email(teammemberrequest.getEmail())
//                          .designation(teammemberrequest.getDesignation())
//                          .build()));
//              return existingTeamList;
//          }else {
//              List<Users> newUsers=new ArrayList<>();
//              memberRequests.forEach(memberRequest->newUsers.add(Users.builder()
//                      .name(memberRequest.getName())
//                      .email(memberRequest.getEmail())
//                      .designation(memberRequest.getDesignation())
//                      .build()));
//              return newUsers;
//          }
//      }else {
//          List<Users> exsistingUsers=(List<Users>)existingDestinationFieldValue;
//          exsistingUsers.clear();
//          return exsistingUsers;
//      }
//  }
//  
//
//}