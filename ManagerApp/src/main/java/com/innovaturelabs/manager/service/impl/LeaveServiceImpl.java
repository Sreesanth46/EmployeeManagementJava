package com.innovaturelabs.manager.service.impl;

import com.innovaturelabs.common.entity.Leaves;
import com.innovaturelabs.common.form.LeaveForm;
import com.innovaturelabs.common.repository.LeaveRepository;
import com.innovaturelabs.manager.exception.NotFoundException;
import com.innovaturelabs.manager.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Sreesanth
 */
@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;

    @Override
    public void add(LeaveForm form) {
        form.getEmployeeId().forEach(employeeId ->{
            if(leaveRepository.findByEmployeeEmployeeId(employeeId).isEmpty()) {
                leaveRepository.save(new Leaves(employeeId, form.getCasualLeave(), form.getSickLeave(), form.getEarnedLeave()));
            } else {
                Leaves leaves = leaveRepository.findByEmployeeEmployeeId(employeeId).orElseThrow(NotFoundException::new);
                leaves.setCasualLeave(form.getCasualLeave());
                leaves.setSickLeave(form.getSickLeave());
                leaves.setEarnedLeave(form.getEarnedLeave());
                leaveRepository.save(leaves);
            }
        });
    }

    @Override
    public List<Leaves> list() {
        return  leaveRepository.findAll();
    }
}
