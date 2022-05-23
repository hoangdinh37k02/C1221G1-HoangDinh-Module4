package com.codegym.service.employee;

import com.codegym.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<Employee> findAll(String nameVal, Pageable pageable);

    void save(Employee employee);

    Employee findById(int employeeId);
}
