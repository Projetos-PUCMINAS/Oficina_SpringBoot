package com.javainuse.boot_crud.mapper;

import com.javainuse.boot_crud.dto.EmployeeDto;
import com.javainuse.boot_crud.model.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(employee.getId(),employee.getName(),employee.getDepartment());
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(employeeDto.getId(),employeeDto.getName(),employeeDto.getDepartment());
    }
}
