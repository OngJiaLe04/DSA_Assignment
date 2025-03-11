/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;


/**
 *
 * @author ongji
 */

import boundary.EmployerMenuUI;
import boundary.MainMenuUI;
import utility.ScreenUI;
import control.EmployerProfileControl;

public class EmployerMenuControl {
    MainMenuUI mainMenuUI = new MainMenuUI();
    ScreenUI screenUI = new ScreenUI();
    
    EmployerMenuUI employerMenuUI = new EmployerMenuUI();
    EmployerProfileControl emplloyerProfileUI = new EmployerProfileControl();
    
    public void runEmployerMenu(String account_ID){
        int userInput = 0;
        boolean running = true;
        do{
            userInput = employerMenuUI.getEmployerMenuUI();
            switch(userInput){
                case 1:
                    screenUI.clearScreen();
                    emplloyerProfileUI.runEmployerProfile(account_ID);
                    screenUI.systemPause();
                    break;
                case 2:
                    screenUI.clearScreen();
                    System.out.println("Edit the company profile");
                    screenUI.systemPause();
                    break;
                case 3:
                    System.out.println("logout");
            }
        }while(running);
    }
}
