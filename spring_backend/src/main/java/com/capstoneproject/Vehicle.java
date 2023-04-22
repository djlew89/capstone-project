package com.capstoneproject;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * @Author Adam Elliott, Julia Parewick
 * @Date 2023-04-08
 * Descriptive class for a Vehicle object
 */
@Entity(name = "vehicle")
public class Vehicle
{
    public Integer getId() {
        return id;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "ID")
    private User user;


    /**
     * Getter for make
     *
     * @return The make of the vehicle
     */
    public String getMake()
    {
        return make;
    }

    public void setMake(String make)
    {
        this.make = make;
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

    public void setModel(String model)
    {
        this.model = model;
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

    public void setYear(int year)
    {
        this.year = year;
    }

    /**
     * @return
     */
    public int calculateAge()
    {
        return LocalDate.now()
                .getYear() - year;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }
}
