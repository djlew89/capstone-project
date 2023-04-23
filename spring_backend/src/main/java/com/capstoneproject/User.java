package com.capstoneproject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

/**
 * User Entity model. This object will be used by Hibernate to create a table in the database
 * <p>
 * Data Access Object
 *
 * @author Julia Parewick
 */
@Entity(name = "user")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String email;
    private String password;

    /**
     * Customer's First Name
     */
    private String firstName;
    /**
     * Customer's Last Name
     */
    private String lastName;
    /**
     * Customer's DOB as YYYY-MM-DD
     */
    private LocalDate dob;

    private String address;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public LocalDate getDob()
    {
        return dob;
    }

    public void setDob(LocalDate dob)
    {
        this.dob = dob;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

}
