package com.capstoneproject;

import com.capstoneproject.POJOS.Policy;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @Author Julia Parewick
 * @Date 2023-02-24
 * Abstract class for a customer's insurance policy
 */
@Entity(name = "home_policy")
public class HomePolicy extends Policy
{

    /**
     * a Home object representing the subject of the Policy
     */
    @OneToOne
    @JoinColumn(name = "home_id", referencedColumnName = "ID")
    protected Home home;
    protected BigDecimal premiumBeforeTax;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


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

    public HomePolicy()
    {
        super();
    }

    public void setPremiumBeforeTax(BigDecimal premiumBeforeTax)
    {
        this.premiumBeforeTax = premiumBeforeTax;
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

    public void setHome(Home home)
    {
        this.home = home;
    }

    public BigDecimal premiumBeforeTax()
    {
        return this.premiumBeforeTax;
    }

}
