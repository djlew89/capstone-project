package com.capstoneproject.POJOS.controller;

import com.capstoneproject.POJOS.DataAccess.HomeRepository;
import com.capstoneproject.POJOS.Home;
import com.capstoneproject.User;
import com.capstoneproject.POJOS.DataAccess.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@Controller //This means that this class is a Controller
@RequestMapping(path=RESTNouns.VERSION_1) //This means URL's start with /v1 (after Application path)
public class MainController {

    //Wire the ORM
    @Autowired private UserRepository userRepository;
    @Autowired private HomeRepository homeRepository;

    //USER - GET / READ All
    @GetMapping(path=RESTNouns.USER)
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    //USER - GET / READ ONE by ID
    @GetMapping(path = RESTNouns.USER + RESTNouns.USER_ID)
    public @ResponseBody Optional<User> getUserWithId(@PathVariable Integer id){
        return userRepository.findById(id);
    }

    //USER - POST / CREATE ONE
    @PostMapping(path=RESTNouns.USER)
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "User Registered";
    }

    //USER -PUT / UPDATE ONE
    @PutMapping(path=RESTNouns.USER+RESTNouns.USER_ID+"/update")
    public @ResponseBody String updateUser(@PathVariable Integer id,
                                           @RequestParam String name,
                                           @RequestParam String email){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            user.get().setName(name);
            user.get().setEmail(email);
            userRepository.save(user.get());
            return "Updated!";
        }else{
            return "Not Found";
        }
    }

    //USER -DELETE / DELETE ONE
    @DeleteMapping(path = RESTNouns.USER+RESTNouns.USER_ID+"/delete")
    public @ResponseBody String deleteUser(@PathVariable Integer id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            userRepository.delete(user.get());
            return "Deleted";
        }else{
            return "Not Found";
        }
    }

    //HOME REST

    //HOME - GET / READ All (DEBUG Only)
    @GetMapping(path=RESTNouns.USER + RESTNouns.HOME)
    public @ResponseBody Iterable<Home> getAllHomes(){
        return homeRepository.findAll();
    }

    //HOME -GET / READ ONE
    @GetMapping(path=RESTNouns.USER+RESTNouns.HOME+RESTNouns.HOME_ID)
    public @ResponseBody Optional<Home> getHomeByID(@PathVariable Integer home_id) {return homeRepository.findById(home_id);}

    //HOME -GET /READ ALL BY USER ID (not working yet)
//    @GetMapping(path=RESTNouns.USER+RESTNouns.USER_ID+RESTNouns.HOME)
//    public @ResponseBody Optional<Home> getAllUserHomes(@PathVariable Integer id) {return homeRepository.;}

//ECHO Home info to build out the components
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO) private Integer id;
//    @JsonFormat(pattern="yyyy-MM-dd")  private LocalDate yearBuilt;
//    private int value;
//    @Enumerated(EnumType.ORDINAL) private Home.HeatingType heatingType;
//    @Enumerated(EnumType.ORDINAL) private Home.Location location;

    //HOME - POST / CREATE ONE
    @PostMapping(path=RESTNouns.USER + RESTNouns.USER_ID + RESTNouns.HOME)
    public @ResponseBody String addNewHome(@PathVariable Integer id,
                                           @RequestParam LocalDate date,
                                           @RequestParam Integer value,
                                           @RequestParam Home.HeatingType heatingType,
                                           @RequestParam Home.Location location){


        Home home = new Home();
        home.setDateBuilt(date);
        home.setValue(value);
        home.setHeatingType(heatingType);
        home.setLocation(location);


        //Scope the customer
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            home.setUser(user.get());   //Link it to the user
            homeRepository.save(home);
            return "Saved"; //TODO Send a better message
        } else {
            return "Failed to find user";
        }
    }

    //HOME -DELETE / DELETE ONE
    @DeleteMapping(path = RESTNouns.USER+RESTNouns.USER_ID+RESTNouns.HOME+RESTNouns.HOME_ID+"/delete")
    public @ResponseBody String deleteHome(@PathVariable Integer home_id){
        Optional<Home> home = homeRepository.findById(home_id);
        if(home.isPresent()){
            homeRepository.delete(home.get());
            return "Deleted";
        }else{
            return "Not Found";
        }
    }

    //HOME -PUT / UPDATE ONE
    @PutMapping(path = RESTNouns.USER+RESTNouns.USER_ID+RESTNouns.HOME_ID+"/update")
    public @ResponseBody String updateHome(@PathVariable Integer home_id,
                                           @RequestParam LocalDate dateBuilt,
                                           @RequestParam double value,
                                           @RequestParam Home.HeatingType heatingType,
                                           @RequestParam Home.Location location){
        Optional<Home> home = homeRepository.findById(home_id);
        if(home.isPresent()){
            home.get().setDateBuilt(dateBuilt);
            home.get().setValue(value);
            home.get().setHeatingType(heatingType);
            home.get().setLocation(location);
            homeRepository.save(home.get());
            return "Updated!";
        }else{
            return "Not Found.";
        }
    }

    //Quote REST
    /*
    To get a new Quote, send a GET request, with User ID and the Home ID as a parameter.
    Build the Quote object from the Quote manager
     */
}
