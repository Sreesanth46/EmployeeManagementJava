package com.innovaturelabs.manager.service;

import com.innovaturelabs.common.form.EmployeeForm;
import com.innovaturelabs.manager.view.DetailsListView;
import com.innovaturelabs.manager.view.EmployeeDetailView;
import com.innovaturelabs.manager.view.EmployeeListView;

import java.util.List;

/**
 *
 * @author Sreesanth
 */
public interface EmployeeService {

    EmployeeDetailView addEmployee(EmployeeForm form);

    EmployeeDetailView update(Integer employeeId, EmployeeForm form);

    List<EmployeeListView> list();

    List<EmployeeListView> sortASC();

    List<EmployeeListView> sortDESC();

    List<EmployeeListView> sortByIdAsc();

    List<EmployeeListView> sortByIdDesc();

    Long count();

    List<DetailsListView> getDetails(Integer employeeId);

    EmployeeDetailView softDelete(Integer employeeId);

    List<EmployeeListView> getSoftDeleteEmployee();

    List<EmployeeListView> getActiveEmployees();
}
