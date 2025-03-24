package com.example.bilforhandler.Repository;

import com.example.bilforhandler.Model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employees, Long> {

}
