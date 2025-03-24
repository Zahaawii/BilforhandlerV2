package com.example.bilforhandler.Model;

import jakarta.persistence.*;
import jdk.jfr.BooleanFlag;
import lombok.*;

@Data
@Getter
@Setter

@Entity
@Table(name = "cars")
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "car_brand")
    private String brand;

    @Column(name = "car_model")
    private String model;

    @Column(name = "is_used")
    @BooleanFlag
    private boolean isUsed;

    @Column(name = "car_miles")
    private double miles;

    @Column(name = "car_image")
    private String imgpath;

    @Column(name = "car_description")
    private String description;

}
