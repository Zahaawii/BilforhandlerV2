package com.example.bilforhandler.Service;

import com.example.bilforhandler.Model.Cars;
import com.example.bilforhandler.Model.Employees;
import com.example.bilforhandler.Repository.BilforhandlerRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BilforhandlerService {

    private final BilforhandlerRepository bilforhandlerRepository;

    public BilforhandlerService(BilforhandlerRepository bilforhandlerRepository) {
        this.bilforhandlerRepository = bilforhandlerRepository;
    }

    public List<Employees> getAllEmployees() {
        return bilforhandlerRepository.getUsers();
    }

    public List<Cars> getAllCars() {
        return bilforhandlerRepository.getCars();
    }

    public Employees checkCredentials(Employees em) {
       return bilforhandlerRepository.checkCredentials(em);
    }

}
