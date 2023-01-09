package com.innovaturelabs.common.form;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class LeaveForm {

    @NotBlank
    private List<Integer> employeeId;
    private Integer casualLeave;
    private Integer sickLeave;
    private Integer earnedLeave;

    public List<Integer> getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(List<Integer> employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getCasualLeave() {
        return casualLeave;
    }

    public void setCasualLeave(Integer casualLeave) {
        this.casualLeave = casualLeave;
    }

    public Integer getSickLeave() {
        return sickLeave;
    }

    public void setSickLeave(Integer sickLeave) {
        this.sickLeave = sickLeave;
    }

    public Integer getEarnedLeave() {
        return earnedLeave;
    }

    public void setEarnedLeave(Integer earnedLeave) {
        this.earnedLeave = earnedLeave;
    }
}
