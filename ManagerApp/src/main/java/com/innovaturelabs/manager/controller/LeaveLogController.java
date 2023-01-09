package com.innovaturelabs.manager.controller;

import com.innovaturelabs.manager.service.LeaveLogService;
import com.innovaturelabs.manager.view.LeaveLogListView;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leaveLog")
public class LeaveLogController {

    @Autowired
    private LeaveLogService leaveLogService;

    @PostMapping("/approve/leaveLogId/{leaveLogId}")
    public void approve(@RequestBody Byte approveStatus, @PathVariable Integer leaveLogId) {
        this.leaveLogService.approve(approveStatus, leaveLogId);
    }

    @GetMapping()
    public List<LeaveLogListView> list() {
        return this.leaveLogService.list();
    }

    @GetMapping("/notApproved")
    public List<LeaveLogListView> listNotApproved() {
        return this.leaveLogService.listNotApproved();
    }

    @GetMapping("/approved")
    public List<LeaveLogListView> listApproved() {
        return this.leaveLogService.listApproved();
    }

    @GetMapping("/declined")
    public List<LeaveLogListView> listDeclined() {
        return this.leaveLogService.listDeclined();
    }
}
