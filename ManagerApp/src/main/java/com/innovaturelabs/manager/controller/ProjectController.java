package com.innovaturelabs.manager.controller;

import com.innovaturelabs.common.form.ProjectForm;
import com.innovaturelabs.manager.service.ProjectService;
import com.innovaturelabs.manager.view.ProjectDetailView;
import com.innovaturelabs.manager.view.ProjectListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 *
 * @author Sreesanth
 */
@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ProjectDetailView add(@Valid @RequestBody ProjectForm form) {
        return projectService.addProject(form);
    }

    @PutMapping("/{projectId}")
    public ProjectDetailView update(
            @PathVariable("projectId") Integer projectId,
            @RequestBody ProjectForm form) {
        return projectService.update(projectId, form);
    }

    @GetMapping
    public List<ProjectListView> listProject() {
        return projectService.list();
    }

    @GetMapping("/{projectId}")
    public List<ProjectListView> listByProjectId(@PathVariable("projectId") Integer projectId) {
        return projectService.listByProjectId(projectId);
    }

    @GetMapping("/count")
    public Long count() {
        return projectService.count();
    }

    @DeleteMapping("/softDelete/{projectId}")
    public ProjectDetailView softDelete(@PathVariable Integer projectId) {
        return projectService.softDelete(projectId);
    }

    @GetMapping("/active")
    public List<ProjectListView> getActiveProject() {
        return  this.projectService.getActiveProject();
    }
}
