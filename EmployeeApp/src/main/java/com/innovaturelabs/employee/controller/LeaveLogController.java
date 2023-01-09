package com.innovaturelabs.employee.controller;

import com.innovaturelabs.common.form.LeaveLogForm;
import com.innovaturelabs.employee.service.LeaveLogService;
import com.innovaturelabs.employee.view.LeaveListView;
import com.innovaturelabs.employee.view.LeaveLogListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/leaveLog")
public class LeaveLogController {

    @Autowired
    private LeaveLogService leaveLogService;

    @PostMapping()
    public LeaveLogListView add(@RequestBody LeaveLogForm form) {
       return leaveLogService.add(form);
    }

    @GetMapping("/leaves")
    public List<LeaveListView> display(){
        return leaveLogService.display();
    }

    @GetMapping()
    public List<LeaveLogListView> list() {
        return leaveLogService.list();
    }
}
