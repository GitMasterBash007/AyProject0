package com.revature.bankingProject.util;

import com.revature.bankingProject.menu.RegisterMenu;
import com.revature.bankingProject.menu.WelcomeMenu;
import com.revature.bankingProject.services.BankServices;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private static boolean isRunning;
    private  WelcomeMenu welcomeMenu;

    private RegisterMenu registerMenu;
    //we need private final MenuRouter router;

    public AppState() {
        System.out.println("2. Generating instance of AppState.");
        isRunning = true;
        BufferedReader terminalReader = new BufferedReader(new InputStreamReader(System.in));
        BankServices bankServices = new BankServices();

       
        this.welcomeMenu = new WelcomeMenu(terminalReader, bankServices);
        this.registerMenu = new RegisterMenu(terminalReader);
    }
    public void startup(){
        try {
            while(isRunning) {
                System.out.println("Application successfully started");

                welcomeMenu.render(); // comment in and out based on what you want to use
                registerMenu.render();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void shutdown(){
        isRunning = false;
        System.out.println("Application shutting down...");
    }

}
