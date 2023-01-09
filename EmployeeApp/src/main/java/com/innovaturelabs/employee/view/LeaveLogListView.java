package com.innovaturelabs.employee.view;

import java.util.Date;
import com.innovaturelabs.common.entity.LeaveLog;
import com.innovaturelabs.common.json.Json;

public class LeaveLogListView {
    private final byte leaveType;

    private final byte leaveStatus;

    private  final String reason;

    @Json.DateFormat
    private final Date leaveDate;

    public LeaveLogListView(LeaveLog leaveLog){
        this.leaveType=leaveLog.getLeaveType();
        this.leaveStatus=leaveLog.getLeaveStatus();
        this.leaveDate=leaveLog.getDate();
        this.reason=leaveLog.getReason();
    }

    public String getReason() {
        return reason;
    }

    public byte getLeaveType() {
        return leaveType;
    }

    public byte getLeaveStatus() {
        return leaveStatus;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }
}

