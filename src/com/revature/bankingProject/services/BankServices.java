package com.revature.bankingProject.services;

import com.revature.bankingProject.daos.BankCustomerDao;
import com.revature.bankingProject.models.BankCustomer;

import java.io.IOException;

public class BankServices {


        private BankCustomerDao bankCustomerDao = new BankCustomerDao();

        public void readBankCustomer(){
            System.out.println("Begin reading Alpha Bank Customers in our file database.");
            BankCustomer[] customer;

            try {

                customer = bankCustomerDao.findAll();
                System.out.println("All customers have been found here are the results: \n");
//
                // new keyword allows for the construction (or more technically the instantiation of a Trainer class with a No-Arg Constructor)
                // new Trainer() is instantiating a new trainer object via the No-Args Constructor
                BankCustomer bankCustomer = new BankCustomer();

                // TODO: Why is this declared as an Object and not a Trainer??
                Object bankCustomer1 = new BankCustomer("Charles", "Jester", "cj@mail.com", "p", '1');

                BankCustomer iCanNameThisWhatEverTheHeckoIWant = new BankCustomer();
                System.out.println(iCanNameThisWhatEverTheHeckoIWant.getLname());

                System.out.println(" ----------THIS THINGGGGGGGG--------------- ");
                System.out.println(bankCustomer1.toString());
                System.out.println("-------------------------");
                // the (Trainer) is casting the Object trainer1 in java's Heap Memory to view as a Trainer object instead
                System.out.println(((BankCustomer) bankCustomer1).getFname());

                // forEach
                for(Object t:customer ){
                    if(t != null) {
                        System.out.println((BankCustomer) t); // trainer indicates a single element in the trainers array
                    }
                }

            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }
        }



        // TODO: Implement me to check that the email is not already in our database.
        // public this allows the use of this method anywhere there is a TrainerServices object or within the class itself
        // boolean - it's a true or false value in java and it's specifying the return type
        // validateEmailNotUse() this is a method what we want to call to the DAO to check if the email is already in use
        // String email is the defined parameters for arguments required when invoking this method
        public boolean validateEmailNotUsed(String email){
            bankCustomerDao.checkEmail(email);
            return false;
        }

        public boolean registerBankCustomer(BankCustomer newBankCustomer){
            System.out.println("Bank Customer trying to be registered: " + newBankCustomer);
            if(!validateTrainerInput(newBankCustomer)){ // checking if false
                System.out.println("User was not validated");
                // TODO: throw - what's this keyword?
                throw new RuntimeException();
            }

            // TODO: Will implement with JDBC (connecting to our database)
            validateEmailNotUsed(newBankCustomer.getEmail());

            BankCustomer persistedTrainer = bankCustomerDao.create(newBankCustomer);

            if(persistedTrainer == null){
                throw new RuntimeException();
            }
            System.out.println("BankCustomer has been persisted: " + newBankCustomer);
            return true;
        }

        private boolean validateTrainerInput(BankCustomer newBankCustomer) {
            System.out.println("Validating Trainer: " + newBankCustomer);
            if(newBankCustomer == null) return false;
            if(newBankCustomer.getFname() == null || newBankCustomer.getFname().trim().equals("")) return false;
            if(newBankCustomer.getLname() == null || newBankCustomer.getLname().trim().equals("")) return false;
            if(newBankCustomer.getEmail() == null || newBankCustomer.getEmail().trim().equals("")) return false;
            if(newBankCustomer.getPassword() == null || newBankCustomer.getPassword().trim().equals("")) return false;
            return newBankCustomer.getAge() != 0 || newBankCustomer.getAge() != 0;
        }
    }

