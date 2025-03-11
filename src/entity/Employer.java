/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ongji
 */

import dao.EmployerDAO;
import java.util.regex.Pattern;

public class Employer {
    private String employer_ID;
    private Account account;
    private String employer_name;
    private String company_name;
    private String company_address;
    private String phoneNumber;
    
    public Employer(){
        
    }

    public Employer(String employer_ID, Account account, String employer_name, String company_name, String company_address, String phoneNumber) {
        this.employer_ID = employer_ID;
        this.account = account;
        this.employer_name = employer_name;
        this.company_name = company_name;
        this.company_address = company_address;
        this.phoneNumber = phoneNumber;
    }
    
    public String getEmployer_ID(){
        return employer_ID;
    }

    public Account getAccount() {
        return account;
    }

    public String getEmployer_name() {
        return employer_name;
    }

    public String getCompany_name() {
        return company_name;
    }

    public String getCompany_address() {
        return company_address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setEmployer_ID(String employer_ID){
        this.employer_ID = employer_ID;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setEmployer_name(String employer_name) {
        this.employer_name = employer_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public void setCompany_address(String company_address) {
        this.company_address = company_address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public boolean isValidPhoneNumber(String phoneNumber){
        final String PHONE_REGEX = "^(\\+?\\d{1,3})?\\d{10,12}$";
        return Pattern.matches(PHONE_REGEX, phoneNumber);
    }
    
    public String generateEmployerID(){
        EmployerDAO employerDAO = new EmployerDAO();
        int count = employerDAO.count_no_of_employer();
        String idGenerated = "E" + String.format("%0" + 4 + "d", count + 1);
        return idGenerated;
    }
    
    public void displayEmployer(){
        System.out.println("Employer Account Details:");
        account.displayAccount(); // Calls Account's display method
        System.out.println("Company Name: " + company_name);
        System.out.println("Company Address: " + company_address);
        System.out.println("Phone Number: " + phoneNumber);
    }
}
