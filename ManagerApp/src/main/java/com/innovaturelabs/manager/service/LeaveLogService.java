package com.innovaturelabs.manager.service;

import com.innovaturelabs.manager.view.LeaveLogListView;

import java.util.List;

public interface LeaveLogService {

    void approve(Byte approveStatus, Integer leaveLogId);

    List<LeaveLogListView> list();

    List<LeaveLogListView> listNotApproved();

    List<LeaveLogListView> listApproved();

    List<LeaveLogListView> listDeclined();
}
