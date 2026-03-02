package com.priya.dao;

import java.util.List;
import java.util.Optional;

import com.priya.entity.EmployeeEntity;

public interface EmployeeDAO {

    String addEmployees(List<EmployeeEntity> employees);

    Optional<EmployeeEntity> findById(Integer id);
    
    boolean existsById(Integer id);
    
    List<EmployeeEntity> findAll();

    List<EmployeeEntity> findByEmpName(String empName);

    List<EmployeeEntity> findByEmpCity(String empCity);

    List<EmployeeEntity> findByEmpType(String empType);

    void deleteById(Integer id);

    EmployeeEntity updateEmployee(EmployeeEntity entity);
}