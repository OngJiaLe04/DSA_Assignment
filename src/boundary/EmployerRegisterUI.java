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
import dao.AccountDAO;
import utility.MessageUI;

public class EmployerRegisterUI {
    private Scanner scanner = new Scanner(System.in);
    MessageUI messageUI = new MessageUI();
    Employer employer = new Employer();
    
    public Employer getEmployerRegisterUI(Account account){
        String business_phoneNo = "";
        boolean isValidPhoneNo = false;
    
        System.out.println("Fill in the details");
        System.out.println("=======================");
        System.out.println("We need some details about your business to verify your account. We won't share your details with anyone.");
        System.out.println("\n");
        
        System.out.println("Your details:");
        System.out.println("-------------");
        
        System.out.println("Email Address: " + account.getEmail());
        
        System.out.print("Full Name: ");
        String employer_name = scanner.nextLine();
        
        System.out.println("\n\nBusiness Details:");
        System.out.println("-----------------");
        System.out.print("Business Name: ");
        String business_name = scanner.nextLine();
        
        System.out.print("Business Address: ");
        String business_address = scanner.nextLine();
        
        do{
            System.out.print("Phone Number:| Malaysia | +60 " );
            business_phoneNo = scanner.nextLine();
            isValidPhoneNo = employer.isValidPhoneNumber(business_phoneNo);
            
            if(!isValidPhoneNo){
                messageUI.message_error_invalidPhoneNo();
            }
        }while(!isValidPhoneNo);
        
        String id_generated = employer.generateEmployerID();
        employer.setEmployer_ID(id_generated);
        employer.setAccount(account);
        employer.setEmployer_name(employer_name);
        employer.setCompany_name(business_name);
        employer.setCompany_address(business_address);
        employer.setPhoneNumber(business_phoneNo);
        
        return employer;

    }
    
//    public static void main(String[] args){
//        EmployerRegisterUI test = new EmployerRegisterUI();
//        Account accountTest = new Account();
//        accountTest = test.getEmployerRegisterUI();
//    }
}
