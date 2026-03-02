package com.priya.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.priya.entity.EmployeeEntity;

public interface EmployeeRepository 
        extends JpaRepository<EmployeeEntity, Integer> {

    List<EmployeeEntity> findByEmpName(String empName);

    List<EmployeeEntity> findByEmpCity(String empCity);

    List<EmployeeEntity> findByEmpType(String empType);
    
    
}
