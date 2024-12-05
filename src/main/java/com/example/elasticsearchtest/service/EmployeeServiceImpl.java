package com.example.elasticsearchtest.service;

import com.example.elasticsearchtest.dto.EmployeeDto;
import com.example.elasticsearchtest.exception.EmployeeNotFoundException;
import com.example.elasticsearchtest.mapper.EmployeeMapper;
import com.example.elasticsearchtest.model.Employee;
import com.example.elasticsearchtest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


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
    public EmployeeDto getEmployeeById(String employeeId) throws EmployeeNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee with id - " + employeeId + " not found.");
        }
        return EmployeeMapper.mapToEmployeeDto(employee.get());
    }

    @Override
    public List<EmployeeDto> getEmployees() {
        Iterable<Employee> employeesIterable = employeeRepository.findAll();
        List<Employee> employees = StreamSupport.stream(employeesIterable.spliterator(), false).toList();
        return employees.stream().map((emp) -> EmployeeMapper.mapToEmployeeDto(emp)).collect(Collectors.toList());
    }

    @Override
    public void deleteEmployee(String employeeId) throws EmployeeNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee with id - " + employeeId + " not found.");
        }
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) throws EmployeeNotFoundException {
        Optional<Employee> retrievedEmployee = employeeRepository.findById(employeeDto.getId());
        if (retrievedEmployee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee with id - " + employeeDto.getId() + " not found.");
        }
        Employee employee = retrievedEmployee.get();
        employee.setName(employeeDto.getName());
        employee.setDepartment(employeeDto.getDepartment());
        Employee createdEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(createdEmployee);
    }


    @Override
    public Page<EmployeeDto> getPaginatedEmployees(int pageNo, int size) {
        PageRequest pageable = PageRequest.of(pageNo, size);
        Page<Employee> employeePage = employeeRepository.findAll(pageable);
        Page<EmployeeDto> employeeDtoPage = employeePage.map(EmployeeMapper::mapToEmployeeDto);
        return employeeDtoPage;
    }


}
