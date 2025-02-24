package com.example.bilforhandler.Model;

public enum EmployeeType {

    IT("IT"),
    SALES("SALES"),
    CEO("CEO");

    private String displayTitle;

    EmployeeType(String displayTitle) {
        this.displayTitle = displayTitle;
    }


    public String getDisplayTitle() {
        return displayTitle;
    }
}
