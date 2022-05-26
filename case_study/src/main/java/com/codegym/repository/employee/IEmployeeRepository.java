package com.codegym.repository.employee;

import com.codegym.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    Page<Employee> findAllByEmployeeNameContaining(String name, Pageable pageable);
    Page<Employee> findAllByStatusAndEmployeeNameContainingAndEmailContaining(int i,String name, String email,Pageable pageable);
    Page<Employee> findAllByStatusAndEmployeeNameContainingAndEmailContainingAndDivision_Id(int i,String name, String email,int division,Pageable pageable);
}
