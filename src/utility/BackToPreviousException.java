/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

/**
 *
 * @author ongji
 */
public class BackToPreviousException extends RuntimeException {
    public BackToPreviousException() {
        super("User chose to return to the main menu.");
    }
}
