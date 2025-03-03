/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

/**
 *
 * @author ongji
 */
import utility.ScreenUI;
import utility.MessageUI;
import java.util.Scanner;


public class MainMenuUI {
    private static String[] mainMenuOptions = {"Login as a Guest", "Login as Job Seeker", "Login as Employer", "Exit"};
    Scanner scanner = new Scanner(System.in);
    ScreenUI screenUI = new ScreenUI();
    MessageUI messageUI = new MessageUI();
    
    public int getMainMenu(){
        int input = -1;
        screenUI.clearScreen();
        System.out.println("=== Internship Application System ===\n");

        for (int i = 0; i < mainMenuOptions.length; i++) {
            System.out.println(i+1 + ". " + mainMenuOptions[i]);
        }
        
        System.out.print("\nSelect an option: ");
        String userInput = scanner.nextLine().trim();
        
        try{
            input = Integer.parseInt(userInput);
            
            if(input >= 1 && input <= mainMenuOptions.length){
                return input;
            }else{
                messageUI.message_error_InputOutOfRange(mainMenuOptions.length);
            }
            
        }catch(NumberFormatException e){
            messageUI.message_error_NumberFormatException();
        }
        
        return input;
    }
}
