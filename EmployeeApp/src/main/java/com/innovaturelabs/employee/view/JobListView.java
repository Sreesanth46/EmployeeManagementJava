package com.innovaturelabs.employee.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.innovaturelabs.common.entity.Job;

import java.util.Date;

public class JobListView {
    private final Integer employeeId;
    private final String employeeName;
    private final Integer jobId;

    private final String managerName;

    private final String taskName;

    private final byte taskStatus;

    private final String projectName;

    private final String phaseName;

    private final String phaseSection;

    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd/MM/yyyy",timezone="Asia/Kolkata")
    private final Date createDate;

    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd/MM/yyyy",timezone="Asia/Kolkata")
    private final Date updateDate;

    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd/MM/yyyy",timezone="Asia/Kolkata")
    private final Date completionDate;



    public JobListView(Job job)
    {
        this.employeeId=job.getEmployee().getEmployeeId();
        this.employeeName=job.getEmployee().getEmployeeName();
        this.jobId=job.getJobId();
        this.managerName=job.getEmployee().getManager().getName();
        this.taskName=job.getTasks().getTaskName();
        this.taskStatus=job.getTasks().getTaskStatus();
        this.projectName=job.getTasks().getPhaseSection().getProjectPhase().getProject().getProjectName();
        this.phaseName=job.getTasks().getPhaseSection().getProjectPhase().getPhaseName();
        this.phaseSection=job.getTasks().getPhaseSection().getSectionName();
        this.createDate=job.getCreateDate();
        this.updateDate=job.getUpdateDate();
        this.completionDate=job.getCompletionDate();
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }



    public Integer getJobId() {
        return jobId;
    }

    public String getManagerName() {
        return managerName;
    }

    public String getTaskName() {
        return taskName;
    }

    public byte getTaskStatus() {
        return taskStatus;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getPhaseName() {
        return phaseName;
    }

    public String getPhaseSection() {
        return phaseSection;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }
}
