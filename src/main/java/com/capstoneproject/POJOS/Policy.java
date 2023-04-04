package com.capstoneproject.POJOS;

import java.time.LocalDate;

/**
 * @Author Julia Parewick
 * @Date 2023-02-22
 * Abstract class for a customer's insurance policy
 */
public abstract class Policy
{
    /**
     * start date of policy
     */
    protected LocalDate startDate;
    /**
     * end date of policy
     */
    protected LocalDate endDate;
    /**
     * Policy holder
     */
    private Customer customer;

    /**
     * constructor
     *
     * @param customer  The policy's customer.
     * @param startDate The policy start date.
     * @param endDate   The policy end date.
     */
    public Policy(Customer customer, LocalDate startDate, LocalDate endDate)
    {
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    public LocalDate getStartDate()
    {
        return startDate;
    }

    public void setStartDate(LocalDate startDate)
    {
        this.startDate = startDate;
    }

    public LocalDate getEndDate()
    {
        return endDate;
    }

    public void setEndDate(LocalDate endDate)
    {
        this.endDate = endDate;
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
