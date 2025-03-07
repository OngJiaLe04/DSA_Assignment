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
import entity.Employer;
import java.util.Scanner;

public class EmployerRegisterUI {
    private Scanner scanner = new Scanner(System.in);
    Employer employer = new Employer();
    
    public Employer getEmployerRegisterUI(){
        System.out.println("Fill in the details");
        System.out.println("=======================");
        System.out.println("We need some details about your business to verify your account. We won't share your details with anyone.");
        System.out.println("\n");
        
        System.out.println("Your details:");
        System.out.println("-------------");
        
        System.out.print("Email Address: ddddddddddddddddddd");
        
        return employer;

    }
    
//    public static void main(String[] args){
//        EmployerRegisterUI test = new EmployerRegisterUI();
//        Account accountTest = new Account();
//        accountTest = test.getEmployerRegisterUI();
//    }
}
