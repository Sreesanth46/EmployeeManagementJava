package com.innovaturelabs.manager.controller;

import com.innovaturelabs.common.entity.Leaves;
import com.innovaturelabs.common.form.LeaveForm;
import com.innovaturelabs.manager.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leave")

public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @PostMapping()
    public void add(@RequestBody LeaveForm form) {
        leaveService.add(form);
    }

    @GetMapping()
    public List<Leaves> list() {
        return leaveService.list();
    }
}
