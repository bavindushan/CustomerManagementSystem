package controller;

import db.DBConnection;
import model.Customer;

import java.time.LocalDate;
import java.util.List;

public class CustomerController implements CustomerSrvices {
    @Override
    public boolean addCustomer(Customer customer) {
       return DBConnection.getInstance().getConnection().add(customer);
    }

    @Override
    public boolean updateCustomer(Customer customer, String name, LocalDate dob,String telNo) {
        customer.setName(name);
        customer.setDob(dob);
        customer.setTelNo(telNo);
        return true;
    }

    @Override
    public Customer searchCustomer(String id) {
        return DBConnection.getInstance().getConnection()
                .stream() //Converts the customerList into a stream to process its elements.
                .filter(customer -> customer.getId().equals(id))
                .findFirst()
                .orElse(null);

//        for (Customer customer : DBConnection.getInstance().getConnection()) {
//            if (customer.getId().equals(id)) {
//                return customer;
//            }
//        }
//        return null;
    }

    @Override
    public List<Customer> getAll() {
        return DBConnection.getInstance().getConnection();
    }

    @Override
    public boolean deleteCustomer(String id) {
        return DBConnection.getInstance().getConnection()
                .removeIf(customer -> customer.getId().equals(id));
    }
}
