package com.innovaturelabs.manager.service.impl;

import com.innovaturelabs.common.entity.LeaveLog;
import com.innovaturelabs.common.entity.Leaves;
import com.innovaturelabs.common.repository.LeaveLogRepository;
import com.innovaturelabs.common.repository.LeaveRepository;
import com.innovaturelabs.manager.exception.BadRequestException;
import com.innovaturelabs.manager.exception.NotFoundException;
import com.innovaturelabs.manager.service.LeaveLogService;
import com.innovaturelabs.manager.view.LeaveLogListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaveLogServiceImpl implements LeaveLogService {

    @Autowired
    private LeaveLogRepository leaveLogRepository;

    @Autowired
    private LeaveRepository leaveRepository;

    @Override
    public  void approve(Byte approveStatus, Integer leaveLogId) {
        LeaveLog leaveLog = leaveLogRepository.findByLeaveLogId(leaveLogId).orElseThrow(NotFoundException::new);
            leaveLog.setLeaveStatus(approveStatus);
            leaveLog.setAprovedDate(new Date());
            leaveLogRepository.save(leaveLog);

        Leaves leaves = leaveRepository.findByLeaveId(leaveLog.getLeaves().getLeaveId()).orElseThrow(NotFoundException::new);
        if(approveStatus == LeaveLog.Status.APPROVED.value) {
            switch (leaveLog.getLeaveType()) {
                case 1:
                    if(leaves.getCasualLeave() != 0) {
                        leaves.setCasualLeave(leaves.getCasualLeave() - 1);
                        leaveRepository.save(leaves);
                        System.out.println("Casual Leave Approved");
                    } else {
                        leaveLog.setLeaveStatus(LeaveLog.Status.DECLINED.value);
                        leaveLog.setAprovedDate(new Date());
                        leaveLogRepository.save(leaveLog);
                        throw new BadRequestException("No Casual Leave remaining");
                    }
                    break;
                case 2:
                    if(leaves.getSickLeave() != 0) {
                        leaves.setCasualLeave(leaves.getSickLeave() - 1);
                        leaveRepository.save(leaves);
                        System.out.println("Sick Leave Approved");
                    } else {
                        leaveLog.setLeaveStatus(LeaveLog.Status.DECLINED.value);
                        leaveLog.setAprovedDate(new Date());
                        leaveLogRepository.save(leaveLog);
                        throw new BadRequestException("No Sick Leave remaining");
                    }
                    break;
                case 3:
                    if(leaves.getEarnedLeave() != 0) {
                        leaves.setCasualLeave(leaves.getEarnedLeave() - 1);
                        leaveRepository.save(leaves);
                        System.out.println("Earned Leave Approved");
                    } else {
                        leaveLog.setLeaveStatus(LeaveLog.Status.DECLINED.value);
                        leaveLog.setAprovedDate(new Date());
                        leaveLogRepository.save(leaveLog);
                        throw new BadRequestException("No Earned Leave remaining");
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected Leave Type: " + leaveLog.getLeaveType());
            }
        }
    }

    @Override
    public List<LeaveLogListView> list() {
        return leaveLogRepository.findAll().stream()
                .map(LeaveLogListView::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<LeaveLogListView> listNotApproved() {
        return leaveLogRepository.findAllByLeaveStatus(LeaveLog.Status.NOT_APPROVED.value).stream()
                .map(LeaveLogListView::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<LeaveLogListView> listApproved() {
        return leaveLogRepository.findAllByLeaveStatus(LeaveLog.Status.APPROVED.value).stream()
                .map(LeaveLogListView::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<LeaveLogListView> listDeclined() {
        return leaveLogRepository.findAllByLeaveStatus(LeaveLog.Status.DECLINED.value).stream()
                .map(LeaveLogListView::new)
                .collect(Collectors.toList());
    }
}
