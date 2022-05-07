package com.revature.bankingProject.daos;

import java.io.*;
import java.sql.*;
import com.revature.bankingProject.models.BankCustomer;
import com.revature.bankingProject.util.ConnectionFactory;

public class BankCustomerDao implements GenericCrudable<BankCustomer> {

    @Override
    public  BankCustomer create(BankCustomer newCustomer) {
        System.out.println("Here is the newCustomer as it enters our DAO layer: "+ newCustomer); // What happens here? Java knows to invoke the toString() method when printing the object to the terminal

        try(Connection conn = ConnectionFactory.getInstance().getConnection();) {

            // NEVER EVER EVER EVER EVER concatenate or directly use these strings inside of the sql statement
            // String sql = "insert into bank_customers value (" + newTrainer.getFname() + "," + newTrainer.getLname();

            // The commented out sql String is using default for auto-generating the ID ifyou used serial
            // String sql = "insert into Customer values (default, ?, ?, ?, ?, ?)"; // incomplete sql statement, with default if not specifiying columns
            String sql = "insert into bank_customers (fname, lname, email, password, age) values (?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            System.out.println(newCustomer.getFname());
            System.out.println(newCustomer.getLname());

            // 1-indexed, so first ? starts are 1
            ps.setString(1, newCustomer.getFname());
            ps.setString(2, newCustomer.getLname());
            ps.setString(3, newCustomer.getEmail());
            ps.setString(4, newCustomer.getPassword());
            ps.setInt(5, newCustomer.getAge());

            int checkInsert = ps.executeUpdate();

            if(checkInsert == 0){
                throw new RuntimeException();
            }

        } catch (SQLException | RuntimeException e){
            e.printStackTrace();
            return null;
        }
        return newCustomer;
    }

    @Override
    public BankCustomer[] findAll() throws IOException {

        // making an array of BankCustomer classes, and setting it to a max size of 10
        BankCustomer[] bankCustomer1 = new BankCustomer[10];
        // declaring index variable as an int and initialization with he values of 0
        int index = 0; // we want to keep track of where we are placing each trainer from the file into the array

        // TODO: we trying something here and passing an argument???
        try (Connection conn = ConnectionFactory.getInstance().getConnection();) { // try with resoruces, because Connection extends the interface Auto-Closeable

            String sql = "select * from bank_customers";
            Statement s = conn.createStatement();

            // conn.createStatement().executeQuery("select * from trainer"); fine but generally not used
            // TODO: Hey why are we using the sql variable string here?
            ResultSet rs =s.executeQuery(sql);

            while (rs.next()) { // the last line of the file is null
                BankCustomer bankCustomer = new BankCustomer();

                bankCustomer.setFname(rs.getString("fname")); // this column label MUST MATCH THE DB
                bankCustomer.setLname(rs.getString("lname"));
                bankCustomer.setPassword(rs.getString("password"));
                bankCustomer.setEmail(rs.getString("email"));
                bankCustomer.setAge(rs.getInt("age"));
                System.out.println("Inserted bank customers into index" + index);
                bankCustomer1[index] = bankCustomer;
                index++; // increment the index by 1, must occur after the trainer[index] re-assignment
                System.out.println("Going to the next line for our following index.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }



        System.out.println("Returning bank customers information to user.");
        return bankCustomer1;
    }

    @Override
    public BankCustomer findById(String id) {


        try(Connection conn = ConnectionFactory.getInstance().getConnection();){

            String sql = "select * from bank_customers where id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(id)); // Wrapper class example

            ResultSet rs = ps.executeQuery(); // remember dql, bc selects are the keywords

            BankCustomer bankCustomer = new BankCustomer();

            bankCustomer.setFname(rs.getString("fname")); // this column label MUST MATCH THE DB
            bankCustomer.setLname(rs.getString("lname"));
            bankCustomer.setPassword(rs.getString("password"));
            bankCustomer.setEmail(rs.getString("email"));
            bankCustomer.setAge(rs.getInt("age"));
            return bankCustomer;

        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public boolean update(BankCustomer updatedObj) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    public void checkEmail(String email) {
        String sql = "select email from customer where email = " + email; // issues with SQL injection
    }
}
