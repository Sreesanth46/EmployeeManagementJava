package com.innovaturelabs.manager.service;

import com.innovaturelabs.common.entity.ProjectPhase;
import com.innovaturelabs.common.form.ProjectPhaseForm;
import com.innovaturelabs.manager.view.ProjectPhaseListView;

import java.util.List;

/**
 *
 * @author Sreesanth
 */
public interface ProjectPhaseService {

    void add(ProjectPhaseForm form);

    List<ProjectPhaseListView> list();

    List<ProjectPhaseListView> listByProjectId(Integer projectId);

    List<ProjectPhaseListView> listByPhaseId(Integer phaseId);

    ProjectPhaseListView update(Integer phaseId, ProjectPhaseForm form);
}
