package com.example.bilforhandler.Controller;


import com.example.bilforhandler.Model.EmployeeType;
import com.example.bilforhandler.Model.Employees;
import com.example.bilforhandler.Service.BilforhandlerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BilforhandlerController {

    private final BilforhandlerService bilforhandlerService;

    public BilforhandlerController(BilforhandlerService bilforhandlerService) {
        this.bilforhandlerService = bilforhandlerService;
    }

    @GetMapping("/users")
    public String users(Model model){
    List <Employees> getAllEmployees = bilforhandlerService.getAllEmployees();
    model.addAttribute("employees", getAllEmployees);
    model.addAttribute("employeetype", EmployeeType.values());
    return "users";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        Employees checkEmployees = new Employees();
        model.addAttribute("checkEmployees", checkEmployees);
        return "login";
    }

    @PostMapping("/login")
    public String acceptLogin(@ModelAttribute ("employee") Employees employees, Model model) {
        return "redirect:/users";
    }

    @GetMapping("/test")
    public ResponseEntity<List<Employees>> test() {
        List<Employees> test = bilforhandlerService.getAllEmployees();
        return new ResponseEntity<>(test, HttpStatus.OK);
    }


}
