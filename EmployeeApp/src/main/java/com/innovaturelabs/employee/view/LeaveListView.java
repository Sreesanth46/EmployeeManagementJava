package com.innovaturelabs.employee.view;

import com.innovaturelabs.common.entity.Leaves;

public class LeaveListView {
    private final String employeeName;

    private final Integer casualLeave;

    private final Integer sickLeave;

    private final Integer earnedLeave;

    public LeaveListView(Leaves leaves){
        this.employeeName=leaves.getEmployee().getEmployeeName();
        this.casualLeave=leaves.getCasualLeave();
        this.sickLeave=leaves.getSickLeave();
        this.earnedLeave=leaves.getEarnedLeave();
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public Integer getCasualLeave() {
        return casualLeave;
    }

    public Integer getSickLeave() {
        return sickLeave;
    }

    public Integer getEarnedLeave() {
        return earnedLeave;
    }
}
