package com.capstoneproject.POJOS;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @Author Julia Parewick
 * @Date 2023-02-22
 * Abstract class for a customer's insurance policy
 */
public abstract class Policy extends Quote
{
    private Customer customer;

    /**
     * constructor
     *
     * @param customer  The policy's customer.
     * @param startDate The policy start date.
     * @param endDate   The policy end date.
     */
    public Policy(LocalDate startDate, LocalDate endDate, BigDecimal totalBeforeTax, Customer customer)
    {
        super(startDate, endDate, totalBeforeTax);
        this.customer = customer;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    /**
     * Checks if policy has expired
     *
     * @return a boolean value representing whether the policy is active or not.
     */
    public boolean isActive()
    {
        LocalDate today = LocalDate.now();
        return today.isBefore(endDate);
    }
}
