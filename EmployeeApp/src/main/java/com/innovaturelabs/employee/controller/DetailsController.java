package com.innovaturelabs.employee.controller;


import javax.validation.Valid;

import com.innovaturelabs.common.entity.Detail;
import com.innovaturelabs.common.entity.Employee;
import com.innovaturelabs.common.repository.DetailRepository;
import com.innovaturelabs.common.repository.EmployeeRepository;
import com.innovaturelabs.employee.exception.FileStorageException;
import com.innovaturelabs.employee.security.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.StringUtils;
import com.innovaturelabs.common.form.DetailForm;
import com.innovaturelabs.employee.service.DetailService;
import com.innovaturelabs.employee.view.DetailDetailView;
import com.innovaturelabs.employee.view.DetailListView;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/details")
public class DetailsController {

    @Autowired
    private DetailService detailService;

    @Autowired
    private DetailRepository detailRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<DetailListView> list() {
        return detailService.list();
    }


    @PutMapping()
    public DetailDetailView update(DetailForm form,@RequestParam("file") MultipartFile file) {
        return detailService.update(form,file);
    }

    @PostMapping("/uploadfile")
    public DetailDetailView uploadfile(DetailForm form, @RequestParam("file") MultipartFile file) {
        return detailService.uploadfile(form,file);
    }

    @DeleteMapping()
    public void delete(Integer employeeId) {
        detailService.delete(SecurityUtil.getCurrentUserId());
    }
}
