package com.capstoneproject.POJOS.testers;
import com.capstoneproject.POJOS.*;
import java.time.LocalDate;
import java.util.Random;

/**
 * Testing home class
 */
public class HomeTestApplication {

    public static void main(String[] args) {
        Home home = getTestHome();
        printHomeInfo(home);
        System.out.println("\n\nHomeQuote testing");

        HomeQuote homeQuote = QuoteBuilder.getNewHomeQuote(home);
        System.out.printf("\nHome Premium: %.2f\nTotal Before Tax: %.2f\nTax: %.2f",
                homeQuote.premiumBeforeTax(),
                homeQuote.totalBeforeTax(),
                homeQuote.calculateTax());
        System.out.println("\n\nHomePolicy testing");
        Customer customer = getTestCustomer();
        HomePolicy policy = PolicyBuilder.getNewHomePolicy(LocalDate.now(), LocalDate.now().plusDays(360),home,customer);
        System.out.printf("\nHome Premium: %.2f\nTotal Before Tax: %.2f\nTax: %.2f\nFinal Total: %.2f",
                policy.premiumBeforeTax(),
                policy.totalBeforeTax(),
                policy.calculateTax(),
                policy.totalBeforeTax().add(policy.calculateTax()));
    }

    public static Customer getTestCustomer(){
        //TODO Randomize this? Add in edge cases
        return new Customer("Josh", "Taylor", LocalDate.of(1990,10,1));
    }

    public static Home getTestHome(){
        //TODO Randomize this? Add in edge cases
        Random random = new Random();
        int i = Math.abs(random.nextInt());
//        System.out.printf("\n>%d", i % 3);
        if(i % 3 == 0){
            Home home = new Home();
            home.setDateBuilt(LocalDate.of(2005,1,1));
            home.setValue(400000);
            home.setHeatingType(Home.HeatingType.OIL);
            home.setLocation(Home.Location.RURAL);
            return home;
        } else if(i % 3 == 1){
            Home home = new Home();
            home.setDateBuilt(LocalDate.of(1905,1,1));
            home.setValue(600000);
            home.setHeatingType(Home.HeatingType.WOOD);
            home.setLocation(Home.Location.URBAN);
            return home;
        } else {
            Home home = new Home();
            home.setDateBuilt(LocalDate.of(1985,1,1));
            home.setValue(400000);
            home.setHeatingType(Home.HeatingType.OTHER);
            home.setLocation(Home.Location.URBAN);
            return home;
        }
    }

    public static void printHomeInfo(Home home){
        System.out.printf("\nHome details> Value: %.2f, Heating: %s, Location: %s, Age: %d",
                home.getValue(),
                home.getHeatingType().name(),
                home.getLocation().name(),
                home.getAge()
                );
    }

}
