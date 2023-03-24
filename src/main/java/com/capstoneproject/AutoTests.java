package com.capstoneproject;

import java.time.LocalDate;

/**
 * The test class for the auto classes
 *
 * @author Mason Seward
 */
public class AutoTests
{
    /**
     * Start date of insurance policy
     */
    private static final LocalDate startDate = LocalDate.of(2022, 1, 30);
    /**
     * End date of insurance policy
     */
    private static final LocalDate endDate = LocalDate.of(2023, 1, 30);
    /**
     * Vehicle object with params make,model,year
     */
    private static final Vehicle civ = new Vehicle("Honda", "Civic", 2014);
    /**
     * Customer object with params firstName,lastName,dob
     */
    private static final Customer customer = new Customer("Luna", "The Cat", LocalDate.of(2022, 7, 5));
    /**
     * Driver object with params firstName,lastName,driverAge,numberOfAccidents,address
     */
    private static final Driver[] drivers = {new Driver("Mason", "Seward", 20, 1, "#3 Ridge Rd"), new Driver("Mason", "Seward", 20, 4, "#3 Ridge Rd")};


    /**
     * Method to output results of an auto quote on an insurance policy.
     */
    private static void autoQuoteTest()
    {
        System.out.println("QUOTE TEST");
        for (Driver driver : drivers)
        {
            AutoQuote aq = new AutoQuote(startDate, endDate, driver, civ);
            System.out.printf("""
                            Driver: %s
                            Number of Accidents: %d
                            Car Model: %s
                            Estimated start date: %s
                            Estimated end date: %s
                            Policy quote: $%.2f
                                                    
                            """,
                    driver.getFirstName(), driver.getNumberAccidents(), civ.getModel(), startDate, endDate, aq.calculateAutoQuote());
        }
    }

    /**
     * Method to output results (tax included) of a auto policy.
     */
    private static void autoPolicyTest()
    {
        System.out.println("POLICY TEST");
        for (Driver driver : drivers)
        {
            AutoPolicy ap = new AutoPolicy(
                    customer,
                    startDate,
                    endDate,
                    driver,
                    civ);
            double policyQuote = ap.calculatePremium();
            System.out.printf("""
                            Customer: %s
                            Starting on: %s
                            Ending on: %s
                            Primary Driver: %s %s
                            Car Information: %s %s %s
                            Number of Accidents: %d
                            Policy cost: $%.2f
                                                    
                            """,
                    customer.getFirstName(),
                    startDate,
                    endDate,
                    driver.getFirstName(),
                    driver.getLastName(),
                    civ.getYear(),
                    civ.getMake(),
                    civ.getModel(),
                    driver.getNumberAccidents(),
                    policyQuote);
        }

    }

    public static void main(String[] args)
    {
        autoQuoteTest();
        autoPolicyTest();
    }
}
