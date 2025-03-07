/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ongji
 */
public class Employer {
    private Account account;
    private String employer_name;
    private String company_name;
    private String company_address;
    private String phoneNumber;
    
    public Employer(){
        
    }

    public Employer(Account account, String employer_name, String company_name, String company_address, String phoneNumber) {
        this.account = account;
        this.employer_name = employer_name;
        this.company_name = company_name;
        this.company_address = company_address;
        this.phoneNumber = phoneNumber;
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
    
    public void displayEmployer(){
        System.out.println("Employer Account Details:");
        account.displayAccount(); // Calls Account's display method
        System.out.println("Company Name: " + company_name);
        System.out.println("Company Address: " + company_address);
        System.out.println("Phone Number: " + phoneNumber);
    }
}
