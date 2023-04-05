package com.example.employeeManagement.exception;

public enum EmployeeException implements ExceptionType {
  NAME_INVALID("EMP_01", "Invalid Name Format"),
  EMAIL_INVALID("EMP_02", "Invalid Email Format"),
  INVALID_PHONE("EMP_03", "Invalid Phone Number"),
  INVALID_SALARY_ENTRY("EMP_04", "Invalid Salary Format");

  private String code;
  private String description;

  EmployeeException(String code, String description) {
    this.code = code;
    this.description = description;
  }

  @Override
  public String getCode() {
    return code;
  }

  @Override
  public String getDescription() {
    return description;
  }
}
