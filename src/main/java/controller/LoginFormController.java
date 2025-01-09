package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private TextField txt_password;

    @FXML
    private TextField txt_userName;

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {

        if(txt_password.getText().equals("1234")&& txt_userName.getText().equalsIgnoreCase("admin")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login Successful");
            alert.setHeaderText(null);
            alert.setContentText("Welcome!");
            alert.showAndWait();

            //move to home page
            Stage stage = new Stage();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/HomePage.fxml"))));
            stage.show();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText("Invalid Password");
            alert.setContentText("Please try again.");
            alert.showAndWait();
        }
    }

}
