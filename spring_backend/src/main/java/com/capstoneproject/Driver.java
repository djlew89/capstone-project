package com.capstoneproject;

import jakarta.persistence.*;

/**
 * @Author Dan Lewis, Julia Parewick
 * @Date 2023-02-16
 * Descriptive class for a Driver object
 */
@Entity(name = "driver")
public class Driver
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * Number of Accidents Driver has been involved in
     */
    private int numberOfAccidents;
    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "ID")
    private Customer customer;

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    /**
     * getter
     *
     * @return Integer
     */
    public int getNumberAccidents()
    {
        return numberOfAccidents;
    }

    /**
     * setter
     *
     * @param numberAccidents number of accidents by driver
     */
    public void setNumberAccidents(int numberAccidents)
    {
        numberOfAccidents = numberAccidents;
    }
}
