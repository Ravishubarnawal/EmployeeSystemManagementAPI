package com.example.employeeManagement.helper;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorMessage {
  private String errorMessage;
  private int errorCode;
  private String documentation;
  private String code;
  private String message;

  public ErrorMessage(String code, String message) {
    this.code = code;
    this.message = message;
  }
}
