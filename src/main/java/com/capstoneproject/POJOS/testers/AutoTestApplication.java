package com.capstoneproject.POJOS.testers;

import com.capstoneproject.*;
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
                policy.getTotalBeforetax(),
                policy.calculateTax(),
                policy.getTotalBeforetax().add(policy.calculateTax()));
    }

    public static User getTestUser(){
        User user = new User();
        user.setName("JuliaParewick");
        user.setEmail("jparewick@gmail.com");
        return user;
    }
    public static Customer getTestCustomer(){
        //TODO Randomize this? Add in edge cases
        Customer customer = new Customer();
        customer.setFirstName("Julia");
        customer.setLastName("Parewick");
        customer.setDob(LocalDate.of(1992,4,4));
        customer.setUser(getTestUser());
        return customer;
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
            driver.setNumberAccidents(1);
            driver.setCustomer(getTestCustomer());
            return driver;
        } else if(i % 3 == 1){
            Driver driver = new Driver();
            driver.setCustomer(getTestCustomer());
            driver.setNumberAccidents(3);
            return driver;
        } else {
            Driver driver = new Driver();
            driver.setCustomer(getTestCustomer());
            driver.setNumberAccidents(0);
            return driver;
        }
    }
    public static void printAutoInfo(Vehicle car, Driver driver){
        System.out.printf("\nVehicle details> Make: %s, Model: %s, Year: %d\nDriver details> Name: %s %s, Address: %s, Age: %d, Past Accidents: %d",
                car.getMake(),
                car.getModel(),
                car.getYear(),
                driver.getCustomer().getFirstName(),
                driver.getCustomer().getLastName(),
                driver.getCustomer().getAddress(),
                LocalDate.now().getYear()-driver.getCustomer().getDob().getYear(),
                driver.getNumberAccidents()
        );
    }
}
