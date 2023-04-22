package com.capstoneproject.POJOS.controller;

import com.capstoneproject.*;
import com.capstoneproject.POJOS.DataAccess.AutoRepository;
import com.capstoneproject.POJOS.DataAccess.DriverRepository;
import com.capstoneproject.POJOS.DataAccess.HomeRepository;
import com.capstoneproject.POJOS.DataAccess.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Optional;

@Controller //This means that this class is a Controller
@RequestMapping(path = RESTNouns.VERSION_1) //This means URL's start with /v1 (after Application path)
public class MainController
{

    //Wire the ORM
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AutoRepository autoRepository;
    @Autowired
    private HomeRepository homeRepository;

    @Autowired
    private DriverRepository driverRepository;


    //USER - GET / READ All
    @GetMapping(path = RESTNouns.USER)
    public @ResponseBody Iterable<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    //USER - GET / READ ONE by ID
    @GetMapping(path = RESTNouns.USER + RESTNouns.USER_ID)
    public @ResponseBody Optional<User> getUserWithId(@PathVariable Integer id)
    {
        return userRepository.findById(id);
    }

    //USER - POST / CREATE ONE
    @PostMapping(path = RESTNouns.USER)
    public @ResponseBody String addNewUser(@RequestParam String email,
                                           @RequestParam String password, @RequestParam String address,
                                           @RequestParam LocalDate dob, @RequestParam String fname,
                                           @RequestParam String lname)
    {
        Optional<User> userCheck = userRepository.getAllByEmail(email);

        if(userCheck.isPresent()){
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
    @PutMapping(path = RESTNouns.USER + RESTNouns.USER_ID)
    public @ResponseBody String updateUser(@PathVariable Integer id,
                                           @RequestParam String email,
                                           @RequestParam String password, @RequestParam String address,
                                           @RequestParam LocalDate dob, @RequestParam String fname,
                                           @RequestParam String lname)
    {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent())
        {
            user.get()
                    .setEmail(email);
            user.get().setPassword(password);
            user.get().setFirstName(fname);
            user.get().setLastName(lname);
            user.get().setAddress(address);
            user.get().setDob(dob);
            userRepository.save(user.get());
            return "Updated!";
        }
        else
        {
            return "Not Found";
        }
    }

    //USER -DELETE / DELETE ONE
    @DeleteMapping(path = RESTNouns.USER + RESTNouns.USER_ID)
    public @ResponseBody String deleteUser(@PathVariable Integer id)
    {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent())
        {
            Iterable<Home> homes = homeRepository.getAllByUserId(id);
            homes.forEach(home -> {
                homeRepository.delete(home);
            });
            Optional<Driver> driver = driverRepository.findByUserId(id);
            driverRepository.delete(driver.get());
            userRepository.delete(user.get());
            return "Deleted";
        }
        else
        {
            return "Not Found";
        }
    }

    //HOME REST

    /**
     * Get All homes from Database
     * @return Iterable<Home>
     */
    @GetMapping(path = RESTNouns.USER + RESTNouns.HOME)
    public @ResponseBody Iterable<Home> getAllHomes()
    {
        return homeRepository.findAll();
    }

    /**
     * Get One Home by ID
     * @param home_id
     * @return
     */
    @GetMapping(path = RESTNouns.HOME + RESTNouns.HOME_ID)
    public @ResponseBody Optional<Home> getHomeByID(@PathVariable Integer home_id)
    {
        return homeRepository.findById(home_id);
    }

    /**
     * Get Mapping for Home based on User ID
     *
     * @param id
     * @return Home
     */
    @GetMapping(path = RESTNouns.USER + RESTNouns.USER_ID + RESTNouns.HOME)
    public @ResponseBody Iterable<Home> getAllHomesByUser(@PathVariable Integer id)
    {
        Optional<User> user = userRepository.findById(id);
        Iterable<Home> homes = new LinkedList<>();

        if (user.isPresent())
        {
            homes = homeRepository.getAllByUserId(id);
        }

        return homes;
    }

