package com.innovaturelabs.employee.view;

import com.innovaturelabs.common.entity.Employee;





public class EmployeeView {
    private final int employeeId;
    private final String name;
    private final String email;

    private final Integer loginCount;

    
    public EmployeeView(Employee employee) {
        this.employeeId=employee.getEmployeeId();
        this.name=employee.getEmployeeName();
        this.email=employee.getEmployeeEmail();
        this.loginCount=employee.getLoginCount();
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getLoginCount() {
        return loginCount;
    }


}
