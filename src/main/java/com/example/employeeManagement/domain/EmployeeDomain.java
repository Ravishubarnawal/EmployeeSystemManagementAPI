package com.example.employeeManagement.domain;

import com.example.employeeManagement.exception.EmployeeException;
import com.example.employeeManagement.exception.MyException;
import com.example.employeeManagement.helper.ValidatorUtils;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class EmployeeDomain {
  private int id;
  private String empName;
  private String empEmail;
  private String empPhone;
  private LocalDate joinDate;
  private LocalDate leaveDate;
  private int empSalary;

  public void validate() {
    if (!ValidatorUtils.isNameValid(empName))
        throw new MyException(EmployeeException.NAME_INVALID);
    if (!ValidatorUtils.isEmailValid(empEmail))
        throw new MyException(EmployeeException.EMAIL_INVALID);
    if (!ValidatorUtils.isPhoneValid(empPhone))
        throw new MyException(EmployeeException.INVALID_PHONE);
    //        if(ValidatorUtils.isSalaryValid(empSalary)){
    //            throw new MyException(EmployeeException.INVALID_SALARY_ENTRY);
    //        }

  }
}
