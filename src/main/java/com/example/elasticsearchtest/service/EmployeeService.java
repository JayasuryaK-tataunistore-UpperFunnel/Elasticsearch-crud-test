package com.example.elasticsearchtest.service;

import com.example.elasticsearchtest.dto.EmployeeDto;
import com.example.elasticsearchtest.exception.EmployeeNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(String employeeId) throws EmployeeNotFoundException;

    List<EmployeeDto> getEmployees();

    void deleteEmployee(String employeeId) throws EmployeeNotFoundException;

    EmployeeDto updateEmployee(EmployeeDto employeeDto) throws EmployeeNotFoundException;

    Page<EmployeeDto> getPaginatedEmployees(int page, int size);


}
