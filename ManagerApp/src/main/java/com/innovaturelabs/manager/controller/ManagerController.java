package com.innovaturelabs.manager.controller;


import com.innovaturelabs.common.form.ManagerForm;
import com.innovaturelabs.manager.service.ManagerService;
import com.innovaturelabs.manager.view.ManagerView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 *
 * @author Sreesanth
 */
@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @PostMapping
    public ManagerView add(@Valid @RequestBody ManagerForm form) {
        return managerService.add(form);
    }
}
