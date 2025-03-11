/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author ongji
 */
import java.io.*;
import adt.ArrayList;
import adt.ListInterface;
import entity.Account;

public class AccountDAO {
    private static final String FILE_NAME = "C:\\Users\\ongji\\OneDrive\\Documents\\NetBeansProjects\\DSA_Assignment\\data_storage\\account.txt";
    
    public static void createFile(){
        try{
            File file = new File(FILE_NAME);
            if(file.createNewFile()){
                System.out.println("File is created " + FILE_NAME);
            }else{
                System.out.println("File already exists");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    // append mode
    public static boolean insert_account(String data){
        boolean success = false;
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))){
            writer.write(data);
            writer.newLine();
            success = true;
        }catch(IOException e){
            e.printStackTrace();
            success = false;
        }
        
        return success;
    }
    
    // read all account
    public static ListInterface get_all_account(){
        ListInterface accList = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while((line = reader.readLine()) != null){
                accList.add(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        
        return accList;
    }
    
    // count the number of account
    public static int count_no_of_account(){
        int count = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while((line = reader.readLine()) != null){
                count++;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        
        return count;
    }
    
    public static ListInterface<String> search_account_by_email(String email){
        ListInterface<String> results = new ArrayList<>();
        
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while((line = reader.readLine()) != null){
                String[] data = line.split("\\|");
                if(data.length > 1 && data[1].trim().equalsIgnoreCase(email.trim())){
                    results.add(line);
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        
        return results.isEmpty() ? null : results;
    }
    
    public static ListInterface<String> search_account_by_accountID(String accountID){
        ListInterface<String> results = new ArrayList<>();
        
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while((line = reader.readLine()) != null){
                String[] data = line.split("\\|");
                if(data.length > 0 && data[0].trim().equalsIgnoreCase(accountID.trim())){
                    results.add(line);
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        
        return results.isEmpty() ? null : results;
    }
    
//    public static void main(String[] args){
//        AccountDAO dao = new AccountDAO();
//        ListInterface array = new ArrayList<>();
//        dao.createFile();
//        dao.insert_account("jiale04@gmail.com,Password123,Employer");
//        array = dao.search_account_by_email("jiale04@gmail.com");
//        System.out.println(array);
//    }
}
