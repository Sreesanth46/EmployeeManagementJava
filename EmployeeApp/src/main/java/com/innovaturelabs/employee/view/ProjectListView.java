package com.innovaturelabs.employee.view;

import com.innovaturelabs.common.entity.Employee;
import com.innovaturelabs.common.entity.EmployeeJob;
import com.innovaturelabs.common.entity.Job;
import com.innovaturelabs.common.entity.Project;
import com.innovaturelabs.common.json.Json;
import java.util.Date;

public class ProjectListView {
    private final int employeeId;
    private final String employeeName;
    private final String employeeEmail;

    private final int projectId;
    private final String projectName;
    private final byte projectStatus;

    @Json.DateFormat
    private final Date createDate;

    private final String managerName;

    private final String phaseName;

    public ProjectListView(Employee employee, Project project,Job job) {
        this.employeeId = employee.getEmployeeId();
        this.employeeName = employee.getEmployeeName();
        this.employeeEmail = employee.getEmployeeEmail();
        this.projectId = project.getProjectId();
        this.projectName = project.getProjectName();
        this.projectStatus = project.getProjectStatus();
        this.createDate=project.getCreateDate();
        this.managerName=employee.getManager().getName();
        this.phaseName=job.getTasks().getPhaseSection().getProjectPhase().getPhaseName();
    }

    public ProjectListView(Job jobs) {
        this.employeeId = jobs.getEmployee().getEmployeeId();
        this.employeeName = jobs.getEmployee().getEmployeeName();
        this.employeeEmail = jobs.getEmployee().getEmployeeEmail();
        this.projectId = jobs.getTasks().getPhaseSection().getProjectPhase().getProject().getProjectId();
        this.projectName = jobs.getTasks().getPhaseSection().getProjectPhase().getProject().getProjectName();
        this.projectStatus = jobs.getTasks().getPhaseSection().getProjectPhase().getProject().getProjectStatus();
        this.createDate=jobs.getTasks().getPhaseSection().getProjectPhase().getProject().getCreateDate();
        this.managerName=jobs.getEmployee().getManager().getName();
        this.phaseName=jobs.getTasks().getPhaseSection().getProjectPhase().getPhaseName();
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

    public int getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public byte getProjectStatus() {
        return projectStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getManagerName() {
        return managerName;
    }

    public String getPhaseName() {
        return phaseName;
    }
}
