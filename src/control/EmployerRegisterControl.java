/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author ongji
 */

import boundary.EmployerRegisterUI;
import dao.EmployerDAO;
import entity.Account;
import entity.Employer;
import utility.ScreenUI;
import utility.MessageUI;

public class EmployerRegisterControl {
    EmployerRegisterUI employerRegister_UI = new EmployerRegisterUI();
    EmployerDAO employerDAO = new EmployerDAO();
    Account account = new Account();
    Employer employer = new Employer();
    
    MessageUI messageUI = new MessageUI();
    ScreenUI screenUI = new ScreenUI();
    
    public void runEmployerRegister(Account account){
        employer = employerRegister_UI.getEmployerRegisterUI(account);
        if(employer != null){
            String data = employer.getEmployer_ID() + "|" + employer.getEmployer_name() + "|" + employer.getCompany_name() + "|" + employer.getCompany_address() + "|" + employer.getPhoneNumber() + "|" + employer.getAccount().getAccountID();
            boolean success = employerDAO.insert_employer(data);
            if(success){
                messageUI.message_success_createEmployer();
            }else{
                messageUI.message_error_createEmployer();
            }
        }
        employer.displayEmployer();
    }
    
//    public static void main(String[] args){
//        EmployerRegisterControl testing = new EmployerRegisterControl();
//        testing.runEmployerRegister("email");
//    }
}
