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
import utility.BackToPreviousException;
import utility.MessageUI;
import utility.ScreenUI;

public class AccountRegisterUI {
    private Scanner scanner = new Scanner(System.in);
    Account account = new Account();
    MessageUI messageUI = new MessageUI();
    ScreenUI screenUI = new ScreenUI();
    
    public Account getAccountRegisterUI(String userType){
        boolean isValidEmail = false;
        boolean isDuplicateEmail = true;
        boolean isValidPassword = false;
        String email = "";
        String password = "";
    
        System.out.println("Register an Account");
        System.out.println("=======================");
        
        try{
            while(!isValidEmail && isDuplicateEmail){
                System.out.print("Email Address: ");
                email = scanner.nextLine();
                screenUI.backToPrevious(email);

                isValidEmail = account.isValidEmail(email);
                if(!isValidEmail){
                    messageUI.message_error_invalidEmail();
                }else{
                    isDuplicateEmail = account.isDupulicateEmail(email);
                    if(isDuplicateEmail){
                        isValidEmail = false;
                        messageUI.message_error_duplicateEmail();
                    }
                }
            }
        
            while(isValidEmail && !isDuplicateEmail && !isValidPassword){
                System.out.print("Password: ");
                password = scanner.nextLine();
                screenUI.backToPrevious(password);
                
                isValidPassword = account.isValidPassword(password);
                if(!isValidPassword){
                    messageUI.message_error_invalidPassword();
                }
            }
            
        }catch(BackToPreviousException e){
            messageUI.message_information_backToPrevious("Registration");
            return null;
        }
        
        if(isValidEmail && !isDuplicateEmail && isValidPassword){
            account.setEmail(email);
            account.setPassword(password);
            account.setUserType(userType);
            
            return account;
        }else{
            return null;
        }
    }
}
