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
import utility.MessageUI;
import utility.ScreenUI;

public class EmployerMenuUI {
    private static String[] employerMenuOptions = {"My Profile", "Edit the Profile", "Log out"};
    Scanner scanner = new Scanner(System.in);
    ScreenUI screenUI = new ScreenUI();
    MessageUI messageUI = new MessageUI();
    
    public int getEmployerMenuUI(){
        int input = -1;
        System.out.println("=== Employer Menu System ===\n");
        
        for(int i = 0; i < employerMenuOptions.length; i++){
            System.out.println(i+1 + ". " + employerMenuOptions[i]);
        }
        
        System.out.print("\nSelect an option: ");
        String userInput = scanner.nextLine().trim();
        
        try{
            input = Integer.parseInt(userInput);
            
            if(input >= 1 && input <= employerMenuOptions.length){
                return input;
            }else{
                messageUI.message_error_InputOutOfRange(employerMenuOptions.length);
            }
            
        }catch(NumberFormatException e){
            messageUI.message_error_NumberFormatException();
        }
        
        return input;
    }
}
