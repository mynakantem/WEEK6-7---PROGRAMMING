package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping("/")
    public List<EmployeePayrollData> getAllEmployees() {
        return repository.findAll();
    }

    @GetMapping("/get/{id}")
    public EmployeePayrollData getEmployeeById(@PathVariable int id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/create")
    public EmployeePayrollData createEmployee(@RequestBody EmployeePayrollData employee) {
        return repository.save(employee);
    }

    @PutMapping("/update")
    public EmployeePayrollData updateEmployee(@RequestBody EmployeePayrollData employee) {
        return repository.save(employee);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        repository.deleteById(id);
        return "Employee deleted with ID: " + id;
    }
}
