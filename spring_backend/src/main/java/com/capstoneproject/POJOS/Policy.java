package com.capstoneproject.POJOS;

import com.capstoneproject.Customer;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @Author Julia Parewick
 * @Date 2023-02-22
 * Abstract class for a customer's insurance policy
 */
@MappedSuperclass
public abstract class Policy
{
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "ID")
    private Customer customer;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal totalBeforetax;

    /**
     * constructor
     *
     * @param customer  The policy's customer.
     * @param startDate The policy start date.
     * @param endDate   The policy end date.
     */

    public Policy(LocalDate startDate, LocalDate endDate, BigDecimal totalBeforeTax, Customer customer)
    {
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalBeforetax = totalBeforeTax;
        this.customer = customer;
    }

    public Policy()
    {

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

    public BigDecimal getTotalBeforetax()
    {
        return totalBeforetax;
    }

    public void setTotalBeforetax(BigDecimal totalBeforetax)
    {
        this.totalBeforetax = totalBeforetax;
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

    public BigDecimal calculateTax()
    {
        return this.totalBeforetax.multiply(BigDecimal.valueOf(0.15));
    }
}
