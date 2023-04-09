package com.capstoneproject;

import com.capstoneproject.User;
import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * @Author Adam Elliott, Julia Parewick
 * @Date 2023-04-08
 * Descriptive class for a Vehicle object
 */
@Entity(name="vehicle")
public class Vehicle
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    /**
     * The make of the vehicle
     */
    private String make;

    /**
     * The model of the vehicle
     */
    private String model;

    /**
     * The year the vehicle was made
     */
    private int year;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "ID")
    private User user;

    @ManyToOne
    @JoinColumn(name="customer_id", referencedColumnName = "ID")
    private Customer customer;

    /**
     * Getter for make
     *
     * @return The make of the vehicle
     */
    public String getMake()
    {
        return make;
    }

    /**
     * Getter for model
     *
     * @return The model of the vehicle
     */
    public String getModel()
    {
        return model;
    }

    /**
     * Getter for year
     *
     * @return The year the vehicle was made
     */
    public int getYear()
    {
        return year;
    }

    /**
     *
     * @return
     */
    public int calculateAge(){
        return LocalDate.now().getYear()-year;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
