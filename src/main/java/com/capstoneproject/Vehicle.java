package com.capstoneproject;

/**
 * @Author Adam Elliott
 * @Date 2023-02-22
 * Descriptive class for a Vehicle object
 */
public class Vehicle
{
    /**
     * The make of the vehicle
     */
    private final String make;

    /**
     * The model of the vehicle
     */
    private final String model;

    /**
     * The year the vehicle was made
     */
    private final int year;

    /**
     * Constructor for Vehicle class
     *
     * @param make  The make of the vehicle
     * @param model The model of the vehicle
     * @param year  The year the vehicle was made
     */
    public Vehicle(String make, String model, int year)
    {
        this.make = make;
        this.model = model;
        this.year = year;
    }

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
}
