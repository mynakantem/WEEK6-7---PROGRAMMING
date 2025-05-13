package com.example.payroll.service;

import com.example.payroll.model.Employee;
import com.example.payroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAll() {
        return repository.findAll();
    }

    public Employee getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    public Employee update(Long id, Employee employee) {
        employee.setId(id);
        return repository.save(employee);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
