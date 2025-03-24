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

    public List<Cars> getAllCars() {
        return bilforhandlerRepository.findAll();
    }

    public Cars addCar(Cars cars) {
        return bilforhandlerRepository.save(cars);
    }

    public Cars findCarByID(Cars cars, Long carsID) {
        return bilforhandlerRepository.findById(cars.getId()).get();
    }

}
