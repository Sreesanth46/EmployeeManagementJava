package com.innovaturelabs.manager.service;

import com.innovaturelabs.common.entity.EmployeeJob;
import com.innovaturelabs.common.form.EmployeeJobForm;
import com.innovaturelabs.manager.view.EmployeeJobListView;

import java.util.List;

/**
 *
 * @author Sreesanth
 */
public interface EmployeeJobService {

    EmployeeJobListView add(EmployeeJobForm form);

    EmployeeJobListView update(Integer jobId, EmployeeJobForm form);

    List<EmployeeJobListView> list();
}
