package com.innovaturelabs.manager.service.impl;

import com.innovaturelabs.common.entity.PhaseSection;
import com.innovaturelabs.common.entity.Tasks;
import com.innovaturelabs.common.form.TasksForm;
import com.innovaturelabs.common.repository.PhaseSectionRepository;
import com.innovaturelabs.common.repository.TasksRepository;
import com.innovaturelabs.manager.exception.BadRequestException;
import com.innovaturelabs.manager.exception.NotFoundException;
import com.innovaturelabs.manager.service.TasksService;
import com.innovaturelabs.manager.view.TasksListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author Sreesanth
 */
@Service
public class TasksServiceImpl implements TasksService {

    @Autowired
    private TasksRepository tasksRepository;

    @Autowired
    private PhaseSectionRepository phaseSectionRepository;

    @Override
    public void add(TasksForm form) throws BadRequestException {
        Optional<PhaseSection> phaseSection = phaseSectionRepository.findByPhaseSectionId(form.getPhaseSectionId());
        if(phaseSection.isPresent()) {
            tasksRepository.save(new Tasks(form));
        } else {
            throw new BadRequestException("Invalid phaseSectionId - Not found");
        }
    }

    @Override
    public List<TasksListView> list() {
        return tasksRepository
                .findAll().stream()
                .map(TasksListView::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<TasksListView> listBySectionId(Integer sectionId) {
        return tasksRepository
                .findAllByPhaseSectionPhaseSectionId(sectionId).stream()
                .map(TasksListView::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public TasksListView update(Integer taskId, TasksForm form) throws NotFoundException {
        return tasksRepository.findByTaskId(taskId)
                .map(task -> {
                    return new TasksListView(tasksRepository.save(task.update(form)));
                }).orElseThrow(NotFoundException::new);
    }
}
