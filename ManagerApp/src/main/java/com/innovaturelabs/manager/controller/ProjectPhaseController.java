package com.innovaturelabs.manager.controller;

import com.innovaturelabs.common.form.ProjectPhaseForm;
import com.innovaturelabs.manager.service.ProjectPhaseService;
import com.innovaturelabs.manager.view.ProjectPhaseListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author Sreesanth
 */
@RestController
@RequestMapping("/projectPhase")
public class ProjectPhaseController {

    @Autowired
    private ProjectPhaseService projectPhaseService;

    @PostMapping()
    public void add(@RequestBody ProjectPhaseForm form) {
        projectPhaseService.add(form);
    }

    @GetMapping
    public List<ProjectPhaseListView> listPhases() {
        return projectPhaseService.list();
    }

    @GetMapping("/projectId/{projectId}")
    public List<ProjectPhaseListView> listByProjectId(@PathVariable("projectId") Integer projectId) {
        return projectPhaseService.listByProjectId(projectId);
    }

    @GetMapping("/phaseId/{phaseId}")
    public List<ProjectPhaseListView> listByPhaseId(@PathVariable("phaseId") Integer phaseId) {
        return projectPhaseService.listByPhaseId(phaseId);
    }

    @PutMapping("/phaseId/{phaseId}")
    public ProjectPhaseListView update(@PathVariable("phaseId") Integer phaseId, @RequestBody ProjectPhaseForm form) {
        return projectPhaseService.update(phaseId, form);
    }
}
