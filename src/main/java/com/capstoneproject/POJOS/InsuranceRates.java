package com.capstoneproject.POJOS;

import com.capstoneproject.Home;

/**
 * An interface for insurance rates. This allows for rates to be abstracted to web service.
 * This is a single set of rates for both home and auto. This is common industry practice as
 * actuaries tend to package rates together.
 * <p>
 * Note: all premiums are annual
 *
 * @author Julia Parewick
 */
public interface InsuranceRates
{

    /**
     * Get the base annual premium for a HomeQuote
     *
     * @return base premium
     */
    double getHomeBasePremium();

    /**
     * Get the rating factor for heating type
     *
     * @return heating type factor
     */
    double getHeatingTypeFactor(Home.HeatingType heatingType);

    /**
     * Get the rating factor for location
     *
     * @param location home location
     * @return
     */
    double getHomeLocationFactor(Home.Location location);

    /**
     * Get the rating factor based on home age - years since construction
     *
     * @param yearsOld Years since construction
     * @return
     */
    double getHomeAgeFactor(int yearsOld);

    double getHomeValueFactor(double value);

    double getAutoBasePremium();

    double getDriverAgeFactor(int age);

    double getDriverAccidentsFactor(int accidents);

    double getVehicleAgeFactor(int age);

}
