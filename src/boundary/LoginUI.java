/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;


/**
 *
 * @author ongji
 */

import java.util.Scanner;
import entity.Account;

public class LoginUI {
    private Scanner scanner = new Scanner(System.in);
    private Account account = new Account();
    
    public String getLoginUI(String userType){
        System.out.println("\nSign In as " + userType);
        System.out.println("===================");
        
        System.out.print("Email Address: ");
        String email = scanner.nextLine();
        
        System.out.print("Password: ");
        String password = scanner.nextLine();
        
        String account_ID = account.isValidLogin(email, password, userType);
        
        return account_ID;
    }
//    public static void main(String[] args){
//        LoginUI test = new LoginUI();
//        test.getLoginUI("Employer");
//        
//    }
}