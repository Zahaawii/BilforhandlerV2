package com.example.bilforhandler.Repository;

import com.example.bilforhandler.Model.Cars;
import com.example.bilforhandler.Model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BilforhandlerRepository extends JpaRepository<Cars, Long> {
   //List<Employees> findByIsAdminTrue();
}