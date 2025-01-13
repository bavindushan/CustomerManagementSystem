package db;

import model.Customer;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private static DBConnection instannce;
    private final String filePath = "C:\\Users\\Bavindu Shan\\Documents\\ICET(ICD)-112(SF_Training_Program)\\Standalone Application Development\\Java_FX\\CustomerManagementSystem\\src\\main\\java\\db\\DBFile.txt";

    private DBConnection(){
        File file = new File(filePath);
        try {
            // Creates the file if it doesn't exist
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Error creating File: "+e.getMessage());
        }
    }
    public static DBConnection getInstance(){
        return instannce==null?instannce = new DBConnection():instannce;
    }
    public List<Customer> getAllCustomers(){
        List<Customer> customerList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    Customer customer = new Customer(
                            parts[0], // ID
                            parts[1], // Name
                            LocalDate.parse(parts[2]), // DOB
                            parts[3]  // TelNo
                    );
                    customerList.add(customer);
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        return customerList;
    }
    public void writeAllCustomers(List<Customer> customerList) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Customer customer : customerList) {
                String line = String.format("%s,%s,%s,%s",
                        customer.getId(),
                        customer.getName(),
                        customer.getDob(),
                        customer.getTelNo());
                writer.println(line);
            }
        } catch (Exception e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    public String getLastCustomerID() {
        String lastID = "C0000"; // Default ID if the file is empty or malformed
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String currentID = line.split(",")[0]; // Extract the ID (first field in the line)
                if (currentID.matches("C\\d{4}")) { // Ensure the ID is in the correct format (CXXXX)
                    lastID = currentID;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from DBFile in getLastCustomerID: " + e.getMessage());
        }
        return lastID;
    }
}
