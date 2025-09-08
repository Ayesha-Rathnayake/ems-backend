package com.ayesharathnayake.pet.ems.service.impl;

import com.ayesharathnayake.pet.ems.dto.EmployeeDto;
import com.ayesharathnayake.pet.ems.entity.Employee;
import com.ayesharathnayake.pet.ems.exception.ResourceNotFoundException;
import com.ayesharathnayake.pet.ems.mapper.EmployeeMapper;
import com.ayesharathnayake.pet.ems.repository.EmployeeRepository;
import com.ayesharathnayake.pet.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    //ADD EMPLOYEE
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        //convert employeeDto into employee  Jpa entity
        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);

        Employee  savedEmployee=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
    //GET EMPLOYEE
    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee=employeeRepository.findById(employeeId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Employee is not exist with the given id : "+employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    //GET ALL EMPLOYEES
    @Override
    public List<EmployeeDto> getAllEmployees() {

       List<Employee> employees  = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    //Update employee

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto UpdatedEmployee) {
        Employee employee=employeeRepository.findById(employeeId)
                .orElseThrow(
                        ()-> new ResourceNotFoundException("Employee is not exist with the given id : "+employeeId));

        employee.setFirstName(UpdatedEmployee.getFirstName());
        employee.setLastName(UpdatedEmployee.getLastName());
        employee.setEmail(UpdatedEmployee.getEmail());

        Employee UpdatedEmployeeObj=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(UpdatedEmployeeObj);
    }

    //delete employee
    @Override
    public void deleteEmployee(Long employeeId) {
       Employee employee= employeeRepository.findById(employeeId)
                .orElseThrow(
                        ()->new ResourceNotFoundException("Employee is not exist with the given id :"+employeeId));
       employeeRepository.deleteById(employeeId);
    }
}
