package com.example.bilforhandler.Repository;

import java.util.ArrayList;
import java.util.List;

import com.example.bilforhandler.Model.Cars;
import com.example.bilforhandler.Model.Employees;
import com.example.bilforhandler.Model.EmployeeType;
import org.springframework.stereotype.Repository;


@Repository
public class BilforhandlerRepository {

    List<Employees> users = new ArrayList<>();
    List<Cars> cars = new ArrayList<>();

    public List<Employees> createUser(Employees b1) {
       users.add(b1);
       return users;
    }

    public BilforhandlerRepository() {
        initUsers();
    }

    private void initUsers() {
      users.add(new Employees("Admin", "test", true, EmployeeType.IT));
      users.add(new Employees("Omar", "test", false, EmployeeType.SALES));
      users.add(new Employees("Zahaa", "test", true, EmployeeType.CEO));
    }

    private void initCars() {
        cars.add(new Cars("Porsche", "911", false, 0.00));
        cars.add(new Cars("Audi", "A8", false, 0.00));
        cars.add(new Cars("Tesla", "2", false, 0.00));
    }

    public List<Employees> getUsers() {
        return users;
    }

    public List<Cars> getCars() {
        return cars;
    }

    public Employees checkCredentials(Employees em) {
        List<Employees> allEmployees = getUsers();
        for(Employees i : allEmployees) {
            if(i.getUsername().equals(em.getUsername()) && i.getPassword().equals(em.getPassword())) {
                return i;
            }
        }
        return null;
    }
}
