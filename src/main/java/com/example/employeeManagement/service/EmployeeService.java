package com.example.employeeManagement.service;

import com.example.employeeManagement.domain.EmployeeDomain;
import com.example.employeeManagement.entity.Employee;

import java.util.List;

public interface EmployeeService {
  EmployeeDomain add(EmployeeDomain employeeDomain);

  List<EmployeeDomain> getAll();

  EmployeeDomain getById(int id);

  EmployeeDomain updateById(int id, EmployeeDomain employeeDomain);

  void deleteById(int id);
  boolean login(String empName, String empEmail);
}
