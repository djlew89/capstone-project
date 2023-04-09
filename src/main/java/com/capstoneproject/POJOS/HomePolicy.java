package com.capstoneproject.POJOS;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @Author Julia Parewick
 * @Date 2023-02-24
 * Abstract class for a customer's insurance policy
 */
public class HomePolicy extends Policy
{
    /**
     * a Home object representing the subject of the Policy
     */
    protected Home home;

    protected BigDecimal premiumBeforeTax;

    /**
     * constructor
     *
     * @param customer  The customer.
     * @param startDate The policy start date.
     * @param endDate   The policy end date.
     * @param home      The home.
     */
    public HomePolicy(LocalDate startDate, LocalDate endDate, BigDecimal totalBeforeTax, Customer customer, BigDecimal premiumBeforeTax, Home home)
    {
        super(startDate, endDate, totalBeforeTax, customer);
        this.premiumBeforeTax = premiumBeforeTax;
        this.home = home;
    }

    /**
     * getter
     * @return Home
     */
    public Home getHome()
    {
        return this.home;
    }

    public BigDecimal premiumBeforeTax() {
        return this.premiumBeforeTax;
    }

}
