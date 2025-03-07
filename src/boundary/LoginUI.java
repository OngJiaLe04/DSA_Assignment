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
    
    public boolean getLoginUI(String user){
        System.out.println("Sign In as " + user);
        System.out.println("===================");
        
        System.out.print("Email Address: ");
        String email = scanner.nextLine();
        
        System.out.print("Password: ");
        String password = scanner.nextLine();
        
        boolean success = account.isValidLogin(email, password);
        return success;
    }
//    public static void main(String[] args){
//        LoginUI test = new LoginUI();
//        test.getLoginUI("Employer");
//        
//    }
}