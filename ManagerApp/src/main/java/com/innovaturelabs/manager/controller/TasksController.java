package com.innovaturelabs.manager.controller;

import com.innovaturelabs.common.form.TasksForm;
import com.innovaturelabs.manager.service.TasksService;
import com.innovaturelabs.manager.view.TasksListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author Sreesanth
 */
@RestController
@RequestMapping("/tasks")
public class TasksController {

    @Autowired
    private TasksService tasksService;

    @PostMapping()
    public void add(@RequestBody TasksForm form) {
        tasksService.add(form);
    }

    @GetMapping()
    public List<TasksListView> list() {
        return tasksService.list();
    }

    @GetMapping("/sectionId/{sectionId}")
    public List<TasksListView> listBySectionId(@PathVariable Integer sectionId) {
        return tasksService.listBySectionId(sectionId);
    }

    @PutMapping("/taskId/{taskId}")
    public TasksListView update(@PathVariable Integer taskId, @RequestBody TasksForm form) {
        return tasksService.update(taskId, form);
    }

}
