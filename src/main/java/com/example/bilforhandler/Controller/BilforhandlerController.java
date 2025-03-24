package com.example.bilforhandler.Controller;


import com.example.bilforhandler.Model.Cars;
import com.example.bilforhandler.Model.EmployeeType;
import com.example.bilforhandler.Model.Employees;
import com.example.bilforhandler.Service.BilforhandlerService;
import com.example.bilforhandler.Service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BilforhandlerController {

    private final BilforhandlerService bilforhandlerService;
    private final EmployeeService employeeService;

    public BilforhandlerController(BilforhandlerService bilforhandlerService, EmployeeService employeeService) {
        this.bilforhandlerService = bilforhandlerService;
        this.employeeService = employeeService;
    }

    @GetMapping("/users")
    public String users(Model model, HttpSession session) {

        if(session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

    List <Employees> getAllEmployees = employeeService.findAll();
//    List <Employees> getEmployeesByTitle = employeeService.findEmployeeByTitel();
    model.addAttribute("employees", getAllEmployees);
    model.addAttribute("employeetype", EmployeeType.values());
//    model.addAttribute("employeesTitle", getEmployeesByTitle);

    return "users";

    }

    @GetMapping("/login")
    public String loginPage(Model model, HttpSession session) {
        Employees checkEmployees = new Employees();
        model.addAttribute("checkEmployees", checkEmployees);
        return "login";
    }

    @PostMapping("/login")
    public String acceptLogin(@ModelAttribute ("employee") Employees employees, HttpSession session) {
        Employees validCheck = employeeService.checkCredentials(employees);

        if(validCheck != null) {
            session.setAttribute("employeeTitle", validCheck.isAdmin());
            session.setAttribute("loggedUser", validCheck.getUsername());
            return "redirect:/homepage";
        }
        return "redirect:/login";
    }


    @GetMapping("/addusers")
    public String addUsers(Model model) {
        Employees addEmployee = new Employees();
        model.addAttribute("addEmployee", addEmployee);
        model.addAttribute("employeetype", EmployeeType.values());
        return "addEmployee";
    }

    @PostMapping("/addusers")
    public String saveUsers(@ModelAttribute Employees em1) {
        employeeService.saveEmployee(em1);
        return "redirect:/homepage";
    }

    @GetMapping("/homepage")
    public String homePage (HttpSession session) {
        session.getAttribute("loggedUser");
        return "homepage";
    }

    @GetMapping("/cars")
    public String seeAllCars(Model model) {
        List<Cars> getAllCars = bilforhandlerService.getAllCars();
        model.addAttribute("seeAllCars", getAllCars);
        return "cars";
    }

    @GetMapping("/addcar")
    public String addCar(Model model) {
        Cars addCars = new Cars();
        model.addAttribute("newCars", addCars);
        return "addCar";
    }

    @PostMapping("/addcar")
    public String saveCar(@ModelAttribute Cars cars) {
        bilforhandlerService.addCar(cars);
        return "redirect:/homepage";
    }

    @GetMapping("/logout")
    public String logOut(HttpSession session) {
        session.invalidate();
        return "redirect:/homepage";
    }

    @GetMapping("/cars/{id}")
    public String seeCars(@PathVariable Long id, Cars cars, Model model) {
        Cars findCarsById = bilforhandlerService.findCarByID(cars, id);
        model.addAttribute("cars", findCarsById);
        return "carsById";
    }

}
