package com.capstoneproject.POJOS.controller;

import com.capstoneproject.*;
import com.capstoneproject.POJOS.DataAccess.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.LinkedList;
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
    private CustomerRepository customerRepository;
    @Autowired
    private HomeRepository homeRepository;

    @Autowired
    private HomePolicyRepository homePolicyRepository;

    //USER - GET / READ All
    @GetMapping(path = RESTNouns.USER)
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    //USER - GET / READ ONE by ID
    @GetMapping(path = RESTNouns.USER + RESTNouns.USER_ID)
    public @ResponseBody Optional<User> getUserWithId(@PathVariable Integer id) {
        return userRepository.findById(id);
    }

    //USER - POST / CREATE ONE
    @PostMapping(path = RESTNouns.USER)
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "User Registered";
    }

    //USER -PUT / UPDATE ONE
    @PutMapping(path = RESTNouns.USER + RESTNouns.USER_ID + "/update")
    public @ResponseBody String updateUser(@PathVariable Integer id,
                                           @RequestParam String name,
                                           @RequestParam String email) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            user.get()
                    .setName(name);
            user.get()
                    .setEmail(email);
            userRepository.save(user.get());
            return "Updated!";
        } else {
            return "Not Found";
        }
    }

    //USER -DELETE / DELETE ONE
    @DeleteMapping(path = RESTNouns.USER + RESTNouns.USER_ID + "/delete")
    public @ResponseBody String deleteUser(@PathVariable Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            return "Deleted";
        } else {
            return "Not Found";
        }
    }

    //HOME REST

    //HOME - GET / READ All (DEBUG Only)
    @GetMapping(path = RESTNouns.USER + RESTNouns.HOME)
    public @ResponseBody Iterable<Home> getAllHomes() {
        return homeRepository.findAll();
    }

    //HOME -GET / READ ONE
    @GetMapping(path = RESTNouns.USER + RESTNouns.HOME + RESTNouns.HOME_ID)
    public @ResponseBody Optional<Home> getHomeByID(@PathVariable Integer home_id) {
        return homeRepository.findById(home_id);
    }

    /**
     * Get Mapping for Home based on ID
     *
     * @param userId user id
     * @return home object
     */
    @GetMapping(path = RESTNouns.USER + RESTNouns.USER_ID + RESTNouns.HOME)
    public @ResponseBody Iterable<Home> getAllHomesByUser(@PathVariable(name = "user_id") Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        //        Optional<Customer> cusotmer = customerRepository
        Iterable<Home> homes = new LinkedList<>();

        if (user.isPresent()) {
            homes = homeRepository.getAllByUserId(user.get()
                    .getId());
        }

        return homes;
    }

    //ECHO Home info to build out the components
    //    @Id
    //    @GeneratedValue(strategy = GenerationType.AUTO) private Integer id;
    //    @JsonFormat(pattern="yyyy-MM-dd")  private LocalDate yearBuilt;
    //    private int value;
    //    @Enumerated(EnumType.ORDINAL) private Home.HeatingType heatingType;
    //    @Enumerated(EnumType.ORDINAL) private Home.Location location;

    //HOME - POST / CREATE ONE
    @PostMapping(path = RESTNouns.USER + RESTNouns.USER_ID + RESTNouns.HOME)
    public @ResponseBody String addNewHome(@PathVariable Integer id,
                                           @RequestParam LocalDate date,
                                           @RequestParam Integer value,
                                           @RequestParam Home.HeatingType heatingType,
                                           @RequestParam Home.Location location) {
        Home home = new Home();
        home.setDateBuilt(date);
        home.setValue(value);
        home.setHeatingType(heatingType);
        home.setLocation(location);

        //Scope the customer
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            home.setCustomer(customer.get());   //Link it to the user
            homeRepository.save(home);
            return "Saved"; //TODO Send a better message
        } else {
            return "Failed to find user";
        }
    }

    //HOME -DELETE / DELETE ONE
    @DeleteMapping(path = RESTNouns.USER + RESTNouns.USER_ID + RESTNouns.HOME + RESTNouns.HOME_ID + "/delete")
    public @ResponseBody String deleteHome(@PathVariable Integer home_id) {
        Optional<Home> home = homeRepository.findById(home_id);
        if (home.isPresent()) {
            homeRepository.delete(home.get());
            return "Deleted";
        } else {
            return "Not Found";
        }
    }

    //HOME -PUT / UPDATE ONE
    @PutMapping(path = RESTNouns.USER + RESTNouns.USER_ID + RESTNouns.HOME_ID + "/update")
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

    @GetMapping(path = RESTNouns.AUTO)
    public @ResponseBody Iterable<Vehicle> getAllAuto() {
        return autoRepository.findAll();
    }

    //AUTO - GET / READ ONE by ID
    @GetMapping(path = RESTNouns.AUTO + RESTNouns.AUTO_ID)
    public @ResponseBody Optional<Vehicle> getAutoWithId(@PathVariable Integer auto_id) {
        return autoRepository.findById(auto_id);
    }

    @PostMapping(path = RESTNouns.AUTO)
    public @ResponseBody String addNewAuto(@RequestParam String make, @RequestParam String model, @RequestParam Integer year) {
        Vehicle auto = new Vehicle();
        auto.setMake(make);
        auto.setModel(model);
        auto.setYear(year);
        autoRepository.save(auto);
        return "Vehicle Registered";
    }

    @DeleteMapping(path = RESTNouns.AUTO + RESTNouns.AUTO_ID + "/delete")
    public @ResponseBody String deleteAuto(@PathVariable Integer auto_id) {
        Optional<Vehicle> auto = autoRepository.findById(auto_id);
        if (auto.isPresent()) {
            autoRepository.delete(auto.get());
            return "Deleted";
        } else {
            return "Not Found";
        }
    }

    //HOME REST
    //HOME POLICY -GET / READ ONE
    @GetMapping(path = RESTNouns.HOME + RESTNouns.HOME_POLICY + RESTNouns.CUSTOMER_ID + RESTNouns.HOME_ID)
    public @ResponseBody Optional<Home> getPolicyByHomeID(@PathVariable Integer home_id, @PathVariable Integer customer_id) {
        Optional<Customer> customer = customerRepository.findById(customer_id);
        if (customer.isPresent()) {
            Optional<Home> home = homeRepository.findById(home_id);
            if (home.isPresent()) {
                HomePolicy policy = new HomePolicy();
                policy.setHome(home.get());
                policy.setCustomer(customer.get());

                homePolicyRepository.save(policy);
            }
        }
        return Optional.empty();
    }

    //Quote REST
    /*
    To get a new Quote, send a GET request, with User ID and the Home ID as a parameter.
    Build the Quote object from the Quote manager
     */
//    @GetMapping(path = RESTNouns.USER_ID + RESTNouns.HOME_ID)
//    public @ResponseBody Optional<Quote> getQuoteWithId(@PathVariable Integer user_id, @PathVariable Integer home_id)
//    {
//        Optional<User> user = userRepository.findById(user_id);
//        Optional<Home> home = homeRepository.findById(home_id);
//        if (user.isPresent() && home.isPresent())
//        {
//            Quote quote = QuoteBuilder.getNewHomeQuote(user.get(), home.get());
//            return Optional.of(quote);
//        }
//        else
//        {
//            return Optional.empty();
//        }
//    }
}
