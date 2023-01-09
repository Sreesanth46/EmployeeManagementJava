package com.innovaturelabs.common.repository;

import com.innovaturelabs.common.entity.Project;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

public interface ProjectRepository extends Repository<Project, Integer> {

    Project save(Project project);

    List<Project> findAll();

    List<Project> findAllByProjectStatusNot(byte projectStatus);

    Optional<Project> findByProjectId(Integer projectId);

    Long count();
}
