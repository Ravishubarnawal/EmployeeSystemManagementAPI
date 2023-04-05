package com.example.employeeManagement.test;

import com.example.employeeManagement.dao.EmployeeDaoImpl;
import com.example.employeeManagement.domain.EmployeeDomain;
import com.example.employeeManagement.entity.Employee;
import com.example.employeeManagement.service.EmployeeServiceImpl;
import com.example.employeeManagement.utils.PhoneNumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {
    @Mock
    private EmployeeDaoImpl employeeDao;

    @Mock
    private PhoneNumberValidator phoneNumberValidator;

    @Captor
    private ArgumentCaptor<Employee> employeeArgumentCaptor;
    private EmployeeServiceImpl underTest;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        underTest = new EmployeeServiceImpl(employeeDao, phoneNumberValidator);
    }

    @Test
    void itShouldSaveNewEmployee() {
        String empPhone = "000099";
        Employee employee = new Employee();
        employee.setId(2);
        employee.setEmpName("ravi");
        employee.setEmpPhone(empPhone);

        // take the request
        EmployeeDomain createRequest =  employeeDao.create(employee);

        //validate the empPhone.
        when(phoneNumberValidator.test(empPhone)).thenReturn(true);

        //add request.
        underTest.add(createRequest);

        //assert the request.
        verify(employeeDao).create(employeeArgumentCaptor.capture());
        Employee captureEmployee = employeeArgumentCaptor.getValue();
        assertEquals(employee,captureEmployee);




    }
}