package com.capstoneproject.POJOS;

import com.capstoneproject.*;

import java.time.LocalDate;

public class PolicyBuilder
{

    public static HomePolicy getNewHomePolicy(LocalDate startDate, LocalDate endDate, Home home, User user)
    {
        HomeQuote quote = QuoteBuilder.getNewHomeQuote(home);
        HomePolicy policy = new HomePolicy();
        policy.setHome(home);
        policy.setPremiumBeforeTax(quote.premiumBeforeTax());
        policy.setTotalBeforetax(quote.totalBeforeTax());
        policy.setUser(user);
        policy.setStartDate(startDate);
        policy.setEndDate(endDate);
        return policy;
    }

    public static AutoPolicy getNewAutoPolicy(LocalDate startDate, LocalDate endDate, Vehicle car, Driver driver, User user)
    {
        AutoQuote quote = QuoteBuilder.getNewAutoQuote(car, driver);
        AutoPolicy policy = new AutoPolicy();
        policy.setDriver(driver);
        policy.setVehicle(car);
        policy.setUser(user);
        policy.setStartDate(startDate);
        policy.setEndDate(endDate);
        policy.setTotalBeforetax(quote.totalBeforeTax());
        return policy;
    }
}
