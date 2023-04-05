package com.example.employeeManagement.controller;

import com.example.employeeManagement.domain.EmployeeDomain;
import com.example.employeeManagement.service.EmployeeService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {

  private EmployeeService employeeService;

  @Inject
  public EmployeeResource(EmployeeService employeeService)  {
    this.employeeService = employeeService;
  }

  public EmployeeResource() {}

  @GET
  public Response getAll() {
    List<EmployeeDomain> employeeList = employeeService.getAll();
    return Response.ok().entity(employeeList).build();
  }

  @POST
  public Response createEmployee(EmployeeDomain employeeDomain) {
    EmployeeDomain employeeAdd = employeeService.add(employeeDomain);
    return Response.ok().entity(employeeAdd).build();
  }

  @PUT
  @Path("/{empId}")
  public Response updateEmployeeById(@PathParam("empId") int id, EmployeeDomain employeeDomain) {
    EmployeeDomain empDomainUpdate = employeeService.updateById(id, employeeDomain);
    return Response.ok().entity(empDomainUpdate).build();
  }

  @Path("/{empId}")
  @DELETE
  public void deleteEmployee(@PathParam("empId") int id) {
    employeeService.deleteById(id);
  }

  @GET
  @Path("/{empId}")
  public EmployeeDomain getById(@PathParam("empId") int id) {
    return employeeService.getById(id);
  }
}
