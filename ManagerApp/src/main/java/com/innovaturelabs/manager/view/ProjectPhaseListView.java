package com.innovaturelabs.manager.view;

import com.innovaturelabs.common.entity.ProjectPhase;

import java.util.Date;

/**
 *
 * @author Sreesanth
 */
public class ProjectPhaseListView {

    private final int phaseId;
    private final String phaseName;
    private final Byte phaseStatus;
    private final Date createdDate;
    private final Date updatedDate;

    private final int projectId;
    private final String projectName;
    private final byte projectStatus;

    public ProjectPhaseListView(ProjectPhase projectPhase) {
        this.phaseId = projectPhase.getPhaseId();
        this.phaseName = projectPhase.getPhaseName();
        this.phaseStatus = projectPhase.getPhaseStatus();
        this.createdDate = projectPhase.getCreateDate();
        this.updatedDate = projectPhase.getUpdateDate();

        this.projectId = projectPhase.getProject().getProjectId();
        this.projectName = projectPhase.getProject().getProjectName();
        this.projectStatus = projectPhase.getProject().getProjectStatus();
    }

    public int getPhaseId() {
        return phaseId;
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

    public String getPhaseName() {
        return phaseName;
    }

    public Byte getPhaseStatus() {
        return phaseStatus;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }
}
