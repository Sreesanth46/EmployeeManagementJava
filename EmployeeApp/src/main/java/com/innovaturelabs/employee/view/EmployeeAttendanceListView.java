package com.innovaturelabs.employee.view;

import com.innovaturelabs.common.entity.EmployeeAttendance;
import com.innovaturelabs.common.json.Json;

import java.util.Date;

public class EmployeeAttendanceListView {

    private final Integer employeeId;
    private final Integer attendanceId;
    private final Byte status;

    @Json.DateFormat
    private final Date date;


    public EmployeeAttendanceListView(EmployeeAttendance employeeAttendance){
        this.employeeId=employeeAttendance.getEmployee().getEmployeeId();
        this.attendanceId=employeeAttendance.getAttendanceId();
        this.status=employeeAttendance.getStatus();
        this.date=employeeAttendance.getDate();
    }


    public Integer getEmployeeId() {
        return employeeId;
    }


    public Integer getAttendanceId() {
        return attendanceId;
    }


    public Byte getStatus() {
        return status;
    }


    public Date getDate() {
        return date;
    }
    
    
}
