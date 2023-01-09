package com.innovaturelabs.common.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.innovaturelabs.common.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends Repository<Employee, Integer> {

   Employee save(Employee employee);

   List<Employee> findAll();

   List<Employee> findAllByStatus(byte status);

   Optional<Employee> findByEmployeeId(Integer employeeId);

   Optional<Employee> findByEmployeeIdAndPassword(Integer employeeId, String password);

   Optional<Employee> findByEmployeeEmail(String employeeEmail);

    Employee findById(Integer id);

   @Query(value = "SELECT * FROM employee WHERE status=\" +1 + \" ORDER BY employee_name ASC", nativeQuery = true)
   List<Employee> findAllOrderByEmployeeNameAsc();

   @Query(value = "SELECT * FROM employee WHERE status=\" +1 + \" ORDER BY employee_name DESC", nativeQuery = true)
   List<Employee> findAllOrderByEmployeeNameDesc();

   @Query(value = "SELECT * FROM employee WHERE status=\" +1 + \" ORDER BY employee_id ASC", nativeQuery = true)
   List<Employee> findAllOrderByEmployeeIdAsc();

   @Query(value = "SELECT * FROM employee WHERE status=\" +1 + \"ORDER BY employee_id DESC", nativeQuery = true)
   List<Employee> findAllOrderByEmployeeIdDesc();

   Long count();
}
