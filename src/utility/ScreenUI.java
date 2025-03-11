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

public class ScreenUI {
    static Scanner pause = new Scanner(System.in);
    
    public static void clearScreen(){   
        try{
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void systemPause(){
        System.out.println("Press Any Key To Continue...");
        pause.nextLine();
    }
    
    public static void backToPrevious(String input) {
        if (input.equalsIgnoreCase("back")) {
//            System.out.println("\nReturning to Main Menu...");
            throw new BackToPreviousException(); // Custom exception to stop registration
        }
    }

}
