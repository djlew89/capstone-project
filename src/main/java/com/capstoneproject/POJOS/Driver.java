package com.capstoneproject.POJOS;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

/**
 * @Author Dan Lewis, Julia Parewick
 * @Date 2023-02-16
 * Descriptive class for a Driver object
 */
@Entity(name="driver")
public class Driver
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /**
     * First name of Driver
     */
    private String firstName;

    /**
     * Last name of Driver
     */
    private String lastName;

    /**
     * Age of Driver
     */
    private LocalDate dob;
    /**
     * Number of Accidents Driver has been involved in
     */
    private int numberOfAccidents;
    /**
     * Driver's Home Address
     */
    private String address;

    /**
     * getter
     *
     * @return String
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * setter
     *
     * @param firstName a drivers first name.
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * getter
     *
     * @return String
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * setter
     *
     * @param lastName a drivers last name.
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * getter
     *
     * @return Integer
     */
    public int calculateAge()
    {
        return LocalDate.now().getYear()-this.dob.getYear();
    }

    /**
     * setter
     *
     * @param dob drivers date of birth
     */
    public void setdob(LocalDate dob)
    {
        this.dob = dob;
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

    /**
     * getter
     *
     * @return String
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * setter
     *
     * @param address drivers address
     */
    public void setAddress(String address)
    {
        this.address = address;
    }
}
