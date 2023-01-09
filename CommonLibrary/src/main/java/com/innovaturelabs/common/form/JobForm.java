package com.innovaturelabs.common.form;

import com.innovaturelabs.common.json.Json;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Sreesanth
 */
public class JobForm {

    @NotBlank
    private Integer taskId;

    @NotBlank
    private Integer employeeId;

    private List<Integer> alternativeEmployeeId;

    @Json.DateFormat
    private Date completionDate;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public List<Integer> getAlternativeEmployeeId() {
        return alternativeEmployeeId;
    }

    public void setAlternativeEmployeeId(List<Integer> alternativeEmployeeId) {
        this.alternativeEmployeeId = alternativeEmployeeId;
    }
}
