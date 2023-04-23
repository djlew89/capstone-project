package com.capstoneproject;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The Quote class stores information on a quote.
 *
 * @author Mason Seward
 * @Date 2023-02-24
 */
//@Entity(name = "quote")
public abstract class Quote
{
    //    @JsonFormat(pattern = "yyyy-MM-dd")
    protected LocalDate startDate;
    //    @JsonFormat(pattern = "yyyy-MM-dd")
    protected LocalDate endDate;
    protected BigDecimal tax;
    protected BigDecimal totalBeforeTax;

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
        this.tax = this.calculateTax();

    }
    /**
     * No args constructor. Please use arg constructor. Deprication tag for warning
     */
    //    @Deprecated()
    protected Quote()
    {
    }
    //    @Id
    //    @GeneratedValue(strategy = GenerationType.AUTO)
    //    private Integer id;

    public BigDecimal getTotalBeforeTax()
    {
        return totalBeforeTax;
    }

    public BigDecimal getTax()
    {
        return tax;
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

    private BigDecimal calculateTax()
    {
        return this.totalBeforeTax.multiply(BigDecimal.valueOf(0.15));
    }

}
