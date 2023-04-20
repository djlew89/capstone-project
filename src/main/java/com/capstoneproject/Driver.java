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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "ID")
    private User user;


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
