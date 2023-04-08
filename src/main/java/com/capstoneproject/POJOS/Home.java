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
    @JsonFormat(pattern="yyyy-MM-dd") private int yearBuilt;
    /**
     * int representing the type of heating in a dwelling.
     */
    @Enumerated(EnumType.ORDINAL) private Home.HeatingType heatingType;
    /**
     * Location of the dwelling
     */
    @Enumerated(EnumType.ORDINAL) private Home.Location location;
    /**
     * The monetary value of dwelling
     */
    private int value;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "ID")
    private User user;

    public HeatingType getHeatingType()
    {
        return this.heatingType;
    }

    public Location getLocation()
    {
        return this.location;
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

    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public void setHeatingType(HeatingType heatingType) {
        this.heatingType = heatingType;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Types of heating in a home
     */
    public enum HeatingType
    {
        ELECTRIC,
        OIL,
        WOOD,
        GAS,
        OTHER;
    }

    /**
     * Location categories
     */
    public enum Location
    {
        URBAN,
        RURAL;
    }

}