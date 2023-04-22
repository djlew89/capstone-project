package com.capstoneproject;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    /**
     * Age of dwelling
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateBuilt;
    /**
     * int representing the type of heating in a dwelling.
     */
    @Enumerated(EnumType.ORDINAL)
    private Home.HeatingType heatingType;
    /**
     * Location of the dwelling
     */
    @Enumerated(EnumType.ORDINAL)
    private Home.Location location;
    /**
     * The monetary value of dwelling
     */
    private double value;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "ID")
    private User user;

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public HeatingType getHeatingType()
    {
        return this.heatingType;
    }

    public void setHeatingType(HeatingType heatingType)
    {
        this.heatingType = heatingType;
    }

    public Location getLocation()
    {
        return this.location;
    }

    public void setLocation(Location location)
    {
        this.location = location;
    }

    public double getValue()
    {
        return value;
    }

    public void setValue(double value)
    {
        this.value = value;
    }

    public int getAge()
    {
        return LocalDate.now()
                .getYear() - this.dateBuilt.getYear();
//        .getYear() - this.dateBuilt.getYear();
    }

    public boolean isUrban()
    {
        return location == Location.URBAN;
    }

    public void setDateBuilt(LocalDate dateBuilt)
    {
        this.dateBuilt = dateBuilt;
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
        OTHER
    }

    /**
     * Location categories
     */
    public enum Location
    {
        URBAN,
        RURAL
    }

}
