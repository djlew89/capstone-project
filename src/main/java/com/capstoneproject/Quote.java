package com.capstoneproject;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The Quote class stores information on a quote.
 *
 * @author Mason Seward
 * @Date 2023-02-24
 */
@Entity(name = "quote")
public abstract class Quote
{
    @JsonFormat(pattern = "yyyy-MM-dd")
    protected LocalDate startDate;
    @JsonFormat(pattern = "yyy-MM-dd")
    protected LocalDate endDate;
    protected BigDecimal totalBeforeTax;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * Instantiates a new Quote.
     *
     * @param startDate the start date
     * @param endDate   the end date
     */
    public Quote(LocalDate startDate, LocalDate endDate, BigDecimal totalBeforeTax)
    {
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalBeforeTax = totalBeforeTax;
    }

    /**
     * No args constructor. Please use arg constructor. Deprication tag for warning
     */
    @Deprecated()
    protected Quote()
    {
    }

    /**
     * Gets quote start date.
     *
     * @return the start date
     */
    public LocalDate getStartDate()
    {
        return startDate;
    }

    /**
     * Sets quote start date.
     *
     * @param startDate the start date
     */
    public void setStartDate(LocalDate startDate)
    {
        this.startDate = startDate;
    }

    /**
     * Gets quote end date.
     *
     * @return the end date
     */
    public LocalDate getEndDate()
    {
        return endDate;
    }

    /**
     * Sets quote end date.
     *
     * @param endDate the end date
     */
    public void setEndDate(LocalDate endDate)
    {
        this.endDate = endDate;
    }

    public BigDecimal totalBeforeTax()
    {
        return this.totalBeforeTax;
    }

    public BigDecimal calculateTax()
    {
        return this.totalBeforeTax.multiply(BigDecimal.valueOf(0.15));
    }

}
