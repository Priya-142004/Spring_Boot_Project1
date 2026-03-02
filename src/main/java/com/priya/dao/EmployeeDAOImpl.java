package com.priya.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.priya.entity.EmployeeEntity;
import com.priya.repository.EmployeeRepository;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public String addEmployees(List<EmployeeEntity> employees) {
        repository.saveAll(employees);
        return "Employees Added Successfully";
    }

    @Override
    public Optional<EmployeeEntity> findById(Integer id) {
        return repository.findById(id);
    }
    
    @Override
    public boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    @Override
    public List<EmployeeEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public List<EmployeeEntity> findByEmpName(String empName) {
        return repository.findByEmpName(empName);
    }

    @Override
    public List<EmployeeEntity> findByEmpCity(String empCity) {
        return repository.findByEmpCity(empCity);
    }

    @Override
    public List<EmployeeEntity> findByEmpType(String empType) {
        return repository.findByEmpType(empType);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public EmployeeEntity updateEmployee(EmployeeEntity entity) {
        return repository.save(entity);
    }
}
