package com.innovaturelabs.employee.controller;


import com.innovaturelabs.common.form.EmployeeForm;
import com.innovaturelabs.common.form.ForgotPassword;
import com.innovaturelabs.common.form.ForgotPasswordMailForm;
import com.innovaturelabs.common.form.ResetPasswordForm;
import com.innovaturelabs.employee.service.EmployeeService;
import com.innovaturelabs.employee.view.EmployeeView;
import com.innovaturelabs.employee.security.util.SecurityUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;



    @PutMapping("/reset") 
    public EmployeeView reset(@Valid @RequestBody ResetPasswordForm form) {
        return employeeService.reset(form);
    }

   @PutMapping()
   public EmployeeView update(@Valid @RequestBody EmployeeForm form)
   {

       return employeeService.updateEmployee(SecurityUtil.getCurrentUserId(),form);
   }

   @GetMapping()
   public List<EmployeeView> list()
   {
       return employeeService.list();
   }

   @PostMapping("/forgotPassword")
    public EmployeeView forgotPassword(@Valid @RequestBody ForgotPasswordMailForm form)
   {
        return employeeService.forgotPassword(form);
   }
    
   @PutMapping("/newPassword")
   public EmployeeView newPassword(@Valid @RequestBody ForgotPassword form,@RequestHeader(value ="at")String Token)
   {
        return employeeService.newPassword(form,Token);
   }

}
