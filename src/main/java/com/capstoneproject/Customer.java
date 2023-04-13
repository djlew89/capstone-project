package com.capstoneproject;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * @Author Dan Lewis
 * @Date 2023-02-24
 * Descriptive class for a Customer
 */
@Entity(name = "customer")
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    //    /**
    //     * Customer's Policies in a list
    //     */
    //    private final List<Policy> policyList = new LinkedList<>();
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

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "ID")
    private User user;

    @OneToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "ID")
    private Driver driver;

    /**
     * getter
     *
     * @return String
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * setter
     *
     * @param firstName a customers first name.
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * getter
     *
     * @return String
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * setter
     *
     * @param lastName a customers last name.
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * getter
     *
     * @return LocalDate
     */
    public LocalDate getDob()
    {
        return dob;
    }

    /**
     * setter
     *
     * @param dob a customers date of birth.
     */
    public void setDob(LocalDate dob)
    {
        this.dob = dob;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    //    /**
    //     * getter
    //     *
    //     * @return List<Policy>
    //     */
    //    public List<Policy> getPolicyList()
    //    {
    //        return policyList;
    //    }

    //    /**
    //     * Adds a policy to the Customer's policy list
    //     *
    //     * @param policy the policy.
    //     */
    //    public void addPolicy(Policy policy)
    //    {
    //        this.policyList.add(policy);
    //    }
    //    public Integer getId() {
    //        return id;
    //    }
}
