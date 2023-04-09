package com.capstoneproject;

import jakarta.persistence.*;

/**
 * User Entity model. This object will be used by Hibernate to create a table in the database
 *
 * Data Access Object
 *
 * @author Julia Parewick
 */
@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String email;
    private String password;

    @OneToOne
    @JoinColumn(name="customer_id", referencedColumnName = "ID")
    private Customer customer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
