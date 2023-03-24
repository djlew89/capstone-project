package com.capstoneproject;

import java.time.LocalDate;

/**
 * @Author Mason Seward
 * @Date 2023-03-01
 * Testing class for Home-related insurance calculations
 */
public class HomeTest
{
    /**
     * A Customer class with params firstName,lastName,dob
     */
    static Customer customer = new Customer("Jon", "Doe", LocalDate.of(1992, 1, 1));
    /**
     * A Home class with param yearBuilt, value, HeatingType, Location
     */
    static Home[] homes =
            {
                new Home(2013, 220000, Home.HeatingType.ELECTRIC, Home.Location.URBAN),
                new Home(1995, 300000, Home.HeatingType.OIL, Home.Location.RURAL),
                new Home(2003, 260000, Home.HeatingType.GAS, Home.Location.RURAL)
            };
    /**
     * Start date of a five year period
     */
    static LocalDate policy_start = LocalDate.of(2023, 1, 30);
    /**
     * End date of a five year period
     */
    static LocalDate policy_end = LocalDate.of(2028, 1, 30);

    /**
     * Method to output results of a home quote on an insurance policy.
     */
    public static void homeQuoteTest()
    {
        for (Home home : homes)
        {
            HomeQuote hquote = new HomeQuote(
                    policy_start,
                    policy_end,
                    home);
            System.out.printf(
                    "\nCustomer: %s %s\nAge of home: %d\nHeating type: %s\nLocation: %s\nHome Insurance Quote: %.2f\n", customer.getFirstName(), customer.getLastName(), home.calculateAge(), home.getHeatingType(), home.getLocation(), hquote.calculateHomeQuote()
            );
        }
    }

    /**
     * Method to output results (tax included) of a home policy.
     */
    public static void homePolicyTest()
    {
        for (Home home : homes)
        {
            HomePolicy hpolicy = new HomePolicy(
                    customer,
                    policy_start,
                    policy_end,
                    home
            );
            System.out.printf("\nHome Policy Total: %.2f\n", hpolicy.calculatePremium());
        }
    }

    public static void main(String[] args)
    {
        homeQuoteTest();
        homePolicyTest();
    }
}
