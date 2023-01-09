package com.innovaturelabs.manager.service.impl;

import com.innovaturelabs.common.entity.PhaseSection;
import com.innovaturelabs.common.entity.ProjectPhase;
import com.innovaturelabs.common.form.PhaseSectionForm;
import com.innovaturelabs.common.repository.PhaseSectionRepository;
import com.innovaturelabs.common.repository.ProjectPhaseRepository;
import com.innovaturelabs.manager.exception.BadRequestException;
import com.innovaturelabs.manager.exception.NotFoundException;
import com.innovaturelabs.manager.service.PhaseSectionService;
import com.innovaturelabs.manager.view.PhaseSectionListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 *
 * @author Sreesanth
 */
@Service
public class PhaseSectionServiceImpl implements PhaseSectionService {

    @Autowired
    private PhaseSectionRepository phaseSectionRepository;

    @Autowired
    private ProjectPhaseRepository projectPhaseRepository;

    @Override
    public void add(PhaseSectionForm form) throws BadRequestException {
        Optional<ProjectPhase> projectPhase = projectPhaseRepository.findByPhaseId(form.getPhaseId());
        if(projectPhase.isPresent()) {
            phaseSectionRepository.save(new PhaseSection(form));
        }
        else {
            throw new BadRequestException("No Project Phase with given Id found");
        }
    }

    @Override
    public List<PhaseSection> list() {
        return new ArrayList<>(phaseSectionRepository.findAll());
    }

    @Override
    public List<PhaseSectionListView> listByPhaseId(Integer phaseId) {
        return phaseSectionRepository.findAllByProjectPhasePhaseId(phaseId).stream()
                .map(PhaseSectionListView::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<PhaseSectionListView> listBySectionId(Integer sectionId) {
        return phaseSectionRepository.findByPhaseSectionId(sectionId).stream()
                .map(PhaseSectionListView::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PhaseSectionListView update(Integer sectionId, PhaseSectionForm form) throws NotFoundException {
        return phaseSectionRepository.findByPhaseSectionId(sectionId)
                .map(section -> {
                    return new PhaseSectionListView(phaseSectionRepository.save((section.update(form))));
                }).orElseThrow(NotFoundException::new);
    }
}
