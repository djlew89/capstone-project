package com.capstoneproject.POJOS;

import com.capstoneproject.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * @Author Julia Parewick
 * @Date 2023-02-22
 * Descriptive class for a Home object
 */
@Entity(name = "home")
public class Home
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) private Integer id;


    /**
     * Age of dwelling
     */
    @JsonFormat(pattern="yyyy-MM-dd") private final int yearBuilt;
    /**
     * int representing the type of heating in a dwelling.
     */
    @Enumerated(EnumType.ORDINAL) private final HeatingType heatingType;
    /**
     * Location of the dwelling
     */
    @Enumerated(EnumType.ORDINAL) private final Location location;
    /**
     * The monetary value of dwelling
     */
    private final int value;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Constructor
     *
     * @param yearBuilt   The year the house was built.
     * @param value       The value.
     * @param heatingType The type of heat used.
     * @param location    The location
     */
    public Home(int yearBuilt, int value, HeatingType heatingType, Location location)
    {
        this.yearBuilt = yearBuilt;
        this.value = value;
        this.heatingType = heatingType;
        this.location = location;
        user = null;
    }

    public HeatingType getHeatingType()
    {
        return heatingType;
    }

    public Location getLocation()
    {
        return location;
    }

    public int getValue()
    {
        return value;
    }

    public int getAge()
    {
        return LocalDate.now()

                .getYear() - this.yearBuilt;
    }

    public boolean isUrban()
    {
        return location == Location.URBAN;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Types of heating in a home
     */
    public enum HeatingType
    {
        ELECTRIC, OIL, WOOD, GAS, OTHER
    }

    /**
     * Location categories
     */
    public enum Location
    {
        URBAN, RURAL
    }

}
