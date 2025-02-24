package com.example.bilforhandler.Model;

public class Cars {

    private String brand;
    private String model;
    private boolean isUsed;
    private double miles;

    public Cars (String brand, String mode, boolean isUsed, double miles) {
        this.brand = brand;
        this.model = model;
        this.isUsed = isUsed;
        this.miles = miles;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public double getMiles() {
        return miles;
    }

    public void setMiles(double miles) {
        this.miles = miles;
    }




}
