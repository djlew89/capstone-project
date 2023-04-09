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
    public double getHomeLocationFactor(Home.Location location) {
        switch(location) {
            case URBAN, RURAL -> {
                return 1.0;
            }
        }
        return 1.0;
    }

    @Override
    public double getHomeAgeFactor(int yearsOld) {
        if(yearsOld > 50){
            return 1.5;
        } else if (yearsOld > 25){
            return 1.25;
        } else {
            return 1.0;
        }
    }

    @Override
    public double getHomeValueFactor(double value) {
        if(value > 250000){
            return value*0.02;
        }else{
            return 0;
        }
    }

    @Override
    public double getAutoBasePremium(){ return 750.0;}

    @Override
    public double getDriverAgeFactor(int age) {
        if(age<25){
            return 2.0;
        }else{
            return 1.0;
        }
    }

    @Override
    public double getDriverAccidentsFactor(int accidents) {
        if(accidents>=2){
            return 2.5;
        }else if(accidents==1){
            return 1.25;
        }else{
            return 1.0;
        }
    }

    @Override
    public double getVehicleAgeFactor(int age) {
        if (age < 5) {
            return 1.0;
        } else if (age >= 5 && age < 10) {
            return 1.5;
        } else {
            return 2.5;
        }
    }
}
