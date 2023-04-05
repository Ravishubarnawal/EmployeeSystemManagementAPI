package com.example.employeeManagement.dao;

import com.example.employeeManagement.domain.EmployeeDomain;
import com.example.employeeManagement.entity.Employee;

import java.util.List;

public interface EmployeeDao {
  EmployeeDomain create(Employee employee);

  List<Employee> readAll();

  EmployeeDomain readById(int id);

  void update(int id, Employee employee);

  void delete(int id);
}
