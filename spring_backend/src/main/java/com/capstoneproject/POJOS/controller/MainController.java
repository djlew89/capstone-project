package com.capstoneproject.POJOS.controller;

import com.capstoneproject.*;
import com.capstoneproject.POJOS.AutoQuote;
import com.capstoneproject.POJOS.DataAccess.*;
import com.capstoneproject.POJOS.HomeQuote;
import com.capstoneproject.POJOS.PolicyBuilder;
import com.capstoneproject.POJOS.QuoteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Controller //This means that this class is a Controller
@RequestMapping(path = RESTNouns.VERSION_1) //This means URL's start with /v1 (after Application path)
public class MainController {

    //Wire the ORM
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AutoRepository autoRepository;
    @Autowired
    private HomeRepository homeRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private HomePolicyRepository homePolicyRepository;

    @Autowired
    private AutoPolicyRepository autoPolicyRepository;


    //USER - GET / READ All
    @CrossOrigin
    @GetMapping(path = RESTNouns.USER)
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    //USER - GET / READ ONE by ID
    @CrossOrigin
    @GetMapping(path = RESTNouns.USER + RESTNouns.USER_ID)
    public @ResponseBody Optional<User> getUserWithId(@PathVariable Integer id) {
        return userRepository.findById(id);
    }

    //USER - POST / CREATE ONE
    @CrossOrigin
    @PostMapping(path = RESTNouns.USER)
    public @ResponseBody String addNewUser(@RequestParam String email,
                                           @RequestParam String password, @RequestParam String address,
                                           @RequestParam LocalDate dob, @RequestParam String fname,
                                           @RequestParam String lname) {
        Optional<User> userCheck = userRepository.getAllByEmail(email);

        if (userCheck.isPresent()) {
            return "User already registered";
        }


        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        user.setFirstName(fname);
        user.setLastName(lname);
        user.setDob(dob);
        user.setAddress(address);
        userRepository.save(user);

        return "User Registered";
    }

