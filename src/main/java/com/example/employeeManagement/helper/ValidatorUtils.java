package com.example.employeeManagement.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtils {
  public static boolean isNameValid(String empName) {
    String regex = "[A-Z][a-z]+[ ][A-Z][a-z]+";
    Pattern pattern = Pattern.compile(regex);
    if (empName == null) {
      return false;
    }
    Matcher matcher = pattern.matcher(empName);
    return matcher.matches();
  }

  public static boolean isEmailValid(String empEmail) {
    String regex = "[a-zA-Z\\d_\\-\\.]+@[a-z]+\\.[a-z]{2,3}";
    Pattern pattern = Pattern.compile(regex);
    if (empEmail == null) {
      return false;
    }
    Matcher matcher = pattern.matcher(empEmail);
    return matcher.matches();
  }

  public static boolean isPhoneValid(String empPhone) {
    String regex = "[98]\\d{9}";
    Pattern pattern = Pattern.compile(regex);
    if (empPhone == null) {
      return false;
    }
    Matcher matcher = pattern.matcher(empPhone);
    return matcher.matches();
  }

  public static boolean isSalaryValid(int empSalary) {
    String regex = "^\\d+([kw])?\\+?$";
    Pattern pattern = Pattern.compile(regex);
    if (empSalary == 0) {
      return false;
    }
    Matcher matcher = pattern.matcher(Integer.toString(empSalary));
    return matcher.matches();
  }
}
