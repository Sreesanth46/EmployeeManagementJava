package com.innovaturelabs.manager.service;

import com.innovaturelabs.common.entity.PhaseSection;
import com.innovaturelabs.common.form.PhaseSectionForm;
import com.innovaturelabs.manager.view.PhaseSectionListView;

import java.util.List;

/**
 *
 * @author Sreesanth
 */
public interface PhaseSectionService {

    void add(PhaseSectionForm form);

    List<PhaseSection> list();

    List<PhaseSectionListView> listByPhaseId(Integer phaseId);

    List<PhaseSectionListView> listBySectionId(Integer sectionId);

    PhaseSectionListView update(Integer sectionId, PhaseSectionForm form);
}
