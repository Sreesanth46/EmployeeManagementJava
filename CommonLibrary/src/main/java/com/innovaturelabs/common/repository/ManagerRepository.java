package com.innovaturelabs.common.repository;

import com.innovaturelabs.common.entity.Manager;

import java.util.Optional;

import org.springframework.data.repository.Repository;

public interface ManagerRepository extends Repository<Manager, Integer>{

    Optional<Manager> findById(Integer userId);

    Optional<Manager> findByManagerIdAndPassword(Integer managerId, String password);

    Manager save(Manager manager);

    Optional<Manager> findByEmail(String email);
}
