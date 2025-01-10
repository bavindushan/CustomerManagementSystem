package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewCustomerFormController implements Initializable {

    @FXML
    private TableColumn tblId;

    @FXML
    private TableColumn tblName;

    @FXML
    private TableColumn tblTelno;

    @FXML
    private TableView tblViewCustomerDetails;

    @FXML
    private TableColumn tbldob;

    private CustomerController customerController;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customerController = new CustomerController();
        setUpTableColumns();
        loadTable();
    }
    @FXML
    void btnReloadOnAction(ActionEvent event) {
        setUpTableColumns();
        loadTable();
    }
    public void loadTable(){
        ObservableList<Customer> customerObservableList = FXCollections.observableArrayList(customerController.getAll());
        tblViewCustomerDetails.setItems(customerObservableList);
    }

    public void setUpTableColumns(){
        tblId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tbldob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        tblTelno.setCellValueFactory(new PropertyValueFactory<>("telNo"));
    }
}
