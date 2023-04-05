package com.example.employeeManagement.service;

import com.example.employeeManagement.converter.EmployeeDomainConverter;
import com.example.employeeManagement.converter.EmployeeEntityConverter;
import com.example.employeeManagement.dao.EmployeeDao;
import com.example.employeeManagement.dao.EmployeeDaoImpl;
import com.example.employeeManagement.domain.EmployeeDomain;
import com.example.employeeManagement.exception.ApplicationException;
import com.example.employeeManagement.helper.ErrorMessage;
import com.example.employeeManagement.utils.PhoneNumberValidator;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Default
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao;
    private EmployeeDomainConverter employeeDomainMapper;
    private final PhoneNumberValidator phoneNumberValidator;


    @Inject
    public EmployeeServiceImpl(
            EmployeeDao employeeDao, EmployeeDomainConverter employeeDomainMapper, PhoneNumberValidator phoneNumberValidator) {
        this.employeeDao = employeeDao;
        this.employeeDomainMapper = employeeDomainMapper;
        this.phoneNumberValidator = phoneNumberValidator;
    }

    public EmployeeServiceImpl(EmployeeDao employeeDao, PhoneNumberValidator phoneNumberValidator) {
        this.employeeDao = employeeDao;
        this.phoneNumberValidator = phoneNumberValidator;
    }

    public EmployeeDomain add(EmployeeDomain employeeDomain) {
        EmployeeDomain employee = new EmployeeDomain();
        String empPhone = employee.getEmpPhone();
        if (phoneNumberValidator.test(empPhone)) {
            throw new IllegalStateException("Phone Number" + empPhone + "is not valid");
        }
        employeeDomain.validate();
        EmployeeEntityConverter converter = new EmployeeEntityConverter();
        return employeeDao.create(converter.apply(employeeDomain));
    }

    @Override
    public List<EmployeeDomain> getAll() {
        return employeeDao.readAll().stream().map(employeeDomainMapper).collect(Collectors.toList());
    }

    public EmployeeDomain getById(int id) {
        ErrorMessage errorMessage1 = new ErrorMessage();
        errorMessage1.setErrorMessage("Not Found");
        errorMessage1.setErrorCode(404);
        errorMessage1.setDocumentation("https://www.baeldung.com/java-exception-handling-jersey");
        Response response = Response.status(Response.Status.NOT_FOUND).entity(errorMessage1).build();
        EmployeeDomain employeeData = employeeDao.readById(id);
        if (employeeData == null) {
            throw new WebApplicationException(response);
        }

        return employeeData;
    }

    public EmployeeDomain updateById(int id, EmployeeDomain employeeDomain) {
        if (employeeDomain.getId() != id) {
            throw new ApplicationException("Employee with id:" + id + "Not Found");
        } else {
            EmployeeEntityConverter converter = new EmployeeEntityConverter();
            employeeDomain.validate();
            employeeDao.update(id, converter.apply(employeeDomain));
        }
        return employeeDomain;
    }

    public void deleteById(int id) {
        employeeDao.delete(id);
    }

    public boolean login(String name, String email) {
        List<EmployeeDomain> employees = employeeDao.readAll().stream().map(employeeDomainMapper).collect(Collectors.toList());
        return employees.stream().anyMatch(employee -> employee.getEmpName().equals(name) && employee.getEmpEmail().equals(email));
    }
}
