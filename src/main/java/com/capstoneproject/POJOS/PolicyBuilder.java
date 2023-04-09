package com.capstoneproject.POJOS;

import java.time.LocalDate;

public class PolicyBuilder {

    public static HomePolicy getNewHomePolicy(LocalDate startDate, LocalDate endDate, Home home, Customer customer){
        HomeQuote quote = QuoteBuilder.getNewHomeQuote(home);
        return new HomePolicy(startDate,endDate,quote.totalBeforeTax(),customer,quote.premiumBeforeTax(),home);
    }

    public static AutoPolicy getNewAutoPolicy(LocalDate startDate, LocalDate endDate, Vehicle car, Driver driver, Customer customer){
        AutoQuote quote = QuoteBuilder.getNewAutoQuote(car,driver);
        return new AutoPolicy(startDate,endDate,quote.totalBeforeTax(),customer,driver,car);
    }
}
