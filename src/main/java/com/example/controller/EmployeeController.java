package com.example.controller;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

  private final EmployeeService employeeService;

  @Autowired
  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping
  public List<Employee> listEmployees() {
    return employeeService.listEmployees();
  }

  @PostMapping
  public Employee createEmployee(@RequestBody Employee employee) {
    return employeeService.createEmployee(employee);
  }

  @GetMapping("/{id}")
  public Optional<Employee> getEmployee(@PathVariable("id") String employeeId) {
    return employeeService.getEmployee(employeeId);
  }

  @DeleteMapping("/{id}")
  public void deleteEmployee(@PathVariable("id") String employeeId) {
    employeeService.deleteEmployee(employeeId);
  }

}
