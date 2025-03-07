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

public class MainMenuControl {
    MainMenuUI mainMenuUI = new MainMenuUI();
    ScreenUI screenUI = new ScreenUI();
    
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
                    System.out.println("Logging as Employer...");
                    screenUI.systemPause();
                    break;
                case 4:
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
