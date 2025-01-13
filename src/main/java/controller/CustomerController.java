package controller;

import db.DBConnection;
import model.Customer;

import java.time.LocalDate;
import java.util.List;

public class CustomerController implements CustomerSrvices {
    @Override
    public boolean addCustomer(Customer customer) {
        List<Customer> customers = DBConnection.getInstance().getAllCustomers();
        customers.add(customer);
        DBConnection.getInstance().writeAllCustomers(customers);
        return true;
    }

    @Override
    public boolean updateCustomer(Customer customer, String name, LocalDate dob,String telNo) {
        List<Customer> customers = DBConnection.getInstance().getAllCustomers();
        for (Customer c : customers) {
            if (c.getId().equals(customer.getId())) {
                c.setName(name);
                c.setDob(dob);
                c.setTelNo(telNo);
                DBConnection.getInstance().writeAllCustomers(customers);
                return true;
            }
        }
        return false;
    }

    @Override
    public Customer searchCustomer(String id) {
        return DBConnection.getInstance().getAllCustomers()
                .stream()
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
        return DBConnection.getInstance().getAllCustomers();
    }

    @Override
    public boolean deleteCustomer(String id) {
        List<Customer> customers = DBConnection.getInstance().getAllCustomers();
        boolean isRemoved = customers.removeIf(customer -> customer.getId().equals(id));
        if (isRemoved) {
            DBConnection.getInstance().writeAllCustomers(customers);
        }
        return isRemoved;
    }
}
