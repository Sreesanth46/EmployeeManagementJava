package com.innovaturelabs.common.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class EmployeeForm {
    
    @Size(max = 30)
    @NotBlank
    private String employeeName;

    @NotBlank
    private String employeeEmail;

    @NotBlank
    private  String password;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }
    
    
}
