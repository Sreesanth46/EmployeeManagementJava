package com.innovaturelabs.manager.service;

import com.innovaturelabs.common.form.ProjectForm;
import com.innovaturelabs.manager.view.ProjectDetailView;
import com.innovaturelabs.manager.view.ProjectListView;

import java.util.List;

/**
 *
 * @author Sreesanth
 */
public interface ProjectService {
    
    ProjectDetailView addProject(ProjectForm form);

    ProjectDetailView update(Integer projectId, ProjectForm form);

    List<ProjectListView> list();

    List<ProjectListView> listByProjectId(Integer projectId);

    Long count();

    ProjectDetailView softDelete(Integer projectId);

    List<ProjectListView> getActiveProject();
    
}
