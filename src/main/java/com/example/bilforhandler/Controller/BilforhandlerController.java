package com.example.bilforhandler.Controller;


import com.example.bilforhandler.Model.EmployeeType;
import com.example.bilforhandler.Model.Employees;
import com.example.bilforhandler.Service.BilforhandlerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BilforhandlerController {

    private final BilforhandlerService bilforhandlerService;

    public BilforhandlerController(BilforhandlerService bilforhandlerService) {
        this.bilforhandlerService = bilforhandlerService;
    }

    @GetMapping("/users")
    public String users(Model model, HttpSession session) {

        if(session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

    List <Employees> getAllEmployees = bilforhandlerService.getAllEmployees();
    List <Employees> getEmployeesByTitle = bilforhandlerService.getEmployeeByTitel();
    model.addAttribute("employees", getAllEmployees);
    model.addAttribute("employeetype", EmployeeType.values());
    model.addAttribute("employeesTitle", getEmployeesByTitle);

    return "users";
    }

    @GetMapping("/login")
    public String loginPage(Model model, HttpSession session) {
        Employees checkEmployees = new Employees();
        model.addAttribute("checkEmployees", checkEmployees);
        return "login";
    }

    @PostMapping("/login")
    public String acceptLogin(@ModelAttribute ("employee") Employees employees, Model model, HttpSession session) {
        Employees validCheck = bilforhandlerService.checkCredentials(employees);

        if(validCheck != null) {
            session.setAttribute("employeeTitle", validCheck.isAdmin());
            session.setAttribute("loggedUser", validCheck.getUsername());
            return "redirect:/users";
        }
        return "redirect:/login";
    }

    @GetMapping("/test")
    public ResponseEntity<List<Employees>> test() {
        List<Employees> test = bilforhandlerService.getAllEmployees();
        return new ResponseEntity<>(test, HttpStatus.OK);
    }

    @GetMapping("/home")
    public String homePage (Model model) {
        return "homepage";
    }


}
