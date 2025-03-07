/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

/**
 *
 * @author ongji
 */
import java.util.Scanner;

public class MessageUI {
    static Scanner pause = new Scanner(System.in);
    
    private static void message_warning_TryAgain(){
        System.out.println("Press Enter to try again...");
        pause.nextLine();
    }
    
    private static void message_success_Continue(){
        System.out.println("Press Enter To Continue");
        pause.nextLine();
    }
    
    public static void message_error_InputOutOfRange(int max_range){
        System.out.println("Invalid Choice. Please enter a number between 1 to " + max_range + "..");
        message_warning_TryAgain();
    }
    
    public static void message_error_NumberFormatException(){
        System.out.println("Invalid Input. Please enter a number.");
        message_warning_TryAgain();
    }
    
    public static void message_error_invalidEmail(){
        System.out.println("Invalid Format. Please enter a valid email (user@example.com).");
        message_warning_TryAgain();
    }
    
    public static void message_error_invalidPassword(){
        System.out.println("Invalid Format. Please enter a valid password (StrongPass1!).");
        message_warning_TryAgain();
    }
    
    public static void message_error_loginFailed(){
        System.out.println("Login Fail! Invalid Email or Password...");
        message_warning_TryAgain();
    }
    
    public static void message_error_createAccount(){
        System.out.println("The account cannot be created");
        message_warning_TryAgain();
        
    }
    
    public static void message_success_createAccount(){
        System.out.println("Congratulations! The account has been created");
        message_success_Continue();
    }
    
}
