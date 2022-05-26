package com.codegym.service.employee.impl;

import com.codegym.model.employee.Employee;
import com.codegym.repository.employee.IEmployeeRepository;
import com.codegym.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public Page<Employee> findAll(String nameVal, Pageable pageable) {
        return this.iEmployeeRepository.findAllByEmployeeNameContaining(nameVal, pageable);
    }

    @Override
    public void save(Employee employee) {
        this.iEmployeeRepository.save(employee);
    }

    @Override
    public Employee findById(int employeeId) {
        return this.iEmployeeRepository.findById(employeeId).orElse(null);
    }

    @Override
    public List<Employee> findAll() {
        return this.iEmployeeRepository.findAll();
    }

    @Override
    public void deleteById(int employeeId) {
        this.iEmployeeRepository.deleteById(employeeId);
    }

    @Override
    public Page<Employee> findAll1(int i, String nameVal, String emailVal, Pageable pageable) {
        return this.iEmployeeRepository.findAllByStatusAndEmployeeNameContainingAndEmailContaining(0,nameVal,emailVal,pageable);
    }

    @Override
    public Page<Employee> findAll2(int i, String nameVal, String emailVal, String divisionVal, Pageable pageable) {
        return this.iEmployeeRepository.findAllByStatusAndEmployeeNameContainingAndEmailContainingAndDivision_Id(0,nameVal,emailVal,Integer.parseInt(divisionVal),pageable);
    }
}
