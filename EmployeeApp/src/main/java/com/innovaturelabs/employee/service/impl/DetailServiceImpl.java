package com.innovaturelabs.employee.service.impl;



import java.io.File;
import java.io.IOException;
import java.security.PublicKey;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import com.innovaturelabs.common.entity.Employee;
import com.innovaturelabs.common.repository.EmployeeRepository;
import com.innovaturelabs.employee.exception.FileStorageException;
import com.innovaturelabs.employee.view.DetailListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovaturelabs.common.entity.Detail;
import com.innovaturelabs.common.form.DetailForm;
import com.innovaturelabs.common.repository.DetailRepository;
import com.innovaturelabs.employee.service.DetailService;
import com.innovaturelabs.employee.view.DetailDetailView;
import com.innovaturelabs.employee.exception.NotFoundException;
import com.innovaturelabs.employee.security.util.SecurityUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


@Service
@Transactional
public class DetailServiceImpl implements DetailService{

    @Autowired
    private DetailRepository detailRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<DetailListView> list() {
        return StreamSupport.stream(detailRepository
                .findAllByEmployeeEmployeeId(SecurityUtil.getCurrentUserId()).spliterator(), false)
                .map(detail -> new DetailListView(detail))
                .collect(Collectors.toList());
    }

    @Override
    public DetailDetailView uploadfile(DetailForm form,MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            Employee employee=employeeRepository.findById(SecurityUtil.getCurrentUserId());
            detailRepository.save(new Detail(form,employee.getEmployeeId()));
            Detail detail= detailRepository.findByEmployeeEmployeeId(employee.getEmployeeId());
            detail.setPhotos(fileName);
            file.transferTo(new File("/home/vivekantony/Desktop/Manager-Employee-Management/EmployeeAngular/src/assets/" + fileName));
            return new DetailDetailView(detailRepository.save(detail));
        }
        catch (IOException ex)
        {
            throw new FileStorageException("Could not store file " +fileName+ ". Please try again!", ex);
        }
    }
    @Override
    @Transactional
    public DetailDetailView update(DetailForm form, MultipartFile file) throws NotFoundException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            Employee employee=employeeRepository.findById(SecurityUtil.getCurrentUserId());
            Detail detail= detailRepository.findByEmployeeEmployeeId(employee.getEmployeeId());
            detail.setFirstName(form.getFirstName());
            detail.setLastName(form.getLastName());
            detail.setDob(form.getDob());
            detail.setAddress(form.getAddress());
            detail.setCity(form.getCity());
            detail.setState(form.getState());
            detail.setCountry(form.getCountry());
            detail.setPhone(form.getPhone());
            detail.setProfilePic(form.getProfilePic());
            detail.setPhotos(fileName);
            file.transferTo(new File("/home/vivekantony/Desktop/Manager-Employee-Management/EmployeeAngular/src/assets/" + fileName));
            return new DetailDetailView(detailRepository.save(detail));
        }
        catch (IOException ex)
        {
            throw new FileStorageException("Could not store file " +fileName+ ". Please try again!", ex);
        }
    }
    @Override
    @Transactional
    public void delete(Integer employeeId) throws NotFoundException{
        detailRepository.delete(detailRepository.findByEmployeeEmployeeId(employeeId));
    }
}
