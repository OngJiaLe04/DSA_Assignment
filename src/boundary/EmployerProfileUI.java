/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;



/**
 *
 * @author ongji
 */

import dao.EmployerDAO;
import entity.Employer;
import utility.MessageUI;
import utility.ScreenUI;

public class EmployerProfileUI {
    Employer employer = new Employer();
    EmployerDAO employerDAO = new EmployerDAO();
    
    MessageUI messageUI = new MessageUI();
    ScreenUI screenUI = new ScreenUI();
    
    public void getEmployerProfileUI(String account_ID){
        
        employer = employerDAO.search_employer_by_account_ID(account_ID);
        if(employer != null){
            System.out.println("\n=== User Profile ===");
            System.out.println("======================");
            System.out.println("\n");
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.printf("| %-20s : %-60s |\n", "Your Name", employer.getEmployer_name());
            System.out.println("|-------------------------------------------------------------------------------------|");
            System.out.printf("| %-20s : %-60s |\n", "Employer ID", employer.getEmployer_ID());
            System.out.printf("| %-20s : %-60s |\n", "Employer Name", employer.getEmployer_name());
            System.out.printf("| %-20s : %-60s |\n", "Business Name", employer.getCompany_name());
            System.out.printf("| %-20s : %-60s |\n", "Business Address", employer.getCompany_address());
            System.out.printf("| %-20s : +60 %-56s |\n", "Business Phone No", employer.getPhoneNumber());
            System.out.println("---------------------------------------------------------------------------------------\n");
            
            screenUI.systemPause();
            System.out.println("\nOptions:");
            System.out.println("1. Edit Profile");
            System.out.println("2. Go Back to Employer Menu");
            System.out.print("Choose an option: ");
        }else{
            messageUI.message_error_profileNotFound();
        }
    }
    
    public static void main(String[] args){
        EmployerProfileUI testing = new EmployerProfileUI();
        testing.getEmployerProfileUI("A0006");
    }
}