    /**
     * Add new Home to Database
     * @param id
     * @param dateBuilt
     * @param value
     * @param heatingType
     * @param location
     * @return String
     */
    @PostMapping(path = RESTNouns.USER + RESTNouns.USER_ID + RESTNouns.HOME)
    public @ResponseBody String addNewHome(@PathVariable Integer id,
                                           @RequestParam LocalDate dateBuilt,
                                           @RequestParam Integer value,
                                           @RequestParam Home.HeatingType heatingType,
                                           @RequestParam Home.Location location)
    {
        Home home = new Home();
        home.setDateBuilt(dateBuilt);
        home.setValue(value);
        home.setHeatingType(heatingType);
        home.setLocation(location);

        //Scope the customer
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent())
        {
            home.setUser(user.get());   //Link it to the user
            homeRepository.save(home);
            return "Saved home to database"; //TODO Send a better message
        }
        else
        {
            return "Failed to find user";
        }
    }

    /**
     * Delete Home from Database by Home ID
     * @param home_id
     * @return
     */
    @DeleteMapping(path = RESTNouns.HOME + RESTNouns.HOME_ID)
    public @ResponseBody String deleteHomeByID(@PathVariable Integer home_id)
    {
        Optional<Home> home = homeRepository.findById(home_id);
        if (home.isPresent())
        {
            homeRepository.delete(home.get());
            return "Deleted";
        }
        else
        {
            return "Not Found";
        }
    }

    /**
     * Update Home in Database
     * @param home_id
     * @param dateBuilt
     * @param value
     * @param heatingType
     * @param location
     * @return String
     */
    @PutMapping(path = RESTNouns.HOME + RESTNouns.HOME_ID)
    public @ResponseBody String updateHome(@PathVariable Integer home_id,
                                           @RequestParam LocalDate dateBuilt,
                                           @RequestParam double value,
                                           @RequestParam Home.HeatingType heatingType,
                                           @RequestParam Home.Location location)
    {
        Optional<Home> home = homeRepository.findById(home_id);
        if (home.isPresent())
        {
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
        }
        else
        {
            return "Not Found.";
        }
    }
    //    AUTO REST

    /**
     * Get All Vehicles from Database
     * @return Iterable<Vehicle>
     */
    @GetMapping(path = RESTNouns.AUTO)
    public @ResponseBody Iterable<Vehicle> getAllAuto()
    {
        return autoRepository.findAll();
    }

    /**
     * Get One Vehicle by ID
     * @param auto_id
     * @return Vehicle
     */
    @GetMapping(path = RESTNouns.AUTO + RESTNouns.AUTO_ID)
    public @ResponseBody Optional<Vehicle> getAutoWithId(@PathVariable Integer auto_id)
    {
        return autoRepository.findById(auto_id);
    }

    /**
     * Add Vehicle to Database
     * @param make
     * @param model
     * @param year
     * @return String
     */
    @PostMapping(path = RESTNouns.USER+RESTNouns.USER_ID+RESTNouns.AUTO)
    public @ResponseBody String addNewAuto(@PathVariable Integer id, @RequestParam String make, @RequestParam String model, @RequestParam Integer year)
    {
        Vehicle auto = new Vehicle();
        auto.setMake(make);
        auto.setModel(model);
        auto.setYear(year);

        //Scope the customer
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent())
        {
            auto.setUser(user.get());   //Link it to the user
            autoRepository.save(auto);
            return "Saved vehicle to database";
        }
        else
        {
            return "Failed to find user";
        }
    }

    /**
     * Delete vehicle from database
     * @param auto_id
     * @return
     */
    @DeleteMapping(path = RESTNouns.AUTO + RESTNouns.AUTO_ID)
    public @ResponseBody String deleteAuto(@PathVariable Integer auto_id)
    {
        Optional<Vehicle> auto = autoRepository.findById(auto_id);
        if (auto.isPresent())
        {
            autoRepository.delete(auto.get());
            return "Deleted";
        }
        else
        {
            return "Not Found";
        }
    }

    /**
     * Get All User Vehicles
     * @param id
     * @return Iterable<Vehicle>
     */
    @GetMapping(path = RESTNouns.USER + RESTNouns.USER_ID + RESTNouns.AUTO)
    public @ResponseBody Iterable<Vehicle> getAllAutoByUser(@PathVariable Integer id)
    {
        Optional<User> user = userRepository.findById(id);
        Iterable<Vehicle> cars = new LinkedList<>();

        if (user.isPresent())
        {
            cars = autoRepository.getAllByUserId(id);
        }

        return cars;
    }

    /**
     * Update Vehicle in Database
     * @param auto_id
     * @param make
     * @param model
     * @param year
     * @return String
     */
    @PutMapping(path = RESTNouns.AUTO+RESTNouns.AUTO_ID)
    public @ResponseBody String updateVehicle(@PathVariable Integer auto_id, @RequestParam String make, @RequestParam String model, @RequestParam int year)
    {
        Optional<Vehicle> auto = autoRepository.findById(auto_id);
        if (auto.isPresent())
        {
            auto.get().setMake(make);
            auto.get().setModel(model);
            auto.get().setYear(year);
            autoRepository.save(auto.get());
            return "Updated!";
        }
        else
        {
            return "Not Found.";
        }
    }

    // Driver REST

    /**
     * Get All Drivers from Database
     * @return
     */
    @GetMapping(path = RESTNouns.DRIVER)
    public @ResponseBody Iterable<Driver> getAllDrivers()
    {
        return driverRepository.findAll();
    }

    /**
     * Get One Driver by ID
     * @param driver_id
     * @return
     */
    @GetMapping(path = RESTNouns.DRIVER + RESTNouns.DRIVER_ID)
    public @ResponseBody Optional<Driver> getDriverById(@PathVariable Integer driver_id)
    {
        return driverRepository.findById(driver_id);
    }

    /**
     * Get Driver by User ID
     * @param id
     * @return
     */
    @GetMapping(path = RESTNouns.USER + RESTNouns.USER_ID + RESTNouns.DRIVER)
    public @ResponseBody Optional<Driver> getDriverByUserId(@PathVariable Integer id)
    {
        Optional<User> user = userRepository.findById(id);
        Optional<Driver> driver = null;

        if (user.isPresent())
        {
            driver = driverRepository.findByUserId(id);

        }
        return driver;
    }

    /**
     * Add new Driver to Database
     * @param id
     * @param numOfAccidents
     * @return String
     */
    @PostMapping(path = RESTNouns.USER + RESTNouns.USER_ID + RESTNouns.DRIVER)
    public @ResponseBody String addNewDriver(@PathVariable Integer id,
                                           @RequestParam Integer numOfAccidents)
    {
        Optional<Driver> driverCheck = driverRepository.findByUserId(id);
        if(driverCheck.isPresent()){
            return "Driver already registered for user";
        }

        Driver driver = new Driver();
        driver.setNumberAccidents(numOfAccidents);

        //Scope the customer
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent())
        {
            driver.setUser(user.get());   //Link it to the user
            driverRepository.save(driver);

            return "Saved driver to database";
        }
        else
        {
            return "Failed to find user";
        }
    }

    /**
     * Delete Driver by Driver ID
     * @param driver_id
     * @return String
     */
    @DeleteMapping(path = RESTNouns.DRIVER + RESTNouns.DRIVER_ID)
    public @ResponseBody String deleteDriver(@PathVariable Integer driver_id)
    {
        Optional<Driver> driver = driverRepository.findById(driver_id);
        if (driver.isPresent())
        {
            driverRepository.delete(driver.get());
            return "Deleted";
        }
        else
        {
            return "Not Found";
        }
    }

    /**
     * Update Driver in Database
     * @param numOfAccidents
     * @return String
     */
    @PutMapping(path = RESTNouns.DRIVER + RESTNouns.DRIVER_ID)
    public @ResponseBody String updateDriver(@PathVariable Integer driver_id,
                                           @RequestParam Integer numOfAccidents)
    {
        Optional<Driver> driver = driverRepository.findById(driver_id);
        if (driver.isPresent())
        {
            driver.get()
                    .setNumberAccidents(numOfAccidents);
            driverRepository.save(driver.get());
            return "Updated!";
        }
        else
        {
            return "Not Found.";
        }
    }

    //Quote REST
    /*
    To get a new Quote, send a GET request, with User ID and the Home ID as a parameter.
    Build the Quote object from the Quote manager
     */
}
