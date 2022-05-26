package com.codegym.service.employee;

import com.codegym.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> findAll(String nameVal, Pageable pageable);

    void save(Employee employee);

    Employee findById(int employeeId);

    List<Employee> findAll();

    void deleteById(int employeeId);

    Page<Employee> findAll1(int i, String nameVal, String emailVal, Pageable pageable);

    Page<Employee> findAll2(int i, String nameVal, String emailVal, String divisionVal, Pageable pageable);
}
