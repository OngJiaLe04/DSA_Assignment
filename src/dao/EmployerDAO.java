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

public class EmployerDAO {
    private static final String FILE_NAME = "C:\\Users\\ongji\\OneDrive\\Documents\\NetBeansProjects\\DSA_Assignment\\data_storage\\employer.txt";
    
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
    public static void insert_employer(String data){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))){
            writer.write(data);
            writer.newLine();
            System.out.println("Data Written: " + data);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    // read all employer
    public static void read_all_employer(){
        ListInterface employerList = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    // search_employer_by name
    public static ListInterface<String> search_employer_by_name(String target_name){
        ListInterface<String> results = new ArrayList<>();
        
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while((line = reader.readLine()) != null){
                String[] data = line.split(",");
                if(data.length > 1 && data[1].equalsIgnoreCase(target_name)){
                    results.add(line);
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        
        return results.isEmpty() ? null : results;
    }
    
    // update_employer
    public static void update_employer(String target_id, String column, String newValue){
        ListInterface<String> lines = new ArrayList<>();
        String[] headers = {"id", "name", "role"}; // Define the column names here
        
        // Determine the column index that want to update
        int columnIndex = -1;
        for(int i = 0; i < headers.length; i++){
            if(headers[i].equalsIgnoreCase(column)){
                columnIndex = i;
                break;
            }
        }
        
        if (columnIndex != -1 ){
            try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
                String line;
                while((line = reader.readLine()) != null){
                    String[] data = line.split(",");
                    
                    if(data.length > columnIndex && data[0].equals(target_id)){
                        data[columnIndex] = newValue;
                        line = String.join(",", data);
                    }
                    
                    lines.add(line);
                }
            }catch(IOException e){
                e.printStackTrace();
            }
            
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))){
                for(int i = 0; i < lines.size(); i++){
                    writer.write(lines.get(i));
                    writer.newLine();
                }
                
            }catch(IOException e){
                e.printStackTrace();
            }
        }else{
            System.out.println("Invalid Column Name" + column);
        }
        
        
        
    }
    
    public static void main(String[] args){
      ListInterface<String> results = new ArrayList<>();
    //        createFile();
    //        writeData("1,Alice,User");
    //        writeData("2,Bob,Guest");
    //        writeData("3,Charlie,Employer");
    //        read_employer();
    //          update_employer("2", "role", "jiale");
      results = search_employer_by_name("alice");
    //          System.out.print(results);
      if(results != null){
          for(int i = 0; i < results.size(); i++){
            System.out.println(results.get(i));
          }
      }

    }
    
}
