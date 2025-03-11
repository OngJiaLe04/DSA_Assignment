/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;


/**
 *
 * @author ongji
 */

import utility.ScreenUI;
import boundary.EmployerProfileUI;

public class EmployerProfileControl {
    ScreenUI screenUI = new ScreenUI();
    EmployerProfileUI employerProfileUI = new EmployerProfileUI();
    
    public void runEmployerProfile(String account_ID){
        employerProfileUI.getEmployerProfileUI(account_ID);
    }
}
