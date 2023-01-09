package com.innovaturelabs.common.entity;

import com.innovaturelabs.common.form.JobForm;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author Sreesanth
 */
@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobId;

    @OneToOne(fetch = FetchType.EAGER)
    private Tasks tasks;

    @OneToOne(fetch = FetchType.EAGER)
    private Employee employee;

    @Temporal(TemporalType.TIMESTAMP)
    private Date completionDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    public Job() {}

    public Job(JobForm form) {
        this.employee = new Employee(form.getEmployeeId());
        this.tasks = new Tasks(form.getTaskId());
        this.completionDate = form.getCompletionDate();

        Date dt = new Date();
        this.createDate = dt;
        this.updateDate = dt;
    }

    public Job(Integer employeeId, Integer taskId, Date completionDate) {
        this.employee = new Employee(employeeId);
        this.tasks = new Tasks(taskId);
        this.completionDate = completionDate;

        Date dt = new Date();
        this.createDate = dt;
        this.updateDate = dt;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Tasks getTasks() {
        return tasks;
    }

    public void setTasks(Tasks tasks) {
        this.tasks = tasks;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }
}
