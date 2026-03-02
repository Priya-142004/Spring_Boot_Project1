package com.priya.service;

import java.util.List;

import com.priya.model.EmployeeModel;

public interface EmployeeService {

    
    String addEmployees(List<EmployeeModel> employeeModels); //add

    
    EmployeeModel getEmployeeById(Integer id);  //by id

    List<EmployeeModel> getAllEmployees();   //all

    List<EmployeeModel> getByName(String name);  //by name

    List<EmployeeModel> getByCity(String city);  //by city

    List<EmployeeModel> getByType(String type);  //by type

    EmployeeModel updateEmployee(EmployeeModel employeeModel); //update

    String deleteEmployee(Integer id);  //delete
}