package com.innovaturelabs.manager.view;

import com.innovaturelabs.common.entity.Employee;

/**
 *
 * @author Sreesanth
 */
public class EmployeeDetailView extends EmployeeListView {

    public EmployeeDetailView(Employee employee) {
        super(
            employee.getEmployeeId(),
            employee.getEmployeeName(),
            employee.getEmployeeEmail(),
            employee.getStatus()
        );
    }

}
