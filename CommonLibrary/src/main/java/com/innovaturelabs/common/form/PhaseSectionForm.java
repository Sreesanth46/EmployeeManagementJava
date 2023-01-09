package com.innovaturelabs.common.form;

import javax.validation.constraints.NotNull;

/**
 *
 * @author Sreesanth
 */
public class PhaseSectionForm {

    @NotNull
    private String sectionName;

    private byte sectionStatus;

    @NotNull
    private Integer phaseId;

    public byte getSectionStatus() {
        return sectionStatus;
    }

    public void setSectionStatus(byte sectionStatus) {
        this.sectionStatus = sectionStatus;
    }

    public Integer getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(Integer phaseId) {
        this.phaseId = phaseId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }
}
