package com.javainuse.boot_crud.service;

import com.javainuse.boot_crud.dto.EmployeeDto;
import com.javainuse.boot_crud.exception.EmployeeNotFundException;
import com.javainuse.boot_crud.mapper.EmployeeMapper;
import com.javainuse.boot_crud.model.Employee;
import com.javainuse.boot_crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee createdEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(createdEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) throws EmployeeNotFundException {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()){
            throw new EmployeeNotFundException("Employee with id - "+id+" not found.");
        }else{
            return EmployeeMapper.mapToEmployeeDto(employee.get());
        }
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((emp)->EmployeeMapper.mapToEmployeeDto(emp)).collect(Collectors.toList());
    }

    @Override
    public void deleteEmployee(Long id) throws EmployeeNotFundException {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()){
            throw new EmployeeNotFundException("Employee with id - "+id+" not found.");
        }
        employeeRepository.deleteById(id);
    }
}
