package com.example.bilforhandler.Service;

import com.example.bilforhandler.Model.Employees;
import com.example.bilforhandler.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employees> findAll() {
        return employeeRepository.findAll();
    }

    public Employees checkCredentials(Employees em) {
        List<Employees> findAll = employeeRepository.findAll();
        for(Employees checkCredentials : findAll) {
            if(em.getUsername().equals(checkCredentials.getUsername()) && em.getPassword().equals(checkCredentials.getPassword())) {
                return em;
            }
        }
        return null;
    }

    public List<Employees> findEmployeeByTitel() {
        Employees em = new Employees();
        List<Employees> findEmployee = employeeRepository.findAll();
        List<Employees> addEmployeeByTitel = new ArrayList<>();
        for(Employees i : findEmployee) {
            if(i.getEmployeeType().equals(em.getEmployeeType())) {
                addEmployeeByTitel.add(i);
            }
        }
        return addEmployeeByTitel;
    }

    public Employees saveEmployee(Employees em) {
        return employeeRepository.save(em);
    }
}
