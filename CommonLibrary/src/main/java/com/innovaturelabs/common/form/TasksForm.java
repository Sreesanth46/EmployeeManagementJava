package com.innovaturelabs.common.form;

import javax.validation.constraints.NotNull;

/**
 *
 * @author Sreesanth
 */
public class TasksForm {

    @NotNull
    private Integer phaseSectionId;

    @NotNull
    private String taskName;

    private byte taskStatus;

    public Integer getPhaseSectionId() {
        return phaseSectionId;
    }

    public void setPhaseSectionId(Integer phaseSectionId) {
        this.phaseSectionId = phaseSectionId;
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
}
