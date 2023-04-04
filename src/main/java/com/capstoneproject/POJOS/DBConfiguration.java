package com.capstoneproject.POJOS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The DBConfiguration class stores all configuration variables for accessing and manipulating the database
 *
 * @Author Mason Seward
 * @Date 2023-02-23
 */
public class DBConfiguration
{

    protected static final String MARIA_DB_DRIVER_NAME = "org.mariadb.jdbc.Driver";
    protected static final String DB_URL = "jdbc:mariadb://localhost:3308";
    protected static final String DB_AUTH = "root";
    protected static final String DB_INSURANCE_DRIVER_TABLE_NAME = "driver";
    protected static final String DB_INSURANCE = "/taylorsInsurance";
    protected static final String DB_INSURANCE_DRIVER_TABLE_DRIVER_FIRST_NAME = "firstName";
    protected static final String DB_INSURANCE_DRIVER_TABLE_DRIVER_LAST_NAME = "lastName";
    protected static final String DB_INSURANCE_DRIVER_TABLE_DRIVER_AGE = "age";
    protected static final String DB_INSURANCE_DRIVER_TABLE_DRIVER_ACCIDENTS = "numberOfAccidents";
    protected static final String DB_INSURANCE_DRIVER_TABLE_DRIVER_ADDRESS = "address";

    /**
     * Register a driver using Java's Class.forName() method
     * to dynamically load the driver's class file into memory
     * which automatically registers it.
     */
    public static void doClassForNameRegistration()
    {
        try
        {
            Class.forName(DBConfiguration.MARIA_DB_DRIVER_NAME);
            System.out.println("DB Driver Registration using Class.forName() worked! (Option 1)");
        }
        catch (ClassNotFoundException ex)
        {
            System.err.println("ClassNotFoundException: unable to load MariaDB driver class!");
            System.err.println("Driver name: " + DBConfiguration.MARIA_DB_DRIVER_NAME);
            System.exit(1);
        }
    }

    /**
     * Register the driver using registerDriver() method. This is the 2nd and less preferred option
     * noted in the Unit 2 notes.
     */
//    public static void doRegisterDriverMethodRegistration()
//    {
//        try
//        {
//            Driver myDriver = new org.mariadb.jdbc.Driver();
//            DriverManager.registerDriver(myDriver);
//            System.out.println("DB Driver Registration using registerDriver() worked! (Option 2)");
//        }
//        catch (SQLException e)
//        {
//            System.err.println("SQL Exception: trying to register MariaDB Driver");
//            e.printStackTrace();
//        }
//    }

    public static Connection establishDBConnection()
    {
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(DBConfiguration.DB_URL + DBConfiguration.DB_INSURANCE, DBConfiguration.DB_AUTH, DBConfiguration.DB_AUTH);
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }

        return connection;
    }
}
