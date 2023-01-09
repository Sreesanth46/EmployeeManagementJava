package com.innovaturelabs.common.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author Sreesanth
 */
public class ProjectForm {

    @Size(max = 40)
    @NotBlank
    private String projectName;
    private byte projectStatus;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public byte getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(byte projectStatus) {
        this.projectStatus = projectStatus;
    }
}
