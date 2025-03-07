/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

/**
 *
 * @author ongji
 */

import entity.Account;
import java.util.Scanner;
import utility.MessageUI;

public class AccountRegisterUI {
    private Scanner scanner = new Scanner(System.in);
    Account account = new Account();
    MessageUI messageUI = new MessageUI();
    
    boolean isValidEmail = false;
    boolean isValidPassword = false;
    String email = "";
    String password = "";
    
    public Account getAccountRegisterUI(){
        System.out.println("Register an Account");
        System.out.println("=======================");
        
        while(!isValidEmail){
            System.out.print("Email Address: ");
            email = scanner.nextLine();
            isValidEmail = account.isValidEmail(email);
            if(!isValidEmail){
                messageUI.message_error_invalidEmail();
            }
        }
        
        while(isValidEmail && !isValidPassword){
            System.out.print("Password: ");
            password = scanner.nextLine();
            isValidPassword = account.isValidPassword(password);
            if(!isValidPassword){
                messageUI.message_error_invalidPassword();
            }
        }
        
        if(isValidEmail && isValidPassword){
            account.setEmail(email);
            account.setPassword(password);
            account.setUserType("Test");
            
            return account;
        }
        
        return null;
    }
}
