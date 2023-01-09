package com.innovaturelabs.common.repository;

import com.innovaturelabs.common.entity.Tasks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface TasksRepository extends Repository<Tasks, Integer> {

    Tasks save(Tasks tasks);

    List<Tasks> findAll();
    Page<Tasks> findAll(Pageable pageable);
    List<Tasks> findAllByPhaseSectionPhaseSectionId(Integer sectionId);

    Optional<Tasks> findByTaskId(Integer taskId);
}
