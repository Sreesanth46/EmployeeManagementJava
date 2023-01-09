package com.innovaturelabs.manager.service;

import com.innovaturelabs.common.form.TasksForm;
import com.innovaturelabs.manager.view.TasksListView;

import java.util.List;

/**
 *
 * @author Sreesanth
 */
public interface TasksService {

    void add(TasksForm form);

    List<TasksListView> list();

    List<TasksListView> listBySectionId(Integer sectionId);

    TasksListView update(Integer taskId, TasksForm form);

}
