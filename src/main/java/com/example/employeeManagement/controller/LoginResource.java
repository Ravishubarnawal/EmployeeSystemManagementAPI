package com.example.employeeManagement.controller;

import com.example.employeeManagement.domain.EmployeeDomain;
import com.example.employeeManagement.entity.LoginRequest;
import com.example.employeeManagement.exception.ApplicationException;
import com.example.employeeManagement.service.EmployeeService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
    @Path("/login")
    public class LoginResource {
        @Inject
        private EmployeeService  employeeService  ;
        @POST
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public Response login(LoginRequest loginRequest) {
            boolean employeeDomain= employeeService.login(loginRequest.getName(),loginRequest.getEmail());
            if(employeeDomain==false){
                throw new ApplicationException("Unauthorized User");
        }
          return Response.ok().entity(employeeDomain).build();

    }

}
