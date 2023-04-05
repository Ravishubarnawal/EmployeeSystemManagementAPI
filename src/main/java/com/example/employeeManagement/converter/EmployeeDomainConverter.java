package com.example.employeeManagement.converter;

import com.example.employeeManagement.domain.EmployeeDomain;
import com.example.employeeManagement.entity.Employee;

import javax.ws.rs.ext.Provider;
import java.util.function.Function;

@Provider
public class EmployeeDomainConverter implements Function<Employee, EmployeeDomain> {
  @Override
  public EmployeeDomain apply(Employee employee) {
    EmployeeDomain domain = new EmployeeDomain();
    domain.setId(employee.getId());
    domain.setEmpName(employee.getEmpName());
    domain.setEmpEmail(employee.getEmpEmail());
    domain.setEmpPhone(employee.getEmpPhone());
    domain.setJoinDate(employee.getJoinDate());
    domain.setLeaveDate(employee.getLeaveDate());
    domain.setEmpSalary(employee.getEmpSalary());
    return domain;
  }
}
