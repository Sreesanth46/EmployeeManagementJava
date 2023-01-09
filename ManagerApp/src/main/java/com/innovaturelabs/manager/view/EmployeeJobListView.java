package com.innovaturelabs.manager.view;

import com.innovaturelabs.common.entity.Employee;
import com.innovaturelabs.common.entity.EmployeeJob;
import com.innovaturelabs.common.entity.Project;

/**
 *
 * @author Sreesanth
 */
public class EmployeeJobListView {

    private final int employeeId;
    private final String employeeName;
    private final String employeeEmail;
    private final int projectId;
    private final String projectName;
    private final byte projectStatus;

    public EmployeeJobListView(Employee employee, Project project) {
        this.employeeId = employee.getEmployeeId();
        this.employeeName = employee.getEmployeeName();
        this.employeeEmail = employee.getEmployeeEmail();
        this.projectId = project.getProjectId();
        this.projectName = project.getProjectName();
        this.projectStatus = project.getProjectStatus();

    }

    public EmployeeJobListView(EmployeeJob jobs) {
        this.employeeId = jobs.getEmployee().getEmployeeId();
        this.employeeName = jobs.getEmployee().getEmployeeName();
        this.employeeEmail = jobs.getEmployee().getEmployeeEmail();
        this.projectId = jobs.getProject().getProjectId();
        this.projectName = jobs.getProject().getProjectName();
        this.projectStatus = jobs.getProject().getProjectStatus();
    }


    public int getEmployeeId() {
        return employeeId;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getProjectName() {
        return projectName;
    }

    public byte getProjectStatus() {
        return projectStatus;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }
}
