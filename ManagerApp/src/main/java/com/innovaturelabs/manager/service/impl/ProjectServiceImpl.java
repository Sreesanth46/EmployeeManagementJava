package com.innovaturelabs.manager.service.impl;

import com.innovaturelabs.common.entity.Project;
import com.innovaturelabs.common.form.ProjectForm;
import com.innovaturelabs.common.repository.ProjectRepository;
import com.innovaturelabs.manager.exception.NotFoundException;
import com.innovaturelabs.manager.service.ProjectService;
import com.innovaturelabs.manager.view.ProjectDetailView;
import com.innovaturelabs.manager.view.ProjectListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 *
 * @author Sreesanth
 */
@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectRepository projectRepository;


    @Override
    public ProjectDetailView addProject(ProjectForm form) {
        return new ProjectDetailView(projectRepository.save(new Project(form)));
    }

    @Override
    public ProjectDetailView update(Integer projectId, ProjectForm form) throws NotFoundException {
        return projectRepository.findByProjectId(projectId)
                .map((project) -> {
                    return new ProjectDetailView(projectRepository.save(project.update(form)));
                }).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<ProjectListView> list() {
        return StreamSupport.stream(projectRepository
        .findAll().spliterator(), false)
        .map(project -> new ProjectListView(project))
        .collect(Collectors.toList());
    }

    @Override
    public List<ProjectListView> listByProjectId(Integer projectId) {
        return projectRepository.findByProjectId(projectId).stream()
                .map(ProjectListView::new)
                .collect(Collectors.toList());
    }

    @Override
    public Long count() {
        return projectRepository.count();
    }

    @Override
    public ProjectDetailView softDelete(Integer projectId) {
        return projectRepository.findByProjectId(projectId)
                .map((project) -> {
                    project.setProjectStatus(Project.Status.DELETED.value);
                    return new ProjectDetailView(projectRepository.save(project));
                }).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<ProjectListView> getActiveProject() {
        return projectRepository.findAllByProjectStatusNot(Project.Status.DELETED.value).stream()
                .map(ProjectListView::new)
                .collect(Collectors.toList());
    }
}
