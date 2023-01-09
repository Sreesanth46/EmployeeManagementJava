package com.innovaturelabs.manager.view;

import com.innovaturelabs.common.entity.Leaves;

public class LeaveListView {

    private final int leaveId;

    private final int employeeId;
    private final String employeeName;
    private final String employeeEmail;

    private final int casualLeave;
    private final int sickLeave;
    private final int earnedLeave;

    public LeaveListView(Leaves leaves) {
        this.leaveId = leaves.getLeaveId();
        this.employeeId = leaves.getEmployee().getEmployeeId();
        this.employeeName = leaves.getEmployee().getEmployeeName();
        this.employeeEmail = leaves.getEmployee().getEmployeeEmail();
        this.casualLeave = leaves.getCasualLeave();
        this.sickLeave = leaves.getSickLeave();
        this.earnedLeave = leaves.getEarnedLeave();
    }

    public int getLeaveId() {
        return leaveId;
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

    public int getCasualLeave() {
        return casualLeave;
    }

    public int getSickLeave() {
        return sickLeave;
    }

    public int getEarnedLeave() {
        return earnedLeave;
    }
}
