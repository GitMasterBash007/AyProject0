package com.revature.bankingProject.menu;



import com.revature.bankingProject.models.BankCustomer;
import com.revature.bankingProject.services.BankServices;


import java.io.BufferedReader;
import java.util.Scanner;


// Inheritance from menu abstract class :D another pillar of OOP
public class RegisterMenu extends Menu{

    private BankServices bankCustomerService = new BankServices();

    public RegisterMenu(BufferedReader terminalReader) {
        super("Register", "/register", terminalReader);
    }

    // Polymorphism  Another pillar of OOP for the same thing doing different things
    // This is overriding a method
    @Override
    public void render() throws Exception {
        // TODO: Implement the customer
        System.out.println("What is your full name?");
        String fullName = terminalReader.readLine();

        System.out.println("What is your email?");
        String email = terminalReader.readLine();

        System.out.println("What is your password?");
        String password = terminalReader.readLine();

        System.out.println("Re-enter password");
        String passwordCheck = terminalReader.readLine();

        System.out.println("age?");
        Scanner scanner= new Scanner(System.in);
        int age = scanner.nextInt();


        // Breaking or splitting the String fullName into a String array by " " spaces
        String[] nameArray = fullName.split(" ");
        String fname = nameArray[0];
        String lname = nameArray[1];


        //if the passwords doesn't match then it will  print that the passwords don't match
        if (!password.equals(passwordCheck)) { // password != passwordCheck
            System.out.println("Passwords don't match");
            return; // why return??? Control Flow, this breaks this method and returns us to main
        }

        //  Initialization a new customer object in memory
        BankCustomer newCustomer = new BankCustomer(fname, lname, email, password, age);
        System.out.println("Here is the Alpha Bank's customer that was provided by the user: " + newCustomer);
        bankCustomerService.registerBankCustomer(newCustomer);
    }
}
