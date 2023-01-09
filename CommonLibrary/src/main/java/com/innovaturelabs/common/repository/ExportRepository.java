package com.innovaturelabs.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;

import com.innovaturelabs.common.entity.Tasks;
@Repository
public interface ExportRepository extends JpaRepository<Tasks,Integer> {
    
}
