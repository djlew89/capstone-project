package com.capstoneproject.POJOS;//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//
///**
// * The book database managing class.
// * <p>
// * Stores all queries for database manipulation.
// *
// * @Author Mason Seward
// * @Date 2023-02-23
// */
//public class InsuranceDatabaseManager
//{
//    /**
//     * Load library.
//     *
//     * @return the library
//     */
//    public static Library loadLibrary()
//    {
//        Connection connection = DBConfiguration.establishDBConnection();
//        Library library = new Library();
//
//        return library;
//    }
//
//    //TODO - Finish method
//    //    private static void connectRelationships(Connection connection)
//    //    {
//    //        try
//    //        {
//    //            Statement statement = connection.createStatement();
//    //            //TODO - Finish below code
//    //            //String sql = "SELECT * FROM " +
//    //            ResultSet resultSet = statement.executeQuery(sql);
//    //
//    //            //Create the objects from the result set and add them to the list
//    //            while (resultSet.next())
//    //            {
//    //            }
//    //            statement.close();
//    //        }
//    //        catch (SQLException sqlException)
//    //        {
//    //            sqlException.printStackTrace();
//    //        }
//    //    }
//
//    protected static void addUser(Connection connection, Library library, String firstName, String lastName, int age,
//                                  int numberOfAccidents, String address) throws SQLException
//    {
//        // Create the new driver object
//        Driver newDriver = new Driver(firstName, lastName, age, numberOfAccidents, address);
//
//
//        // Insert driver data into database
//        String sql = "INSERT INTO "
//                + DBConfiguration.DB_INSURANCE_DRIVER_TABLE_NAME
//                + "(firstName, lastName, age, numberOfAccidents, address) "
//                + "VALUES (?, ?, ?, ?, ?)";
//
//        // Create prepared statement for database manipulation and set values
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setString(1, firstName);
//        statement.setString(2, lastName);
//        statement.setInt(3, age);
//        statement.setInt(4, numberOfAccidents);
//        statement.setString(5, address);
//        statement.execute();
//        connection.close();
//    }
//}
