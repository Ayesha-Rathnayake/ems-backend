package com.ayesharathnayake.pet.ems.service;

import com.ayesharathnayake.pet.ems.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    //ADD EMPLOYEE
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    //GET EMPLOYEE
    EmployeeDto getEmployeeById(Long employeeId);

    //get All employees
    List<EmployeeDto> getAllEmployees();

    //update employee
    EmployeeDto updateEmployee(Long employeeId, EmployeeDto UpdatedEmployee);

    //delete employee
    void deleteEmployee(Long employeeId);
}
