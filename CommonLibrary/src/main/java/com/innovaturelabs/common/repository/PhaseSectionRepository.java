package com.innovaturelabs.common.repository;

import com.innovaturelabs.common.entity.PhaseSection;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface PhaseSectionRepository extends Repository<PhaseSection, Integer> {

    PhaseSection save(PhaseSection phaseSection);

    List<PhaseSection> findAll();

    List<PhaseSection> findAllByProjectPhasePhaseId(Integer phaseId);

    Optional<PhaseSection> findByPhaseSectionId(Integer phaseSectionId);
}
