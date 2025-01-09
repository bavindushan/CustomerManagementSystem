package controller;

import model.Customer;

import java.time.LocalDate;
import java.util.List;

public interface CustomerSrvices {
    boolean addCustomer(Customer customer);
    boolean updateCustomer(Customer customer, String name, LocalDate dob, String telNo);
    Customer searchCustomer(String id);
    List<Customer> getAll();
    boolean deleteCustomer(String id);

}
