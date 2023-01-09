package com.innovaturelabs.employee.service;

import java.util.List;
import com.innovaturelabs.common.form.ResetStatusForm;
import com.innovaturelabs.employee.view.JobListView;

public interface JobService {

       List<JobListView> list(Integer employeeId);

       JobListView update(Integer jobId, ResetStatusForm form);
}
