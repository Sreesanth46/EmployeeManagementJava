package com.innovaturelabs.common.entity;

import com.innovaturelabs.common.form.TasksForm;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author Sreesanth
 */
@Entity
public class Tasks {

    public enum Status {
        NEW((byte) 1),
        OPEN((byte) 2),
        PROGRESS((byte) 3),
        COMPLETED((byte) 4);

        public final byte value;

        private Status(byte value) {
            this.value = value;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskId;

    @OneToOne(fetch = FetchType.EAGER)
    private PhaseSection phaseSection;

    private String taskName;
    private byte taskStatus;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    public Tasks() {
    }

    public Tasks(Integer taskId) {
        this.taskId = taskId;
    }

    public Tasks(TasksForm form) {
        this.phaseSection = new PhaseSection(form.getPhaseSectionId());
        this.taskName = form.getTaskName();
        this.taskStatus = Status.NEW.value;

        Date dt = new Date();
        this.createDate = dt;
        this.updateDate = dt;
    }

    public Tasks update(TasksForm form) {
        this.taskName = form.getTaskName();
        this.taskStatus = form.getTaskStatus();

        Date dt = new Date();
        this.updateDate = dt;

        return this;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public byte getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(byte taskStatus) {
        this.taskStatus = taskStatus;
    }

    public PhaseSection getPhaseSection() {
        return phaseSection;
    }

    public void setPhaseSection(PhaseSection phaseSection) {
        this.phaseSection = phaseSection;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
