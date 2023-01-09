package com.innovaturelabs.common.form;


import com.innovaturelabs.common.json.Json;

import java.util.Date;

public class LeaveLogForm {

    private byte leaveType;

    @Json.DateFormat
    private Date leaveDate;

    private String reason;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public byte getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(byte leaveType) {
        this.leaveType = leaveType;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }
}
