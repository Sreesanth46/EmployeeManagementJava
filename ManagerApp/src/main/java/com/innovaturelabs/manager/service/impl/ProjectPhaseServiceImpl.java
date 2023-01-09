package com.innovaturelabs.manager.service.impl;

import com.innovaturelabs.common.entity.Project;
import com.innovaturelabs.common.entity.ProjectPhase;
import com.innovaturelabs.common.form.ProjectPhaseForm;
import com.innovaturelabs.common.repository.ProjectPhaseRepository;
import com.innovaturelabs.common.repository.ProjectRepository;
import com.innovaturelabs.manager.exception.BadRequestException;
import com.innovaturelabs.manager.exception.NotFoundException;
import com.innovaturelabs.manager.service.ProjectPhaseService;
import com.innovaturelabs.manager.view.ProjectPhaseListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 *
 * @author Sreesanth
 */
@Service
public class ProjectPhaseServiceImpl implements ProjectPhaseService {

    @Autowired
    private ProjectPhaseRepository projectPhaseRepository;

    @Autowired
    private ProjectRepository projectRepository;

    private static BadRequestException projectIdNotUnique() {
        return new BadRequestException("ProjectId should be unique. Duplicate Entry !!");
    }
    @Override
    public void add(ProjectPhaseForm form) throws BadRequestException {
        Optional<Project> projectData = projectRepository.findByProjectId(form.getProjectId());
        if (projectData.isPresent()) {
            try {
                projectPhaseRepository.save(new ProjectPhase(form));
            }catch(Exception e){
                throw projectIdNotUnique();
            }
        }
        else {
            throw new NotFoundException("Project Id not found");
        }
    }

    @Override
    public List<ProjectPhaseListView> list() {
        return StreamSupport.stream(projectPhaseRepository
                .findAll().spliterator(), false)
                .map(ProjectPhaseListView::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProjectPhaseListView> listByProjectId(Integer projectId) {
        return projectPhaseRepository
                        .findAllByProjectProjectId(projectId).stream()
                .map(ProjectPhaseListView::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProjectPhaseListView> listByPhaseId(Integer phaseId) {
        return projectPhaseRepository
                .findByPhaseId(phaseId).stream()
                .map(ProjectPhaseListView::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ProjectPhaseListView update(Integer phaseId, ProjectPhaseForm form) throws NotFoundException {
        return projectPhaseRepository.findByPhaseId(phaseId)
                .map(phase -> {
                    return new ProjectPhaseListView(projectPhaseRepository.save(phase.update(form)));
                }).orElseThrow(NotFoundException::new);
    }
}