    //USER -PUT / UPDATE ONE
    @CrossOrigin
    @PutMapping(path = RESTNouns.USER + RESTNouns.USER_ID)
    public @ResponseBody String updateUser(@PathVariable Integer id,
                                           @RequestParam String email,
                                           @RequestParam String password, @RequestParam String address,
                                           @RequestParam LocalDate dob, @RequestParam String fname,
                                           @RequestParam String lname) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            user.get()
                    .setEmail(email);
            user.get()
                    .setPassword(password);
            user.get()
                    .setFirstName(fname);
            user.get()
                    .setLastName(lname);
            user.get()
                    .setAddress(address);
            user.get()
                    .setDob(dob);
            userRepository.save(user.get());
            return "Updated!";
        } else {
            return "Not Found";
        }
    }

    //USER -DELETE / DELETE ONE
    @CrossOrigin
    @DeleteMapping(path = RESTNouns.USER + RESTNouns.USER_ID)
    public @ResponseBody String deleteUser(@PathVariable Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            Iterable<Home> homes = homeRepository.getAllByUserId(id);
            homes.forEach(home ->
            {
                Optional<HomePolicy> homePolicy = homePolicyRepository.getByHomeId(home.getId());
                if (homePolicy.isPresent()) {
                    homePolicyRepository.delete(homePolicy.get());
                }
            });
            homeRepository.deleteAll(homes);


            Iterable<Vehicle> autos = autoRepository.getAllByUserId(id);
            autos.forEach(auto ->
            {
                Optional<AutoPolicy> autoPolicy = autoPolicyRepository.getByVehicleId(auto.getId());
                if (autoPolicy.isPresent()) {
                    autoPolicyRepository.delete(autoPolicy.get());
                }
            });
            autoRepository.deleteAll(autos);

            Optional<Driver> driver = driverRepository.findByUserId(id);
            if (driver.isPresent()) {
                driverRepository.delete(driver.get());
            }

            userRepository.delete(user.get());
            return "Deleted";
        } else {
            return "Not Found";
        }
    }

    //HOME REST

    /**
     * Get All homes from Database
     *
     * @return Iterable<Home>
     */
    @CrossOrigin
    @GetMapping(path = RESTNouns.HOME)
    public @ResponseBody Iterable<Home> getAllHomes() {
        return homeRepository.findAll();
    }

    /**
     * Get One Home by ID
     *
     * @param home_id the home id
     * @return the Home object for the id
     */
    @CrossOrigin
    @GetMapping(path = RESTNouns.HOME + RESTNouns.HOME_ID)
    public @ResponseBody Optional<Home> getHomeByID(@PathVariable Integer home_id) {
        return homeRepository.findById(home_id);
    }

    /**
     * Get Mapping for Home based on User ID
     *
     * @param id home id
     * @return Home
     */
    @CrossOrigin
    @GetMapping(path = RESTNouns.USER + RESTNouns.USER_ID + RESTNouns.HOME)
    public @ResponseBody Iterable<Home> getAllHomesByUser(@PathVariable Integer id) {
        Optional<User> user = userRepository.findById(id);
        Iterable<Home> homes = new LinkedList<>();

        if (user.isPresent()) {
            homes = homeRepository.getAllByUserId(id);
        }

        return homes;
    }

    /**
     * Add new Home to Database
     *
     * @param id
     * @param dateBuilt
     * @param value
     * @param heatingType
     * @param location
     * @return String
     */
    @CrossOrigin
    @PostMapping(path = RESTNouns.USER + RESTNouns.USER_ID + RESTNouns.HOME)
    public @ResponseBody String addNewHome(@PathVariable Integer id,
                                           @RequestParam LocalDate dateBuilt,
                                           @RequestParam Integer value,
                                           @RequestParam Home.HeatingType heatingType,
                                           @RequestParam Home.Location location) {
        Home home = new Home();
        home.setDateBuilt(dateBuilt);
        home.setValue(value);
        home.setHeatingType(heatingType);
        home.setLocation(location);

        //Scope the customer
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            home.setUser(user.get());   //Link it to the user
            homeRepository.save(home);
            return "Saved home to database"; //TODO Send a better message
        } else {
            return "Failed to find user";
        }
    }

    /**
     * Delete Home from Database by Home ID
     *
     * @param home_id
     * @return
     */
    @CrossOrigin
    @DeleteMapping(path = RESTNouns.HOME + RESTNouns.HOME_ID)
    public @ResponseBody String deleteHomeByID(@PathVariable Integer home_id) {
        Optional<Home> home = homeRepository.findById(home_id);
        if (home.isPresent()) {
            homeRepository.delete(home.get());
            return "Deleted";
        } else {
            return "Not Found";
        }
    }

    /**
     * Update Home in Database
     *
     * @param home_id
     * @param dateBuilt
     * @param value
     * @param heatingType
     * @param location
     * @return String
     */
    @CrossOrigin
    @PutMapping(path = RESTNouns.HOME + RESTNouns.HOME_ID)
    public @ResponseBody String updateHome(@PathVariable Integer home_id,
                                           @RequestParam LocalDate dateBuilt,
                                           @RequestParam double value,
                                           @RequestParam Home.HeatingType heatingType,
                                           @RequestParam Home.Location location) {
        Optional<Home> home = homeRepository.findById(home_id);
        if (home.isPresent()) {
            home.get()
                    .setDateBuilt(dateBuilt);
            home.get()
                    .setValue(value);
            home.get()
                    .setHeatingType(heatingType);
            home.get()
                    .setLocation(location);
            homeRepository.save(home.get());
            return "Updated!";
        } else {
            return "Not Found.";
        }
    }
    //    AUTO REST

    /**
     * Get All Vehicles from Database
     *
     * @return Iterable<Vehicle>
     */
    @CrossOrigin
    @GetMapping(path = RESTNouns.AUTO)
    public @ResponseBody Iterable<Vehicle> getAllAuto() {
        return autoRepository.findAll();
    }

    /**
     * Get One Vehicle by ID
     *
     * @param auto_id
     * @return Vehicle
     */
    @CrossOrigin
    @GetMapping(path = RESTNouns.AUTO + RESTNouns.AUTO_ID)
    public @ResponseBody Iterable<Optional<Vehicle>> getAutoWithId(@PathVariable Integer auto_id) {
        List<Optional<Vehicle>> autos = new ArrayList<>(1);
        autos.add(autoRepository.findById(auto_id));
        return autos;
    }

    /**
     * Add Vehicle to Database
     *
     * @param make
     * @param model
     * @param year
     * @return String
     */
    @CrossOrigin
    @PostMapping(path = RESTNouns.USER + RESTNouns.USER_ID + RESTNouns.AUTO)
    public @ResponseBody String addNewAuto(@PathVariable Integer id, @RequestParam String make, @RequestParam String model, @RequestParam Integer year) {
        Vehicle auto = new Vehicle();
        auto.setMake(make);
        auto.setModel(model);
        auto.setYear(year);

        //Scope the customer
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            auto.setUser(user.get());   //Link it to the user
            autoRepository.save(auto);
            return "Saved vehicle to database";
        } else {
            return "Failed to find user";
        }
    }

    /**
     * Delete vehicle from database
     *
     * @param auto_id
     * @return
     */
    @CrossOrigin
    @DeleteMapping(path = RESTNouns.AUTO + RESTNouns.AUTO_ID)
    public @ResponseBody String deleteAuto(@PathVariable Integer auto_id) {
        Optional<Vehicle> auto = autoRepository.findById(auto_id);
        if (auto.isPresent()) {
            autoRepository.delete(auto.get());
            return "Deleted";
        } else {
            return "Not Found";
        }
    }

    /**
     * Get All User Vehicles
     *
     * @param id
     * @return Iterable<Vehicle>
     */
    @CrossOrigin
    @GetMapping(path = RESTNouns.USER + RESTNouns.USER_ID + RESTNouns.AUTO)
    public @ResponseBody Iterable<Vehicle> getAllAutoByUser(@PathVariable Integer id) {
        Optional<User> user = userRepository.findById(id);
        Iterable<Vehicle> cars = new LinkedList<>();

        if (user.isPresent()) {
            cars = autoRepository.getAllByUserId(id);
        }

        return cars;
    }

    /**
     * Update Vehicle in Database
     *
     * @param auto_id
     * @param make
     * @param model
     * @param year
     * @return String
     */
    @CrossOrigin
    @PutMapping(path = RESTNouns.AUTO + RESTNouns.AUTO_ID)
    public @ResponseBody String updateVehicle(@PathVariable Integer auto_id, @RequestParam String make, @RequestParam String model, @RequestParam int year) {
        Optional<Vehicle> auto = autoRepository.findById(auto_id);
        if (auto.isPresent()) {
            auto.get()
                    .setMake(make);
            auto.get()
                    .setModel(model);
            auto.get()
                    .setYear(year);
            autoRepository.save(auto.get());
            return "Updated!";
        } else {
            return "Not Found.";
        }
    }

    // Driver REST

    /**
     * Get All Drivers from Database
     *
     * @return
     */
    @CrossOrigin
    @GetMapping(path = RESTNouns.DRIVER)
    public @ResponseBody Iterable<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    /**
     * Get One Driver by ID
     *
     * @param driver_id
     * @return
     */
    @CrossOrigin
    @GetMapping(path = RESTNouns.DRIVER + RESTNouns.DRIVER_ID)
    public @ResponseBody Optional<Driver> getDriverById(@PathVariable Integer driver_id) {
        return driverRepository.findById(driver_id);
    }

    /**
     * Get Driver by User ID
     *
     * @param id
     * @return
     */
    @CrossOrigin
    @GetMapping(path = RESTNouns.USER + RESTNouns.USER_ID + RESTNouns.DRIVER)
    public @ResponseBody Optional<Driver> getDriverByUserId(@PathVariable Integer id) {
        Optional<User> user = userRepository.findById(id);
        Optional<Driver> driver = Optional.empty();

        if (user.isPresent()) {
            driver = driverRepository.findByUserId(id);

        }
        return driver;
    }

    /**
     * Add new Driver to Database
     *
     * @param id
     * @param numOfAccidents
     * @return String
     */
    @CrossOrigin
    @PostMapping(path = RESTNouns.USER + RESTNouns.USER_ID + RESTNouns.DRIVER)
    public @ResponseBody String addNewDriver(@PathVariable Integer id,
                                             @RequestParam Integer numOfAccidents) {
        Optional<Driver> driverCheck = driverRepository.findByUserId(id);
        if (driverCheck.isPresent()) {
            return "Driver already registered for user";
        }

        Driver driver = new Driver();
        driver.setNumberAccidents(numOfAccidents);

        //Scope the customer
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            driver.setUser(user.get());   //Link it to the user
            driverRepository.save(driver);

            return "Saved driver to database";
        } else {
            return "Failed to find user";
        }
    }

    /**
     * Delete Driver by Driver ID
     *
     * @param driver_id
     * @return String
     */
    @CrossOrigin
    @DeleteMapping(path = RESTNouns.DRIVER + RESTNouns.DRIVER_ID)
    public @ResponseBody String deleteDriver(@PathVariable Integer driver_id) {
        Optional<Driver> driver = driverRepository.findById(driver_id);
        if (driver.isPresent()) {
            driverRepository.delete(driver.get());
            return "Deleted";
        } else {
            return "Not Found";
        }
    }

    /**
     * Update Driver in Database
     *
     * @param numOfAccidents
     * @return String
     */
    @CrossOrigin
    @PutMapping(path = RESTNouns.DRIVER + RESTNouns.DRIVER_ID)
    public @ResponseBody String updateDriver(@PathVariable Integer driver_id,
                                             @RequestParam Integer numOfAccidents) {
        Optional<Driver> driver = driverRepository.findById(driver_id);
        if (driver.isPresent()) {
            driver.get()
                    .setNumberAccidents(numOfAccidents);
            driverRepository.save(driver.get());
            return "Updated!";
        } else {
            return "Not Found.";
        }
    }

    //Quote REST

    /**
     * Home Quote - Does not write to database. Option to access route should only be available to registered Home views.
     *
     * @param id
     * @param home_id
     * @return HomeQuote
     */
    @CrossOrigin
    @GetMapping(path = RESTNouns.USER + RESTNouns.USER_ID + RESTNouns.QUOTE + RESTNouns.HOME + RESTNouns.HOME_ID)
    public @ResponseBody Iterable<Optional<HomeQuote>> getHomeQuote(@PathVariable Integer id, @PathVariable Integer home_id) {
        List<Optional<HomeQuote>> quote = new ArrayList<>(1);
        Optional<HomeQuote> homeQuote;
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            Optional<Home> home = homeRepository.findById(home_id);
            if (home.isPresent()) {
                homeQuote = Optional.of(QuoteBuilder.getNewHomeQuote(home.get()));
                quote.add(homeQuote);
            }
        }
        return quote;
    }

    /**
     * Auto Quote - Does not write to database. Option to access route should only be available to registered vehicle views.
     *
     * @param id
     * @param auto_id
     * @return AutoQuote
     */
    @CrossOrigin
    @GetMapping(path = RESTNouns.USER + RESTNouns.USER_ID + RESTNouns.QUOTE + RESTNouns.AUTO + RESTNouns.AUTO_ID)
    public @ResponseBody Optional<AutoQuote> getAutoQuote(@PathVariable Integer id, @PathVariable Integer auto_id) {
        Optional<AutoQuote> autoQuote = Optional.empty();
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            Optional<Vehicle> auto = autoRepository.findById(auto_id);
            Optional<Driver> driver = driverRepository.findByUserId(id);
            if (auto.isPresent()) {
                autoQuote = Optional.of(QuoteBuilder.getNewAutoQuote(auto.get(), driver.get()));
            }
        }
        return autoQuote;
    }

    // HomePolicy REST

    /**
     * Save a Home Policy to Database
     *
     * @param id
     * @param home_id
     * @param startDate
     * @return
     */
    @CrossOrigin
    @PostMapping(path = RESTNouns.USER + RESTNouns.USER_ID + RESTNouns.POLICY + RESTNouns.HOME + RESTNouns.HOME_ID)
    public @ResponseBody String addNewHomePolicy(@PathVariable Integer id,
                                                 @PathVariable Integer home_id,
                                                 @RequestParam LocalDate startDate) {
        Optional<HomePolicy> homePolicy = Optional.empty();

        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            Optional<Home> home = homeRepository.findById(home_id);
            if (home.isPresent()) {
                homePolicy = Optional.of(PolicyBuilder.getNewHomePolicy(startDate, startDate.plusDays(365), home.get(), user.get()));
                homePolicyRepository.save(homePolicy.get());
                return "Home Policy Created!";
            } else {
                return "Home not registered";
            }
        } else {
            return "Please Register User";
        }

    }

    //AutoPolicy REST

    /**
     * Save an Auto Policy to Database
     *
     * @param id
     * @param auto_id
     * @param startDate
     * @return
     */
    @CrossOrigin
    @PostMapping(path = RESTNouns.USER + RESTNouns.USER_ID + RESTNouns.POLICY + RESTNouns.AUTO + RESTNouns.AUTO_ID)
    public @ResponseBody String addNewAutoPolicy(@PathVariable Integer id,
                                                 @PathVariable Integer auto_id,
                                                 @RequestParam LocalDate startDate) {
        Optional<AutoPolicy> autoPolicy = Optional.empty();

        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {

            Optional<Vehicle> auto = autoRepository.findById(auto_id);
            Optional<Driver> driver = driverRepository.findByUserId(id);
            if (driver.isPresent()) {
                if (auto.isPresent()) {
                    autoPolicy = Optional.of(PolicyBuilder.getNewAutoPolicy(startDate, startDate.plusDays(365), auto.get(), driver.get(), user.get()));
                    autoPolicyRepository.save(autoPolicy.get());
                    return "Auto Policy Created!";
                } else {
                    return "Vehicle not Found";
                }
            } else {
                return "Please register as a Driver";
            }
        } else {
            return "Please register User.";
        }

    }
}
