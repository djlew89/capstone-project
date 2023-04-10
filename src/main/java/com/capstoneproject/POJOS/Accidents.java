package com.capstoneproject.POJOS;

import com.capstoneproject.Driver;

import java.time.LocalDate;

/**
 * @Author Adam Elliott
 * @Date 2023-02-22
 * Descriptive class for an Accidents object
 */
public class Accidents
{
    /**
     * The date of the accident
     */
    private final LocalDate date;

    /**
     * The driver at fault in the accident
     */
    private final Driver driverAtFault;

    /**
     * Constructor for Accidents class
     *
     * @param date          The date of the accident
     * @param driverAtFault The driver at fault in the accident
     */
    public Accidents(LocalDate date, Driver driverAtFault)
    {
        this.date = date;
        this.driverAtFault = driverAtFault;
    }

    /**
     * Getter for date
     *
     * @return The date of the accident
     */
    public LocalDate getDate()
    {
        return date;
    }

    /**
     * Getter for driverAtFault
     *
     * @return The driver at fault in the accident
     */
    public Driver getDriverAtFault()
    {
        return driverAtFault;
    }
}
