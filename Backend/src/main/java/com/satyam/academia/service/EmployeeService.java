package com.satyam.academia.service;

import com.satyam.academia.entity.Employee;
import com.satyam.academia.helper.EncryptionService;
import com.satyam.academia.repo.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EncryptionService encryptionService;

    @Transactional
    public Employee createEmployee(Employee employee) {

     // Save the employee
        employee.setPassword(encryptionService.encode(employee.getPassword()));
        return employeeRepository.save(employee);
    }
}