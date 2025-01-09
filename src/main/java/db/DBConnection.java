package db;

import model.Customer;

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
}
