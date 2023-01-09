package com.innovaturelabs.common.entity;

import com.innovaturelabs.common.form.LeaveLogForm;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author Sreesanth
 */

@Entity
public class LeaveLog {

    public enum  Status {
        NOT_APPROVED((byte) 0),
        APPROVED((byte) 1),
        DECLINED((byte) 2);

        public final byte value;

        private Status(byte value) {
            this.value = value;
        }
    }

    public enum LeaveFlag {

        CASUAL((byte) 1),
        SICK((byte) 2),
        EARNED((byte) 3);

        private final byte value;

        private LeaveFlag(byte value) {
            this.value = value;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer leaveLogId;

    @ManyToOne(fetch = FetchType.EAGER)
    private Leaves leaves;

    private byte leaveType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private byte leaveStatus;

    @Temporal(TemporalType.TIMESTAMP)
    private Date aprovedDate;

    private String reason;

    public LeaveLog() {}

    public LeaveLog(LeaveLogForm form, Integer leaveId) {
        this.leaveType = form.getLeaveType();
        this.date = form.getLeaveDate();
        this.leaveStatus = Status.NOT_APPROVED.value;
        this.leaves = new Leaves(leaveId);
        this.reason= form.getReason();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getLeaveLogId() {
        return leaveLogId;
    }

    public void setLeaveLogId(Integer leaveLogId) {
        this.leaveLogId = leaveLogId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public byte getLeaveStatus() {
        return leaveStatus;
    }

    public void setLeaveStatus(byte leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    public Date getAprovedDate() {
        return aprovedDate;
    }

    public void setAprovedDate(Date aprovedDate) {
        this.aprovedDate = aprovedDate;
    }

    public byte getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(byte leaveType) {
        this.leaveType = leaveType;
    }

    public Leaves getLeaves() {
        return leaves;
    }

    public void setLeaves(Leaves leaves) {
        this.leaves = leaves;
    }
}
