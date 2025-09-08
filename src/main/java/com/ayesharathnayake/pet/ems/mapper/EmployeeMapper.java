package com.ayesharathnayake.pet.ems.mapper;

import com.ayesharathnayake.pet.ems.dto.EmployeeDto;
import com.ayesharathnayake.pet.ems.entity.Employee;


//employeeMapper class has created to  connect employee jpa entity into employeeDto &
// connect employeeDto into employee jpa entity
public class EmployeeMapper {

    //this method converts employee jpa entity into employeeDto


    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }


    //this method converts employeeDto into employee jpa  entity
    public static Employee  mapToEmployee(EmployeeDto employeeDto) {
        return new   Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
