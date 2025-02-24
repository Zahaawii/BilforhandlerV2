package com.example.bilforhandler.Model;

public class Employees {

    private String username;
    private String password;
    private EmployeeType employeeType;
    private boolean isAdmin;

    public Employees(String username, String password, boolean isAdmin, EmployeeType employeeType) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.employeeType = employeeType;
    }

    public Employees() {

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

}
