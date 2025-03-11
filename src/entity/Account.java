/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ongji
 */

import adt.ArrayList;
import adt.ListInterface;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import dao.AccountDAO;

public class Account {
    private String accountID;
    private String email;
    private String password;
    private String userType;

    public Account() {
    }
    
    

    public Account(String accountID, String email, String password, String userType) {
        this.accountID = accountID;
        this.email = email;
        this.password = password;
        this.userType = userType; // employer, jobseeker, ...
    }
    
    public String getAccountID(){
        return accountID;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }
    
    public void setAccountID(String accountID){
        this.accountID = accountID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    
    public String generateAccountID(){
        AccountDAO accDAO = new AccountDAO();
        int count = accDAO.count_no_of_account();
        String idGenerated = "A" + String.format("%0" + 4 + "d", count + 1);
        return idGenerated;
    }
    
    public boolean isValidEmail(String email){
        final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(EMAIL_REGEX, email);
    }
    
    public boolean isValidPassword(String password){
        final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!?]).{8,}$";
        return Pattern.matches(PASSWORD_REGEX, password);
    }
    
    public String isValidLogin(String email, String password, String userType){
        boolean success_login = false;
        
        String account_ID = "";
        
        account_ID = isValidLogin_email(email, userType);
        if(account_ID != null){
            success_login = isValidLogin_password(account_ID, password);
        }
        
        return success_login==true? account_ID : null;   
    }
    
    public boolean isDupulicateEmail(String email){
        ListInterface<String> accList = new ArrayList<>();
        AccountDAO accDAO = new AccountDAO();
        boolean isDuplicateEmail = false;
        
        accList = accDAO.search_account_by_email(email);
        if(accList != null){
            isDuplicateEmail = true;
        }
        
        return isDuplicateEmail;
    }
    
    public void displayAccount(){
        System.out.println("\nAccount Details");
        System.out.println("===============");
        System.out.println("Email: " + email);
        System.out.println("User Type: " + userType);
    }
    
    private String isValidLogin_email(String email, String userType){
        AccountDAO accDAO = new AccountDAO();
        ListInterface<String> accountList = new ArrayList<>();
        String account_info = "";
        
        accountList = accDAO.search_account_by_email(email);
        if(accountList != null){
            account_info = accountList.get(0);
            String[] data = account_info.split("\\|");
//            boolean isValid_userType = userType.equalsIgnoreCase(data[3])? true : false;
            if(userType.equalsIgnoreCase(data[3])){
                return data[0]; // account_ID
            }
        }
        
        return null;
    }
    
    private boolean isValidLogin_password(String accountID, String password){
        AccountDAO accDAO = new AccountDAO();
        ListInterface<String> accountList = new ArrayList<>();
        String account_info = "";
        boolean password_valid = false;
        
        accountList = accDAO.search_account_by_accountID(accountID);
        if(accountList != null){
            account_info = accountList.get(0);
            String[] data = account_info.split("\\|");
            String acc_password = data[2];
            
            if(acc_password.equals(password)){
                password_valid = true;
            }else{
                password_valid = false;
            }
        }else{
            password_valid = false;
        }
        
        return password_valid;
    }
    
    
    public static void main(String[] args){
//        Account acc = new Account();
//        boolean success = acc.isValidLogin("ongjiale04@gmail.com", "Jialeong54321");
//        System.out.println(success);
    }
}
