package com.capstoneproject.POJOS.testers;

import com.capstoneproject.*;
import com.capstoneproject.POJOS.AutoQuote;
import com.capstoneproject.POJOS.PolicyBuilder;
import com.capstoneproject.POJOS.QuoteBuilder;

import java.time.LocalDate;
import java.util.Random;

public class AutoTestApplication
{
    public static void main(String[] args)
    {
        Vehicle car = getTestVehicle();
        Driver driver = getTestDriver();
        printAutoInfo(car, driver);
        System.out.println("\n\nAutoQuote testing");

        AutoQuote autoQuote = QuoteBuilder.getNewAutoQuote(car, driver);
        System.out.printf("\nTotal Before Tax: %.2f\nTax: %.2f",
                autoQuote.totalBeforeTax(),
                autoQuote.getTax());
        System.out.println("\n\nAutoPolicy testing");
        User user = getTestUser();
        AutoPolicy policy = PolicyBuilder.getNewAutoPolicy(LocalDate.now(), LocalDate.now()
                .plusDays(365), car, driver, user);
        System.out.printf("\nTotal Before Tax: %.2f\nTax: %.2f\nFinal Total: %.2f",
                policy.getTotalBeforetax(),
                policy.calculateTax(),
                policy.getTotalBeforetax()
                        .add(policy.calculateTax()));
    }


    public static User getTestUser()
    {
        //TODO Randomize this? Add in edge cases
        User customer = new User();
        customer.setEmail("test@gmail.com");
        customer.setFirstName("Julia");
        customer.setLastName("Parewick");
        customer.setDob(LocalDate.of(1992, 4, 4));
        customer.setAddress("1 Test Ave");
        customer.setPassword("admin");

        return customer;
    }

    public static Vehicle getTestVehicle()
    {
        Random random = new Random();
        int i = Math.abs(random.nextInt());
        if (i % 3 == 0)
        {
            Vehicle car = new Vehicle();
            car.setMake("Toyota");
            car.setModel("Prius");
            car.setYear(2009);
            return car;
        }
        else if (i % 3 == 1)
        {
            Vehicle car = new Vehicle();
            car.setMake("Toyota");
            car.setModel("Prius");
            car.setYear(2020);
            return car;
        }
        else
        {
            Vehicle car = new Vehicle();
            car.setMake("Toyota");
            car.setModel("Prius");
            car.setYear(2016);
            return car;
        }
    }

    public static Driver getTestDriver()
    {
        Random random = new Random();
        int i = Math.abs(random.nextInt());
        if (i % 3 == 0)
        {
            Driver driver = new Driver();
            driver.setNumberAccidents(1);
            driver.setUser(getTestUser());
            return driver;
        }
        else if (i % 3 == 1)
        {
            Driver driver = new Driver();
            driver.setUser(getTestUser());
            driver.setNumberAccidents(3);
            return driver;
        }
        else
        {
            Driver driver = new Driver();
            driver.setUser(getTestUser());
            driver.setNumberAccidents(0);
            return driver;
        }
    }

    public static void printAutoInfo(Vehicle car, Driver driver)
    {
        System.out.printf("\nVehicle details> Make: %s, Model: %s, Year: %d\nDriver details> Name: %s %s, Address: %s, Age: %d, Past Accidents: %d",
                car.getMake(),
                car.getModel(),
                car.getYear(),
                driver.getUser()
                        .getFirstName(),
                driver.getUser()
                        .getLastName(),
                driver.getUser()
                        .getAddress(),
                LocalDate.now()
                        .getYear() - driver.getUser()
                        .getDob()
                        .getYear(),
                driver.getNumberAccidents()
        );
    }
}
