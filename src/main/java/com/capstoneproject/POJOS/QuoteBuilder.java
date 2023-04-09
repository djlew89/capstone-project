package com.capstoneproject.POJOS;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Generates quotes
 *
 * @author Josh
 */
public class QuoteBuilder {

    /**
     * Get a new home quote
     * @param home
     * @return
     */
    public static HomeQuote getNewHomeQuote(Home home){
        return new HomeQuote(LocalDate.now(), LocalDate.now().plusDays(365), getHomeQuoteTotal(home),getHomeQuotePremium(home),home);
    }

    /**
     *
     * @param vehicle
     * @param driver
     * @return
     */
    public static AutoQuote getNewAutoQuote(Vehicle vehicle, Driver driver){
        return new AutoQuote(LocalDate.now(), LocalDate.now().plusDays(360),getAutoQuoteTotal(vehicle,driver),driver,vehicle);
    }

    /**
     * Get a home quote premium
     * @param home
     * @return
     */
    private static BigDecimal getHomeQuotePremium(Home home){
        //TODO This should be a factory!
        InsuranceRates insuranceRates = new HardCodedRates();

        BigDecimal bigDecimal = BigDecimal.valueOf(insuranceRates.getHomeBasePremium());
        bigDecimal = bigDecimal.add(BigDecimal.valueOf(insuranceRates.getHomeValueFactor(home.getValue())));
        return bigDecimal;
    }

    /**
     *
     * @param home
     * @return
     */
    private static BigDecimal getHomeQuoteTotal(Home home){
        InsuranceRates insuranceRates = new HardCodedRates();

        BigDecimal bigDecimal = getHomeQuotePremium(home);

        BigDecimal totalFactor = BigDecimal.valueOf(insuranceRates.getHomeAgeFactor(home.getAge()))
                .multiply(BigDecimal.valueOf(insuranceRates.getHeatingTypeFactor(home.getHeatingType())))
                .multiply(BigDecimal.valueOf(insuranceRates.getHomeLocationFactor(home.getLocation())));

        return bigDecimal.multiply(totalFactor);
    }

    /**
     *
     * @param vehicle
     * @param driver
     * @return
     */
    private static BigDecimal getAutoQuoteTotal(Vehicle vehicle, Driver driver){
        InsuranceRates insuranceRates = new HardCodedRates();

        BigDecimal bigDecimal = new BigDecimal(insuranceRates.getAutoBasePremium());
        return bigDecimal
                .multiply(BigDecimal.valueOf(insuranceRates.getDriverAgeFactor(driver.calculateAge())))
                .multiply(BigDecimal.valueOf(insuranceRates.getVehicleAgeFactor(vehicle.calculateAge())))
                .multiply(BigDecimal.valueOf(insuranceRates.getDriverAccidentsFactor(driver.getNumberAccidents())));
    }

}
