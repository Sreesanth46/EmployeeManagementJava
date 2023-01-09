package com.innovaturelabs.employee.service;


import com.innovaturelabs.common.form.LeaveLogForm;
import com.innovaturelabs.employee.view.LeaveListView;
import com.innovaturelabs.employee.view.LeaveLogListView;
import java.util.List;

public interface LeaveLogService {

    LeaveLogListView add(LeaveLogForm form);

    List<LeaveLogListView> list();

    List<LeaveListView> display();
}
