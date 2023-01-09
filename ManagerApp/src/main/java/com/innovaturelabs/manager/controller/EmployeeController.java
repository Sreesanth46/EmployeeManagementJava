package com.innovaturelabs.manager.controller;

import com.innovaturelabs.common.entity.Detail;
import com.innovaturelabs.common.form.EmployeeForm;
import com.innovaturelabs.manager.service.EmployeeService;
import com.innovaturelabs.manager.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Sreesanth
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    @PostMapping
    public EmployeeDetailView add(@RequestBody EmployeeForm form) {
        return employeeService.addEmployee(form);
    }

    @GetMapping
    public List<EmployeeListView> list() {
        return employeeService.list();
    }

    @GetMapping("/count")
    public Long count() {
        return employeeService.count();
    }

    @GetMapping("/sortNameASC")
    public List<EmployeeListView> sortByNameAsc() {
        return employeeService.sortASC();
    }

    @GetMapping("/sortNameDESC")
    public List<EmployeeListView> sortByNameDesc() {
        return employeeService.sortDESC();
    }

    @GetMapping("/sortIdASC")
    public List<EmployeeListView> sortByIdAsc() {
        return employeeService.sortByIdAsc();
    }

    @GetMapping("/sortIdDESC")
    public List<EmployeeListView> sortByIdDesc() {
        return employeeService.sortByIdDesc();
    }

    @PutMapping("/{employeeId}")
    public EmployeeDetailView update(
            @PathVariable("employeeId") Integer employeeId,
            @RequestBody EmployeeForm form)     {
        return employeeService.update(employeeId, form);
    }

    @GetMapping("/{employeeId}/details")
    public List<DetailsListView> getDetails(@PathVariable Integer employeeId) {
        return employeeService.getDetails(employeeId);
    }

    @DeleteMapping("/softDelete/{employeeId}")
    public EmployeeDetailView softDelete(@PathVariable Integer employeeId) {
        return employeeService.softDelete(employeeId);
    }

    @GetMapping("/softDelete")
    public List<EmployeeListView> softDelete() {
        return employeeService.getSoftDeleteEmployee();
    }

    @GetMapping("/active")
    public List<EmployeeListView> listActive() {
        return employeeService.getActiveEmployees();
    }
}
