package com.innovaturelabs.common.repository;

import  java.util.List;
import java.util.Optional;

import com.innovaturelabs.common.entity.Employee;
import org.springframework.data.repository.Repository;
import com.innovaturelabs.common.entity.Detail;

public interface DetailRepository extends Repository<Detail, Integer>{

        List<Detail> findAllByEmployeeEmployeeId(Integer employeeId);

        Detail findByEmployeeEmployeeId(Integer employeeId);

        void delete(Detail detail);
        Detail save(Detail detail);

}
