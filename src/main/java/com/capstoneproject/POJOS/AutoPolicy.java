package com.capstoneproject.POJOS;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @Author Daniel Condon
 * @Date 2023-02-22
 * Descriptive class for customer's auto insurance policy
 */
public class AutoPolicy extends Policy
{
    /**
     * Insured driver
     */
    private final Driver driver;

    /**
     * Insured vehicle
     */
    private final Vehicle vehicle;

    /**
     * Constructor for AutoPolicy class
     *
     * @param customer  The customer who holds the policy
     * @param startDate The start date of the policy
     * @param endDate   The end date of the policy
     * @param driver    The driver insured by the policy
     * @param vehicle   The vehicle insured by the policy
     */
    public AutoPolicy(LocalDate startDate, LocalDate endDate, BigDecimal totalBeforeTax, Customer customer, Driver driver, Vehicle vehicle)
    {
        super(startDate, endDate, totalBeforeTax, customer);
        this.driver = driver;
        this.vehicle = vehicle;
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
     * Getter for insuredVehicle
     *
     * @return The vehicle insured by the policy
     */
    public Vehicle getVehicle()
    {
        return vehicle;
    }
}
