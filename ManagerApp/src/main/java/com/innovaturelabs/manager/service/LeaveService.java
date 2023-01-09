package com.innovaturelabs.manager.service;

import com.innovaturelabs.common.entity.Leaves;
import com.innovaturelabs.common.form.LeaveForm;

import java.util.List;

/**
 *
 * @author Sreesanth
 */
public interface LeaveService {

    void add(LeaveForm form);

    List<Leaves> list();
}
