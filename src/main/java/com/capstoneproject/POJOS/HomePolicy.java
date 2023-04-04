package com.capstoneproject.POJOS;

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
    private final Home home;

    /**
     * constructor
     *
     * @param customer  The customer.
     * @param startDate The policy start date.
     * @param endDate   The policy end date.
     * @param home      The home.
     */
    public HomePolicy(Customer customer, LocalDate startDate, LocalDate endDate, Home home)
    {
        super(customer, startDate, endDate);
        this.home = home;
    }

    /**
     * getter
     *
     * @return Home
     */
    public Home getHome()
    {
        return this.home;
    }

    /**
     * Calculates the home premium based on factors provided by Home object
     *
     * @return double
     */
    public double calculatePremium()
    {
        HomeQuote quote = new HomeQuote(super.startDate, super.endDate, home);

        return quote.calculateHomeQuote() * 1.15;
    }
}
