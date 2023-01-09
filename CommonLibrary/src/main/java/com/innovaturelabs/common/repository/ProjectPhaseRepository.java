package com.innovaturelabs.common.repository;

import com.innovaturelabs.common.entity.ProjectPhase;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface ProjectPhaseRepository extends Repository<ProjectPhase, Integer> {

    ProjectPhase save(ProjectPhase projectPhase);

    List<ProjectPhase> findAll();

    List<ProjectPhase> findAllByProjectProjectId(Integer projectId);

    Optional<ProjectPhase> findByPhaseId(Integer phaseId);

}
