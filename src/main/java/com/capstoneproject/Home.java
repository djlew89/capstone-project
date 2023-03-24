package com.capstoneproject;

import java.time.LocalDate;

/**
 * @Author Julia Parewick
 * @Date 2023-02-22
 * Descriptive class for a Home object
 */
public class Home
{
    /**
     * Age of dwelling
     */
    private final int yearBuilt;
    /**
     * int representing the type of heating in a dwelling.
     */
    private final HeatingType heatingType;
    /**
     * Location of the dwelling
     */
    private final Location location;
    /**
     * The monetary value of dwelling
     */
    private final int value;

    /**
     * Constructor
     *
     * @param yearBuilt   The year the house was built.
     * @param value       The value.
     * @param heatingType The type of heat used.
     * @param location    The location
     */
    public Home(int yearBuilt, int value, HeatingType heatingType, Location location)
    {
        this.yearBuilt = yearBuilt;
        this.value = value;
        this.heatingType = heatingType;
        this.location = location;
    }

    public HeatingType getHeatingType()
    {
        return heatingType;
    }

    public Location getLocation()
    {
        return location;
    }

    public int getValue()
    {
        return value;
    }

    public int calculateAge()
    {
        return LocalDate.now()
                .getYear() - this.yearBuilt;
    }

    public boolean isUrban()
    {
        return location == Location.URBAN;
    }

    /**
     * Types of heating in a home
     */
    enum HeatingType
    {
        ELECTRIC, OIL, WOOD, GAS, OTHER
    }

    /**
     * Location categories
     */
    enum Location
    {
        URBAN, RURAL
    }

}
