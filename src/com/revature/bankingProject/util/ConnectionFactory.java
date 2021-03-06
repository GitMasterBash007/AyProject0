package com.revature.bankingProject.util;


import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static final ConnectionFactory connectionFactory = new ConnectionFactory(); // instead Eager Singleton
    private Properties prop = new Properties();

    // specifically a singleton bc of the private constructor
    private ConnectionFactory(){
        try {
            prop.load(new FileReader("resources/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static {
        // Reflections are just viewing a class
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Need some way for out ConnectionFactory to be obtained by other classes
    public static ConnectionFactory getInstance(){
        return connectionFactory;
    }

    // Once we getInstance() we are able to execute getConnection to return a Connection to our database
    public Connection getConnection() {

        Connection conn = null;

        // String url = "jdbc:postgresql://localhost:5432/postgres"; // default url will connect you to public
        // TODO: WE NEED TO FIX THIS
        // make sure currentSchema name lowercase
//        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=pokedex"; // default url will connect you to public
//        String user = "postgres";
//        String password = "password";

        try {
            conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
