package controller;

import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CustomerFormController implements Initializable {

    @FXML
    private DatePicker dtpDob;

    @FXML
    private TableView tblCustomerManagre;

    @FXML
    private TableColumn tblDob;

    @FXML
    private TableColumn tblID;

    @FXML
    private TableColumn tblName;

    @FXML
    private TableColumn tblTelNo;

    @FXML
    private JFXTextField txtID;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtTelNo;

    private CustomerController customerController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customerController = new CustomerController();
        setUpTableColumns();
        loadTable();
        txtID.setText(genarateCustomerID());
    }

    @FXML
    void btnAddCustomerOnAction(ActionEvent event) {

        boolean addCustomer = customerController.addCustomer(new Customer(genarateCustomerID(), txtName.getText(), dtpDob.getValue(), txtTelNo.getText()));

        Alert alert;
        if(addCustomer){
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Adding Successful");
        }else{
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Adding Unsuccessful");
        }
        alert.setHeaderText(null);
        alert.showAndWait();

        //load table
        loadTable();
    }

    @FXML
    void btnDeleteCustomernAction(ActionEvent event) {
        boolean deleteCustomer = customerController.deleteCustomer(txtID.getText());
        Alert alert;
        if(deleteCustomer){
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Delete Successful");
        }else{
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Delete Unsuccessful");
        }
        alert.setHeaderText(null);
        alert.showAndWait();

        //load table
        loadTable();
    }

    @FXML
    void btnSearchCustomerOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateCustomerOnAction(ActionEvent event) {

    }
    public void loadTable(){
        ObservableList<Customer> customerObservableList = FXCollections.observableArrayList(customerController.getAll());
        tblCustomerManagre.setItems(customerObservableList);
    }

    public void setUpTableColumns(){
        tblID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        tblTelNo.setCellValueFactory(new PropertyValueFactory<>("telNo"));
    }
    private String genarateCustomerID(){
        int nextID = customerController.getAll().size()+1;
        return String.format("C%04d",nextID);
    }

}
