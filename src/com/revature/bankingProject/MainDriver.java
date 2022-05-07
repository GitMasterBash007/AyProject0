package com.revature.bankingProject;

import com.revature.bankingProject.util.AppState;

import java.sql.SQLOutput;

public class MainDriver {

    public static void main(String[] args){

        System.out.println("1. AppState instantiated");
        AppState appState = new AppState();

        System.out.println("Banking Application starting up....");
        appState.startup();
    }
}