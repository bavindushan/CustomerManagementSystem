package db;

import model.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private static DBConnection instance;
    private List<Customer>customerList;

    private DBConnection(){
        customerList = new ArrayList<>();
    }
    public List<Customer> getConnection(){
        return customerList;
    }
    public static DBConnection getInstance(){
        return instance==null?instance=new DBConnection():instance;
    }
    public void writeToFile(){


        try (PrintWriter writer = new PrintWriter(new FileWriter("DBFile.txt",true))) {

            for(Customer customer:customerList){
                String line = String.format("%s,%s,%s,%s",
                                            customer.getId(),
                                            customer.getName(),
                                            customer.getDob(),
                                            customer.getTelNo());
                writer.println(line);
            }
            System.out.println("Data write successfully!");
        } catch (Exception e) {
            System.out.println("Error writing to File"+e.getMessage());
        }
    }
}
