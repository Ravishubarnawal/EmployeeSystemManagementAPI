package com.example.employeeManagement.converter;

import com.example.employeeManagement.domain.EmployeeDomain;
import com.example.employeeManagement.entity.Employee;

import java.util.function.Function;

public class EmployeeEntityConverter implements Function<EmployeeDomain, Employee> {
    @Override
    public Employee apply(EmployeeDomain employeeDomain) {
        Employee entity = new Employee();
        entity.setId(employeeDomain.getId());
        entity.setEmpName(employeeDomain.getEmpName());
        entity.setEmpEmail(employeeDomain.getEmpEmail());
        entity.setEmpPhone(employeeDomain.getEmpPhone());
        entity.setJoinDate(employeeDomain.getJoinDate());
        entity.setLeaveDate(employeeDomain.getLeaveDate());
        entity.setEmpSalary(employeeDomain.getEmpSalary());
        return entity;
    }
}
