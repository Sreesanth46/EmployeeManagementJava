package com.innovaturelabs.common.entity;

import com.innovaturelabs.common.form.LeaveForm;

import javax.persistence.*;

@Entity
public class Leaves {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer leaveId;

    @OneToOne(fetch = FetchType.EAGER)
    private Employee employee;

    private Integer casualLeave;
    private Integer sickLeave;
    private Integer earnedLeave;

    public Leaves() {}

    public Leaves(Integer employeeId, Integer casualLeave, Integer sickLeave, Integer earnedLeave) {
        this.employee = new Employee(employeeId);
        this.casualLeave = casualLeave;
        this.sickLeave = sickLeave;
        this.earnedLeave = earnedLeave;
    }

    public Leaves(Integer leaveId) {
        this.leaveId = leaveId;
    }

    public Integer getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Integer leaveId) {
        this.leaveId = leaveId;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
