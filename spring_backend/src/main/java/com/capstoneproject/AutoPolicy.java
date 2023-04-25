package com.capstoneproject;

import com.capstoneproject.POJOS.Policy;
import jakarta.persistence.*;

/**
 * @Author Daniel Condon
 * @Date 2023-02-22
 * Descriptive class for customer's auto insurance policy
 */
@Entity(name = "auto_policy")
public class AutoPolicy extends Policy
{
    public Integer getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * Insured driver
     */
    @ManyToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "ID")
    private Driver driver;

    /**
     * Insured vehicle
     */
    @ManyToOne
    @JoinColumn(name = "auto_id", referencedColumnName = "ID")
    private Vehicle vehicle;

    /**
     * Getter for insuredDriver
     *
     * @return The driver insured by the policy
     */
    public Driver getDriver()
    {
        return driver;
    }

    public void setDriver(Driver driver)
    {
        this.driver = driver;
    }

    /**
     * Getter for insuredVehicle
     *
     * @return The vehicle insured by the policy
     */
    public Vehicle getVehicle()
    {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle)
    {
        this.vehicle = vehicle;
    }
}
