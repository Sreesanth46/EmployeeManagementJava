package com.innovaturelabs.manager.view;

/**
 *
 * @author Sreesanth
 */
public class JobEmployeeCountView {

    private final int employeeId;
    private final String employeeName;
    private final String employeeEmail;
    private final Integer count;

    public JobEmployeeCountView(Integer employeeId, String employeeName, String employeeEmail, Integer count) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.count = count;
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

    public Integer getCount() {
        return count;
    }
}
