package com.innovaturelabs.employee.service;

import java.io.IOException;
import java.util.List;

import com.innovaturelabs.common.form.DetailForm;
import com.innovaturelabs.employee.exception.NotFoundException;
import com.innovaturelabs.employee.view.DetailDetailView;
import com.innovaturelabs.employee.view.DetailListView;
import org.springframework.web.multipart.MultipartFile;

public interface DetailService {

    List<DetailListView> list();

    DetailDetailView uploadfile(DetailForm form,MultipartFile file) ;

    DetailDetailView update(DetailForm form,MultipartFile file);

    void delete(Integer employeeId);
}
