package com.example.employeeManagement.dao;

import com.example.employeeManagement.converter.EmployeeDomainConverter;
import com.example.employeeManagement.domain.EmployeeDomain;
import com.example.employeeManagement.entity.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.enterprise.inject.Default;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Default
public class EmployeeDaoImpl implements EmployeeDao {
  private final SqlSessionFactory factory;

  private EmployeeDaoImpl() throws IOException {
    Reader reader = Resources.getResourceAsReader("META-INF/SqlMapConfig.xml");
    factory = new SqlSessionFactoryBuilder().build(reader);
  }

  public EmployeeDomain create(Employee employee) {
    SqlSession session = factory.openSession();
    session.insert("Employee.insertEmployee", employee);
    EmployeeDomainConverter converter = new EmployeeDomainConverter();
    session.commit();
    session.close();
    return converter.apply(employee);
  }

  public EmployeeDomain readById(int id) {
    SqlSession session = factory.openSession();
    Employee employee = session.selectOne("Employee.getEmployeeById", id);
    EmployeeDomainConverter converter = new EmployeeDomainConverter();
    session.commit();
    session.close();
    return converter.apply(employee);
  }

  public List<Employee> readAll() {
    SqlSession session = factory.openSession();
    List<Employee> employeeList = new ArrayList<>(session.selectList("Employee.getAllEmployee"));
    session.close();
    return employeeList;
  }

  public void update(int id, Employee employee) {
    SqlSession session = factory.openSession();
    session.update("Employee.updateEmployee", employee);
    session.commit();
    session.close();
  }

  public void delete(int id) {
    SqlSession session = factory.openSession();
    session.delete("Employee.deleteEmployeeById", id);
    session.commit();
    session.close();
  }
}
