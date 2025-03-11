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
import utility.ScreenUI;

public class LoginControl {
    LoginUI loginUI = new LoginUI();
    MessageUI messageUI = new MessageUI();
    ScreenUI screenUI = new ScreenUI();
    String account_ID = null;
    
    public String runLogin(String userType){
        do{ 
            account_ID = loginUI.getLoginUI(userType);
            if(account_ID == null){
                messageUI.message_error_loginFailed();
                screenUI.clearScreen();
            }
        }while(account_ID == null);
        
        messageUI.message_success_loginAccount();
        return account_ID;
    }
    
//    public static void main(String[] args){
//        LoginControl loginControl = new LoginControl();
//        loginControl.runLogin("Employer");
//    }
}
