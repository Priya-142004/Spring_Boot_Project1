package com.priya.service;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priya.dao.EmployeeDAO;
import com.priya.entity.EmployeeEntity;
import com.priya.exception.DuplicateEmployeeException;
import com.priya.model.EmployeeModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
	private static final Logger logger = 
			LoggerFactory.getLogger(EmployeeServiceImpl.class);
    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private ModelMapper modelMapper;

    // Add Employees
    @Override
    public String addEmployees(List<EmployeeModel> employeeModels) {

        List<EmployeeEntity> entities = employeeModels.stream()
                .map(model -> modelMapper.map(model, EmployeeEntity.class))
                .collect(Collectors.toList());

        for (EmployeeEntity emp : entities) {
            if (employeeDAO.findById(emp.getEmpId()).isPresent()) {
                throw new DuplicateEmployeeException(
                        "Employee ID already exists: " + emp.getEmpId());
            }
        }

        return employeeDAO.addEmployees(entities);
    }

    
    // GET by id
    @Override
    public EmployeeModel getEmployeeById(Integer id) {

        EmployeeEntity entity = employeeDAO.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Employee Not Found with ID: " + id));

        return modelMapper.map(entity, EmployeeModel.class);
    }

    
    // GET All Employees
    @Override
    public List<EmployeeModel> getAllEmployees() {

        List<EmployeeEntity> entities = employeeDAO.findAll();

        return entities.stream()
                .map(entity -> modelMapper.map(entity, EmployeeModel.class))
                .collect(Collectors.toList());
    }

    
    // GET By Name
    @Override
    public List<EmployeeModel> getByName(String name) {

        List<EmployeeEntity> entities = employeeDAO.findByEmpName(name);

        return entities.stream()
                .map(entity -> modelMapper.map(entity, EmployeeModel.class))
                .collect(Collectors.toList());
    }

    
    // GET By City
    @Override
    public List<EmployeeModel> getByCity(String city) {

        List<EmployeeEntity> entities = employeeDAO.findByEmpCity(city);

        return entities.stream()
                .map(entity -> modelMapper.map(entity, EmployeeModel.class))
                .collect(Collectors.toList());
    }

    
    // GET By Type
    @Override
    public List<EmployeeModel> getByType(String type) {

        List<EmployeeEntity> entities = employeeDAO.findByEmpType(type);

        return entities.stream()
                .map(entity -> modelMapper.map(entity, EmployeeModel.class))
                .collect(Collectors.toList());
    }

    
    // Update Employee
    @Override
    public EmployeeModel updateEmployee(EmployeeModel model) {

        logger.info("Update request received for Employee ID: {}", model.getEmpId());

        EmployeeEntity entity = employeeDAO.findById(model.getEmpId())
                .orElseThrow(() -> {
                    logger.error("Employee not found with ID: {}", model.getEmpId());
                    return new RuntimeException("Employee Not Found");
                });

        entity.setEmpName(model.getEmpName());
        entity.setEmpCity(model.getEmpCity());
        entity.setEmpType(model.getEmpType());

        EmployeeEntity updated = employeeDAO.updateEmployee(entity);

        logger.info("Employee updated successfully with ID: {}", updated.getEmpId());

        return modelMapper.map(updated, EmployeeModel.class);
    }

    
    // Delete Employee
    
    @Override
    public String deleteEmployee(Integer id) {

        logger.info("Delete request received for Employee ID: {}", id);

        if (!employeeDAO.existsById(id)) {
            logger.error("Attempted to delete non-existing Employee ID: {}", id);
            throw new RuntimeException("Employee Not Found");
        }

        employeeDAO.deleteById(id);

        logger.info("Employee deleted successfully with ID: {}", id);

        return "Employee Deleted Successfully";
    }
}