package com.innovaturelabs.common.entity;

import com.innovaturelabs.common.form.EmployeeJobForm;
import com.innovaturelabs.common.form.ResetStatusForm;

import javax.persistence.*;

/**
 *
 * @author Sreesanth
 */
@Entity
public class EmployeeJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobId;

    @OneToOne(fetch = FetchType.EAGER)
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER)
    private Project project;

    public EmployeeJob() {
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public EmployeeJob(EmployeeJobForm form) {
        this.employee = new Employee(form.getEmployeeId());
        this.project = new Project(form.getProjectId());
    }
//
//    public void setJob(ResetStatusForm form) {
//        this.project.setProjectStatus(form.getProjectStatus());
//    }

    public EmployeeJob update(EmployeeJobForm form) {
        this.employee = new Employee(form.getEmployeeId());
        this.project = new Project(form.getProjectId());

        return this;
    }
}
