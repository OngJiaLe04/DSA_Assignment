/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author ongji
 */

import boundary.AccountRegisterUI;
import dao.AccountDAO;
import entity.Account;
import utility.MessageUI;

public class AccountRegisterControl {
    AccountRegisterUI accountRegister_UI = new AccountRegisterUI();
    MessageUI messageUI = new MessageUI();
    AccountDAO accDAO = new AccountDAO();
    Account account = new Account();
    
    public Account runAccountRegister(String userType){
        account = accountRegister_UI.getAccountRegisterUI(userType);
        
        if(account != null){
            String accountID = account.generateAccountID();
            account.setAccountID(accountID);
            String data = accountID + "|" + account.getEmail() + "|" + account.getPassword() + "|" + account.getUserType();
            boolean success = accDAO.insert_account(data);
            if(success){
                messageUI.message_success_createAccount();
            }else{
                messageUI.message_error_createAccount();
            }
        }else{
            
            return null;
        }
        
        return account!=null? account : null;
    }
    
//    public static void main(String[] args){
//        AccountRegisterControl test = new AccountRegisterControl();
//        test.runAccountRegister();
//    }
}
