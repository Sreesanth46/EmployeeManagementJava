package com.innovaturelabs.manager.view;

import com.innovaturelabs.common.entity.Project;

import java.util.Date;

/**
 *
 * @author Sreesanth
 */
public class ProjectListView {

    private final int projectId;
    private final String projectName;
    private final byte projectStatus;

    private final Date createdDate;
    private final Date updatedDate;

    public ProjectListView(int projectId, String projectName, byte projectStatus, Date createdDate, Date updatedDate) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectStatus = projectStatus;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public ProjectListView(Project project) {
        this.projectId = project.getProjectId();
        this.projectName = project.getProjectName();
        this.projectStatus = project.getProjectStatus();
        this.createdDate = project.getCreateDate();
        this.updatedDate = project.getUpdateDate();
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
