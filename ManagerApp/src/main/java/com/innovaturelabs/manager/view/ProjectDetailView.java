package com.innovaturelabs.manager.view;

import com.innovaturelabs.common.entity.Project;

/**
 *
 * @author Sreesanth
 */
public class ProjectDetailView extends ProjectListView {

    public ProjectDetailView(Project project) {
        super(
                project.getProjectId(),
                project.getProjectName(),
                project.getProjectStatus(),
                project.getCreateDate(),
                project.getUpdateDate()
        );
    }
}
