package com.innovaturelabs.manager.view;

import com.innovaturelabs.common.entity.PhaseSection;

import java.util.Date;

/**
 *
 * @author Sreesanth
 */
public class PhaseSectionListView {

    private final int phaseSectionId;
    private final String sectionName;
    private final Byte sectionStatus;

    private final Date createdDate;
    private final Date updatedDate;

    private final int phaseId;
    private final String phaseName;
    private final Byte phaseStatus;

    private final int projectId;
    private final String projectName;
    private final byte projectStatus;

    public PhaseSectionListView(PhaseSection phaseSection) {
        this.phaseSectionId = phaseSection.getPhaseSectionId();
        this.sectionName = phaseSection.getSectionName();
        this.sectionStatus  = phaseSection.getSectionStatus();
        this.createdDate = phaseSection.getCreateDate();
        this.updatedDate = phaseSection.getUpdateDate();

        this.phaseId = phaseSection.getProjectPhase().getPhaseId();
        this.phaseName = phaseSection.getProjectPhase().getPhaseName();
        this.phaseStatus = phaseSection.getProjectPhase().getPhaseStatus();

        this.projectId = phaseSection.getProjectPhase().getProject().getProjectId();
        this.projectName = phaseSection.getProjectPhase().getProject().getProjectName();
        this.projectStatus = phaseSection.getProjectPhase().getProject().getProjectStatus();
    }

    public int getPhaseSectionId() {
        return phaseSectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public Byte getSectionStatus() {
        return sectionStatus;
    }

    public int getPhaseId() {
        return phaseId;
    }

    public String getPhaseName() {
        return phaseName;
    }

    public Byte getPhaseStatus() {
        return phaseStatus;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }
}
