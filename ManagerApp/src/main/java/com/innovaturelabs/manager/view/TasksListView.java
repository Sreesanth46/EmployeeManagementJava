package com.innovaturelabs.manager.view;

import com.innovaturelabs.common.entity.Tasks;

/**
 *
 * @author Sreesanth
 */
public class TasksListView {

    private final int taskId;
    private final String taskName;
    private final byte taskStatus;

    private final int phaseSectionId;
    private final String sectionName;
    private final byte sectionStatus;

    private final int phaseId;
    private final String phaseName;
    private final byte phaseStatus;

    private final int projectId;
    private final String projectName;
    private final byte projectStatus;

    public TasksListView(Tasks tasks) {
        this.taskId = tasks.getTaskId();
        this.taskName = tasks.getTaskName();
        this.taskStatus = tasks.getTaskStatus();

        this.phaseSectionId = tasks.getPhaseSection().getPhaseSectionId();
        this.sectionName = tasks.getPhaseSection().getSectionName();
        this.sectionStatus = tasks.getPhaseSection().getSectionStatus();

        this.phaseId = tasks.getPhaseSection().getProjectPhase().getPhaseId();
        this.phaseName = tasks.getPhaseSection().getProjectPhase().getPhaseName();
        this.phaseStatus = tasks.getPhaseSection().getProjectPhase().getPhaseStatus();

        this.projectId = tasks.getPhaseSection().getProjectPhase().getProject().getProjectId();
        this.projectName = tasks.getPhaseSection().getProjectPhase().getProject().getProjectName();
        this.projectStatus = tasks.getPhaseSection().getProjectPhase().getProject().getProjectStatus();
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public byte getTaskStatus() {
        return taskStatus;
    }

    public int getPhaseSectionId() {
        return phaseSectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public byte getSectionStatus() {
        return sectionStatus;
    }

    public int getPhaseId() {
        return phaseId;
    }

    public String getPhaseName() {
        return phaseName;
    }

    public byte getPhaseStatus() {
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
}
