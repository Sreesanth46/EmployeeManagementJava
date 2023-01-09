package com.innovaturelabs.manager.view;

import com.innovaturelabs.common.entity.Job;

import java.util.Date;

/**
 *
 * @author Sreesanth
 */
public class JobListView {

    private final int jobId;

    private final int employeeId;
    private final String employeeName;
    private final String employeeEmail;

    private final int taskId;
    private final String taskName;
    private final byte taskStatus;

//    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd/MM/yyyy",timezone="Asia/Kolkata")
    private final Date completionDate;

    private final int phaseSectionId;
    private final String sectionName;
    private final byte sectionStatus;

    private final int phaseId;
    private final String phaseName;
    private final byte phaseStatus;

    private final int projectId;
    private final String projectName;
    private final byte projectStatus;

    private final int managerId;
    private final String managerName;
    private final String managerEmail;

    public JobListView(Job job) {
        this.jobId = job.getJobId();

        this.employeeId = job.getEmployee().getEmployeeId();
        this.employeeName = job.getEmployee().getEmployeeName();
        this.employeeEmail = job.getEmployee().getEmployeeEmail();

        this.taskId = job.getTasks().getTaskId();
        this.taskName = job.getTasks().getTaskName();
        this.taskStatus = job.getTasks().getTaskStatus();

        this.completionDate = job.getCompletionDate();

        this.phaseSectionId = job.getTasks().getPhaseSection().getPhaseSectionId();
        this.sectionName = job.getTasks().getPhaseSection().getSectionName();
        this.sectionStatus = job.getTasks().getPhaseSection().getSectionStatus();

        this.phaseId = job.getTasks().getPhaseSection().getProjectPhase().getPhaseId();
        this.phaseName = job.getTasks().getPhaseSection().getProjectPhase().getPhaseName();
        this.phaseStatus = job.getTasks().getPhaseSection().getProjectPhase().getPhaseStatus();

        this.projectId = job.getTasks().getPhaseSection().getProjectPhase().getProject().getProjectId();
        this.projectName = job.getTasks().getPhaseSection().getProjectPhase().getProject().getProjectName();
        this.projectStatus = job.getTasks().getPhaseSection().getProjectPhase().getProject().getProjectStatus();

        this.managerId = job.getEmployee().getManager().getManagerId();
        this.managerName = job.getEmployee().getManager().getName();
        this.managerEmail = job.getEmployee().getManager().getEmail();
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

    public int getPhaseSectionId() {
        return phaseSectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public byte getSectionStatus() {
        return sectionStatus;
    }

    public int getPhaseId() {
        return phaseId;
    }

    public String getPhaseName() {
        return phaseName;
    }

    public byte getPhaseStatus() {
        return phaseStatus;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public byte getProjectStatus() {
        return projectStatus;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public byte getTaskStatus() {
        return taskStatus;
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

    public Date getCompletionDate() {
        return completionDate;
    }

    public int getJobId() {
        return jobId;
    }
}