package controller;

import db.DBConnection;
import model.Customer;

import java.util.List;

public class CustomerController implements CustomerSrvices {
    @Override
    public boolean addCustomer(Customer customer) {
       return DBConnection.getInstance().getConnection().add(customer);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return false;
    }

    @Override
    public Customer searchCustomer(String id) {
        return null;
    }

    @Override
    public List<Customer> getAll() {
        return DBConnection.getInstance().getConnection();
    }

    @Override
    public boolean deleteCustomer(String id) {
        return DBConnection.getInstance().getConnection().removeIf(customer -> customer.getId().equals(id));
    }
}
