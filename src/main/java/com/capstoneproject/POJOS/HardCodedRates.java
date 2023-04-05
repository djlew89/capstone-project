package com.capstoneproject.POJOS;

/**
 * Testing insurance rates class which will be abstracted by a Web Service
 *
 * @author Josh
 */
public class HardCodedRates implements InsuranceRates {

    @Override
    public double getHomeBasePremium() {
        return 500;
    }

    @Override
    public double getHeatingTypeFactor(Home.HeatingType heatingType) {
        switch(heatingType) {
            case OIL -> {
                return 2.0;
            }
            case WOOD -> {
                return 1.25;
            }
            case OTHER -> {
                return 1.0;
            }
        }
        return 1.0;
    }

    @Override
    public double getLocationFactor(Home.Location location) {
        switch(location) {
            case URBAN, RURAL -> {
                return 1.0;
            }
        }
        return 1.0;
    }

    @Override
    public double getAgeFactor(int yearsOld) {
        if(yearsOld > 50){
            return 1.5;
        } else if (yearsOld > 25){
            return 1.25;
        } else {
            return 1.0;
        }
    }
}
