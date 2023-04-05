package com.example.employeeManagement.exception;

public class MyException extends RuntimeException implements ExceptionType {
  private String description;
  private String code;

  public MyException(ExceptionType exceptionType) {
    this.description = exceptionType.getDescription();
    this.code = exceptionType.getCode();
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
