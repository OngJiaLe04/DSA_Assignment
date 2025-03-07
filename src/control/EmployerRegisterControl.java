/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author ongji
 */

import boundary.EmployerRegisterUI;
import entity.Account;
import entity.Employer;
import utility.ScreenUI;

public class EmployerRegisterControl {
    EmployerRegisterUI employerRegister_UI = new EmployerRegisterUI();
    Account account = new Account();
    Employer employer = new Employer();
    ScreenUI screenUI = new ScreenUI();
    
    public void runEmployerRegister(){
        employer = employerRegister_UI.getEmployerRegisterUI();
    }
    
    public static void main(String[] args){
        EmployerRegisterControl testing = new EmployerRegisterControl();
        testing.runEmployerRegister();
    }
}
