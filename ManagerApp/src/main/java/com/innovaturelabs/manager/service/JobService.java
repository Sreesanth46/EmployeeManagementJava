package com.innovaturelabs.manager.service;

import com.innovaturelabs.common.form.JobForm;
import com.innovaturelabs.manager.view.JobListView;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Sreesanth
 */
public interface JobService {

    void add(JobForm form);

    List<JobListView> list();

    List<JobListView> listByProjectId(Integer projectId);

    List<JobListView> listByEmployeeId(Integer employeeId);

    List<Map<Integer, Map<String, Map<String, Integer>>>> getCount();
}
