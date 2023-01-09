package com.innovaturelabs.common.form;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Sreesanth
 */
public class EmployeeJobForm {

    @NotBlank
    private Integer employeeId;

    @NotBlank
    private Integer projectId;


    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}
