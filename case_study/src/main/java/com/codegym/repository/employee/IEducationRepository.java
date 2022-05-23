package com.codegym.repository.employee;

import com.codegym.model.employee.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEducationRepository extends JpaRepository<Education, Integer> {
}
