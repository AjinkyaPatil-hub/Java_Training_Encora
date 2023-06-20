package com.assg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assg.entity.EmployeModel;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeModel, Integer> {

}
