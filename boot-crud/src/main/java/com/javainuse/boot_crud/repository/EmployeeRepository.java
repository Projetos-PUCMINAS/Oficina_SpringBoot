package com.javainuse.boot_crud.repository;

import com.javainuse.boot_crud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
