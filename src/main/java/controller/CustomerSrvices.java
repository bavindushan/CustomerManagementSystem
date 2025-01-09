package controller;

import model.Customer;

import java.util.List;

public interface CustomerSrvices {
    boolean addCustomer(Customer customer);
    boolean updateCustomer(Customer customer);
    Customer searchCustomer(String id);
    List<Customer> getAll();
    boolean deleteCustomer(String id);

}
