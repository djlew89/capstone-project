package com.capstoneproject.POJOS.testers;

import com.capstoneproject.Home;
import com.capstoneproject.HomePolicy;
import com.capstoneproject.POJOS.HomeQuote;
import com.capstoneproject.POJOS.PolicyBuilder;
import com.capstoneproject.POJOS.QuoteBuilder;
import com.capstoneproject.User;

import java.time.LocalDate;
import java.util.Random;

/**
 * Testing home class
 */
public class HomeTestApplication
{

    public static void main(String[] args)
    {
        Home home = getTestHome();
        printHomeInfo(home);
        System.out.println("\n\nHomeQuote testing");

        HomeQuote homeQuote = QuoteBuilder.getNewHomeQuote(home);
        System.out.printf("\nHome Premium: %.2f\nTotal Before Tax: %.2f\nTax: %.2f",
                homeQuote.premiumBeforeTax(),
                homeQuote.totalBeforeTax(),
                homeQuote.calculateTax());
        System.out.println("\n\nHomePolicy testing");
        User user = getTestUser();
        HomePolicy policy = PolicyBuilder.getNewHomePolicy(LocalDate.now(), LocalDate.now()
                .plusDays(360), home, user);
        System.out.printf("\nHome Premium: %.2f\nTotal Before Tax: %.2f\nTax: %.2f\nFinal Total: %.2f",
                policy.premiumBeforeTax(),
                policy.getTotalBeforetax(),
                policy.calculateTax(),
                policy.getTotalBeforetax()
                        .add(policy.calculateTax()));
    }

    public static User getTestUser()
    {
        //TODO Randomize this? Add in edge cases
        return new User();
    }



    public static Home getTestHome()
    {
        //TODO Randomize this? Add in edge cases
        Random random = new Random();
        int i = Math.abs(random.nextInt());
        //        System.out.printf("\n>%d", i % 3);
        if (i % 3 == 0)
        {
            Home home = new Home();
//            home.setDateBuilt(LocalDate.of(2005, 1, 1));
            home.setDateBuilt(LocalDate.of(2005,1,2));
            home.setValue(240000);
            home.setHeatingType(Home.HeatingType.OIL);
            home.setLocation(Home.Location.RURAL);
            return home;
        }
        else if (i % 3 == 1)
        {
            Home home = new Home();
            home.setDateBuilt(LocalDate.of(1905,4,10));
            home.setValue(600000);
            home.setHeatingType(Home.HeatingType.WOOD);
            home.setLocation(Home.Location.URBAN);
            return home;
        }
        else
        {
            Home home = new Home();
//            home.setDateBuilt(LocalDate.of(1985, 1, 1));
            home.setDateBuilt(LocalDate.of(1985,3,4));
            home.setValue(400000);
            home.setHeatingType(Home.HeatingType.OTHER);
            home.setLocation(Home.Location.URBAN);
            return home;
        }
    }

    public static void printHomeInfo(Home home)
    {
        System.out.printf("\nHome details> Value: %.2f, Heating: %s, Location: %s, Age: %d",
                home.getValue(),
                home.getHeatingType()
                        .name(),
                home.getLocation()
                        .name(),
                home.getAge()
        );
    }

}
