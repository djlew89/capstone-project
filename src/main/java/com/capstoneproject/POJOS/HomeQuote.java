package com.capstoneproject.POJOS;

import com.capstoneproject.Home;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The HomeQuote class contains data about home quotes.
 *
 * @author Mason Seward, Julia Parewick
 * @Date 2023-02-24
 */
public class HomeQuote extends Quote
{
    protected static Home home;

    protected static BigDecimal premiumBeforeTax;

    /**
     * Instantiates a new HomeQuote
     *
     * @param startDate    the start date
     * @param endDate      the end date
     * @param selectedHome the home
     */
    public HomeQuote(LocalDate startDate, LocalDate endDate, BigDecimal totalBeforeTax, BigDecimal premiumBeforeTax, Home selectedHome)
    {
        super(startDate,endDate,totalBeforeTax);
        this.premiumBeforeTax = premiumBeforeTax;
        this.home = selectedHome;
    }

    /**
     * gets home
     * @return home
     */
    public static Home getHome()
    {
        return home;
    }

    /**
     * sets home
     * @param newHome the new home
     */
    public void setHome(Home newHome)
    {
        home = newHome;
    }

    public BigDecimal premiumBeforeTax() {
        return this.premiumBeforeTax;
    }
}
