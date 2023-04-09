package com.capstoneproject.POJOS.testers;

import com.capstoneproject.POJOS.*;

import java.time.LocalDate;
import java.util.Random;

public class AutoTestApplication {
    public static void main(String[] args) {
        Vehicle car = getTestVehicle();
        Driver driver =getTestDriver();
        printAutoInfo(car,driver);
        System.out.println("\n\nAutoQuote testing");

        AutoQuote autoQuote = QuoteBuilder.getNewAutoQuote(car,driver);
        System.out.printf("\nTotal Before Tax: %.2f\nTax: %.2f",
                autoQuote.totalBeforeTax(),
                autoQuote.calculateTax());
        System.out.println("\n\nAutoPolicy testing");
        Customer customer = getTestCustomer();
        AutoPolicy policy = PolicyBuilder.getNewAutoPolicy(LocalDate.now(), LocalDate.now().plusDays(365), car, driver, customer);
        System.out.printf("\nTotal Before Tax: %.2f\nTax: %.2f\nFinal Total: %.2f",
                policy.totalBeforeTax(),
                policy.calculateTax(),
                policy.totalBeforeTax().add(policy.calculateTax()));
    }

    public static Customer getTestCustomer(){
        //TODO Randomize this? Add in edge cases
        return new Customer("Josh", "Taylor", LocalDate.of(1990,10,1));
    }
    public static Vehicle getTestVehicle(){
        Random random = new Random();
        int i = Math.abs(random.nextInt());
        if(i % 3 == 0){
            Vehicle car = new Vehicle();
            car.setMake("Toyota");
            car.setModel("Prius");
            car.setYear(2009);
            return car;
        } else if(i % 3 == 1){
            Vehicle car = new Vehicle();
            car.setMake("Toyota");
            car.setModel("Prius");
            car.setYear(2020);
            return car;
        } else {
            Vehicle car = new Vehicle();
            car.setMake("Toyota");
            car.setModel("Prius");
            car.setYear(2016);
            return car;
        }
    }

    public static Driver getTestDriver(){
        Random random = new Random();
        int i = Math.abs(random.nextInt());
        if(i % 3 == 0){
            Driver driver = new Driver();
            driver.setAddress("22 Test Ave, SJ, NL");
            driver.setdob(LocalDate.of(1990,3,20));
            driver.setFirstName("Jake");
            driver.setLastName("Test");
            driver.setNumberAccidents(1);
            return driver;
        } else if(i % 3 == 1){
            Driver driver = new Driver();
            driver.setAddress("22 Test Ave, SJ, NL");
            driver.setdob(LocalDate.of(1999,3,20));
            driver.setFirstName("Jake");
            driver.setLastName("Test");
            driver.setNumberAccidents(3);
            return driver;
        } else {
            Driver driver = new Driver();
            driver.setAddress("22 Test Ave, SJ, NL");
            driver.setdob(LocalDate.of(1960,3,20));
            driver.setFirstName("Jake");
            driver.setLastName("Test");
            driver.setNumberAccidents(0);
            return driver;
        }
    }
    public static void printAutoInfo(Vehicle car, Driver driver){
        System.out.printf("\nVehicle details> Make: %s, Model: %s, Year: %d\nDriver details> Name: %s %s, Address: %s, Age: %d, Past Accidents: %d",
                car.getMake(),
                car.getModel(),
                car.getYear(),
                driver.getFirstName(),
                driver.getLastName(),
                driver.getAddress(),
                driver.calculateAge(),
                driver.getNumberAccidents()
        );
    }
}
