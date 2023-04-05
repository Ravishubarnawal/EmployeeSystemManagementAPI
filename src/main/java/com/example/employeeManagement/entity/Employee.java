package com.example.employeeManagement.entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
public class Employee {

    private int id;

    private String empName;

    private String empEmail;

    private String empPhone;

    private LocalDate joinDate;

    private LocalDate leaveDate;

    private int  empSalary;


}

