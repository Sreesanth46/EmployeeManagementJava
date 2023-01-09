package com.innovaturelabs.manager.view;

import com.innovaturelabs.common.entity.LeaveLog;

import java.util.Date;

/**
 *
 * @author Sreesanth
 */
public class LeaveLogListView {

    private final int leaveLogId;

    private final int employeeId;
    private final String employeeName;
    private final String employeeEmail;

    private final byte leaveType;
    private final Date date;
    private final byte leaveStatus;
    private final Date approveDate;
    private final String reason;

    private final int managerId;
    private final String managerName;
    private final String managerEmail;

    public LeaveLogListView(LeaveLog leaveLog) {
        this.leaveLogId = leaveLog.getLeaveLogId();

        this.employeeId = leaveLog.getLeaves().getEmployee().getEmployeeId();
        this.employeeName = leaveLog.getLeaves().getEmployee().getEmployeeName();
        this.employeeEmail = leaveLog.getLeaves().getEmployee().getEmployeeEmail();

        this.leaveType = leaveLog.getLeaveType();
        this.date = leaveLog.getDate();
        this.leaveStatus = leaveLog.getLeaveStatus();
        this.approveDate = leaveLog.getAprovedDate();
        this.reason = leaveLog.getReason();

        this.managerId = leaveLog.getLeaves().getEmployee().getManager().getManagerId();
        this.managerName = leaveLog.getLeaves().getEmployee().getManager().getName();
        this.managerEmail = leaveLog.getLeaves().getEmployee().getManager().getEmail();
    }

    public int getLeaveLogId() {
        return leaveLogId;
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

    public byte getLeaveType() {
        return leaveType;
    }

    public Date getDate() {
        return date;
    }

    public byte getLeaveStatus() {
        return leaveStatus;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public String getReason() {
        return reason;
    }

    public int getManagerId() {
        return managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public String getManagerEmail() {
        return managerEmail;
    }
}
