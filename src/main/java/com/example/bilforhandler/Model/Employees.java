package com.example.bilforhandler.Model;


import jakarta.persistence.*;
import jdk.jfr.BooleanFlag;
import lombok.Data;

@Data

@Entity
@Table(name="employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "employee_type")
    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;

    @Column(name = "is_Admin")
    private boolean isAdmin;

}
