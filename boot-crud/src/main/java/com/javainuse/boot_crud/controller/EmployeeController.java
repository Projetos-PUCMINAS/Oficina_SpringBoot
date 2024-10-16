package com.javainuse.boot_crud.controller;

import com.javainuse.boot_crud.dto.EmployeeDto;
import com.javainuse.boot_crud.exception.EmployeeNotFundException;
import com.javainuse.boot_crud.model.Employee;
import com.javainuse.boot_crud.repository.EmployeeRepository;
import com.javainuse.boot_crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping(value = "/employee")
    public ResponseEntity<EmployeeDto>createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto cratedEmployee =employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(cratedEmployee, HttpStatus.CREATED);
    }

    @GetMapping(value = "/employee/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long employeeId)throws EmployeeNotFundException {
        try {
            EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
            return new ResponseEntity<>(employeeDto, HttpStatus.OK);
        }catch (EmployeeNotFundException employeeNotFundException) {
            throw employeeNotFundException;
        }
    }

    @GetMapping(value = "/employees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employeeDtos = employeeService.getAllEmployees();
        return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
    }

    @DeleteMapping(value = "/employee/{employeeId}")
    public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable Long employeeId)throws EmployeeNotFundException {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
