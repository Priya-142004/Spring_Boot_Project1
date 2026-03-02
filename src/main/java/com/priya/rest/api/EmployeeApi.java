package com.priya.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.priya.model.EmployeeModel;
import com.priya.service.EmployeeService;

@RestController
@RequestMapping("emp")
public class EmployeeApi {

    @Autowired
    private EmployeeService employeeService;

    // Add Employee
    @PostMapping
    public ResponseEntity<String> addEmployee(
            @RequestBody List<EmployeeModel> employeeModels) {

        return ResponseEntity.ok(
                employeeService.addEmployees(employeeModels));
    }

    // GET By Id
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeModel> getById(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                employeeService.getEmployeeById(id));
    }

    // GET All Employees
    @GetMapping
    public ResponseEntity<List<EmployeeModel>> getAllEmployees() {

        return ResponseEntity.ok(
                employeeService.getAllEmployees());
    }

    // GET By Name
    @GetMapping("/name/{name}")
    public ResponseEntity<List<EmployeeModel>> getByName(
            @PathVariable String name) {

        return ResponseEntity.ok(
                employeeService.getByName(name));
    }

    // GET By City
    @GetMapping("/city/{city}")
    public ResponseEntity<List<EmployeeModel>> getByCity(
            @PathVariable String city) {

        return ResponseEntity.ok(
                employeeService.getByCity(city));
    }

    // GET By Type
    @GetMapping("/type/{type}")
    public ResponseEntity<List<EmployeeModel>> getByType(
            @PathVariable String type) {

        return ResponseEntity.ok(
                employeeService.getByType(type));
    }
    
 // Update Employee
    @PutMapping
    public ResponseEntity<EmployeeModel> updateEmployee(
            @RequestBody EmployeeModel employeeModel) {

        return ResponseEntity.ok(
                employeeService.updateEmployee(employeeModel));
    }

    // Delete Employee
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                employeeService.deleteEmployee(id));
    }
}