package com.innovaturelabs.manager.view;

import com.innovaturelabs.common.entity.Employee;

/**
 *
 * @author Sreesanth
 */
public class EmployeeListView {

    private final int employeeId;
    private final String employeeName;
    private final String employeeEmail;
    private final byte status;

    public EmployeeListView(int employeeId, String employeeName, String employeeEmail, byte status) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.status = status;
    }

    public EmployeeListView(Employee employee) {
        this.employeeId = employee.getEmployeeId();
        this.employeeName = employee.getEmployeeName();
        this.employeeEmail = employee.getEmployeeEmail();
        this.status = employee.getStatus();
    }



    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public byte getStatus() {
        return status;
    }
}
