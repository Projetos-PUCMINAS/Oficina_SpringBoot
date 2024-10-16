package com.javainuse.boot_crud.service;

import com.javainuse.boot_crud.dto.EmployeeDto;
import com.javainuse.boot_crud.exception.EmployeeNotFundException;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long id) throws EmployeeNotFundException;
    List<EmployeeDto> getAllEmployees();
    void deleteEmployee(Long id) throws EmployeeNotFundException;
}
