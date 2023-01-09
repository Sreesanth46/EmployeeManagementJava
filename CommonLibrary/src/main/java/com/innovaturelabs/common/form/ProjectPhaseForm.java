package com.innovaturelabs.common.form;


import javax.validation.constraints.NotNull;

/**
 *
 * @author Sreesanth
 */
public class ProjectPhaseForm {

    @NotNull
    private Integer projectId;

    @NotNull
    private String phaseName;

    private byte phaseStatus;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getPhaseName() {
        return phaseName;
    }

    public void setPhaseName(String phaseName) {
        this.phaseName = phaseName;
    }

    public byte getPhaseStatus() {
        return phaseStatus;
    }

    public void setPhaseStatus(byte phaseStatus) {
        this.phaseStatus = phaseStatus;
    }
}
