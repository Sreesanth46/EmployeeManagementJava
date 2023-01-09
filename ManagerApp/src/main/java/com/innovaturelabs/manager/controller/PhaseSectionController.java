package com.innovaturelabs.manager.controller;

import com.innovaturelabs.common.entity.PhaseSection;
import com.innovaturelabs.common.form.PhaseSectionForm;
import com.innovaturelabs.manager.service.PhaseSectionService;
import com.innovaturelabs.manager.view.PhaseSectionListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author Sreesanth
 */
@RestController
@RequestMapping("/phaseSection")
public class PhaseSectionController {

    @Autowired
    private PhaseSectionService phaseSectionService;

    @PostMapping()
    public void add(@RequestBody PhaseSectionForm form) {
        phaseSectionService.add(form);
    }

    @GetMapping
    public List<PhaseSection> list() {
        return phaseSectionService.list();
    }

    @GetMapping("/phaseId/{phaseId}")
    public List<PhaseSectionListView> listByPhaseId(@PathVariable Integer phaseId) {
        return phaseSectionService.listByPhaseId(phaseId);
    }

    @GetMapping("/sectionId/{sectionId}")
    public List<PhaseSectionListView> listBySectionId(@PathVariable Integer sectionId) {
        return phaseSectionService.listBySectionId(sectionId);
    }

    @PutMapping("/sectionId/{sectionId}")
    public PhaseSectionListView update(@PathVariable Integer sectionId, @RequestBody PhaseSectionForm form) {
        return phaseSectionService.update(sectionId, form);
    }
}
