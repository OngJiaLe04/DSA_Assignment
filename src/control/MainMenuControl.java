/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author ongji
 */

import adt.ArrayList;
import adt.ListInterface;
import boundary.MainMenuUI;
import utility.ScreenUI;
import control.AccountRegisterControl;
import control.LoginControl;
import control.EmployerRegisterControl;
import control.EmployerMenuControl;
import entity.Account;

public class MainMenuControl {
    MainMenuUI mainMenuUI = new MainMenuUI();
    ScreenUI screenUI = new ScreenUI();
    
    AccountRegisterControl accountRegisterControl = new AccountRegisterControl();
    EmployerRegisterControl employerRegisterControl = new EmployerRegisterControl();
    EmployerMenuControl employerMenuControl = new EmployerMenuControl();
    LoginControl loginControl = new LoginControl();
    
    Account account = new Account();
    
    public MainMenuControl(){
        // retrieve file?
    }
    
    public void runMainMenu(){
        int userInput = 0;
        boolean running = true;
        do{
            userInput = mainMenuUI.getMainMenu();
            switch(userInput){
                case 1:
                    screenUI.clearScreen();
                    System.out.println("Logging as Guest...");
                    screenUI.systemPause();
                    break;
                case 2:
                    screenUI.clearScreen();
                    System.out.println("Logging as Job Seeker...");
                    screenUI.systemPause();
                    break;
                case 3:
                    screenUI.clearScreen();
                    String account_ID = loginControl.runLogin("Employer");
                    if(account_ID != null){
                        screenUI.clearScreen();
                        employerMenuControl.runEmployerMenu(account_ID);
                    }
                    
                    screenUI.systemPause();
                    break;
                case 4:
                    screenUI.clearScreen();
                    System.out.println("Register as Job Seeker...");
                    screenUI.systemPause();
                    break;
                    
                case 5:
                    screenUI.clearScreen();
                    account = accountRegisterControl.runAccountRegister("Employer");
                    screenUI.clearScreen();
                    if(account != null){
                        employerRegisterControl.runEmployerRegister(account);
                        screenUI.systemPause();
                    }
                    
                    break;
                    
                case 6:
                    System.out.println("System Closed...");
                    running = false;
                    break;
            }
        }while(running);
    }
    
    public static void main (String[] args){
        MainMenuControl mainMenuControl = new MainMenuControl();
        mainMenuControl.runMainMenu();
        
    }
}
