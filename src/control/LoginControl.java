/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author ongji
 */

import boundary.LoginUI;
import utility.MessageUI;

public class LoginControl {
    LoginUI loginUI = new LoginUI();
    MessageUI messageUI = new MessageUI();
    boolean login_success = false;
    
    public void runLogin(){
        do{ 
            login_success = loginUI.getLoginUI("Employer");
            if(!login_success){
                messageUI.message_error_loginFailed();
            }
        }while(!login_success);
        
        System.out.println("Welcome");
    }
    
    public static void main(String[] args){
        LoginControl loginControl = new LoginControl();
        loginControl.runLogin();
    }
}
