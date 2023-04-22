package com.capstoneproject.POJOS;

import com.capstoneproject.User;
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
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "ID")
    private User user;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal totalBeforetax;

    /**
     * constructor
     *
     * @param user  The policy's customer.
     * @param startDate The policy start date.
     * @param endDate   The policy end date.
     */

    public Policy(LocalDate startDate, LocalDate endDate, BigDecimal totalBeforeTax, User user)
    {
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalBeforetax = totalBeforeTax;
        this.user = user;
    }

    public Policy()
    {

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
