package com.revature.bankingProject.menu;

import com.revature.bankingProject.services.BankServices;
import java.io.BufferedReader;
import static com.revature.bankingProject.util.AppState.shutdown;

public class WelcomeMenu extends Menu{

    private BankServices bankServices;

    public WelcomeMenu(BufferedReader terminalReader, BankServices bankServices) {
        super("Welcome Menu", "/welcome", terminalReader);
        this.bankServices = bankServices;
    }

    @Override
    public void render() throws Exception {
        // String is the datatype we are declaring
        // welcome is the variable being declared as a String
        // the value is being set to Welcome To the Bank! in the String pool
        String welcome = "\n\nWelcome to the Alpha Bank!\n";
        String option1 = "1) Login";
        String option2 = "2) Register";
        String option3 = "3) View/Create Account Statement ";
        String option4 = "4) View all Customers";
        String option5 = new String("5) Exit the Alpha Bank"); // This is the same as ""

        System.out.printf("%s \n %s \n %s \n %s \n %s \n %s", welcome, option1, option2, option3, option4, option5).println();
        System.out.print("\n Select number from above\n >");

        // taking input from  the read line  in terminalReader as a String! BufferedReader is always reading STRING
        String userSelection = terminalReader.readLine();


        switch (userSelection) {
            case "1":
                System.out.println("User has selected login...");
                break;
            case "2":
                System.out.println("User has selected register...");
                RegisterMenu registerMenu = new RegisterMenu(terminalReader);
                //registerMenu.render();
                // register(); // ctrl + left-click
                break;
            case "3":
                System.out.println("User has selected view/create pokemon...");
                // pokemonInput(); // ctrl + left-click
                break;
            case "4":
                System.out.println("User has selected view customer...");
                bankServices.readBankCustomer();
                break;
            case "5":
                System.out.println("User has selected exit...");
                // shutdown the application
                shutdown();
                break;
            default: // why have a default? catch all if input doesn't match any case above.
                System.out.println("No valid user input provide");
                break;
        }
    }
}
