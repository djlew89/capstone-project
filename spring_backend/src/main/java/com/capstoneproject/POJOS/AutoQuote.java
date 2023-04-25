package com.capstoneproject.POJOS;

import com.capstoneproject.Driver;
import com.capstoneproject.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The AutoQuote class contains data about auto quotes.
 *
 * @author Daniel Condon
 * @Date 2023-02-24
 */

public class AutoQuote extends Quote
{
    private static Vehicle vehicle;
    private static Driver driver;

    /**
     * Instantiates a new AutoQuote
     *
     * @param startDate       the start date
     * @param endDate         the end date
     * @param selectedDriver  the driver
     * @param selectedVehicle the vehicle
     */
    public AutoQuote(LocalDate startDate, LocalDate endDate, BigDecimal totalBeforeTax, Driver selectedDriver, Vehicle selectedVehicle)
    {
        super(startDate, endDate, totalBeforeTax);
        vehicle = selectedVehicle;
        driver = selectedDriver;
    }

    /**
     * gets vehicle
     *
     * @return vehicle
     */
    public static Vehicle getVehicle()
    {
        return vehicle;
    }

    /**
     * sets vehicle
     *
     * @param vehicle - the vehicle
     */
    public void setVehicle(Vehicle vehicle)
    {
        AutoQuote.vehicle = vehicle;
    }

    /**
     * Getter for insuredDriver
     *
     * @return The driver insured by the policy
     */
    public Driver getDriver()
    {
        return driver;
    }

    /**
     * sets driver
     *
     * @param driver - the driver
     */
    public void setDriver(Driver driver)
    {
        AutoQuote.driver = driver;
    }
}
