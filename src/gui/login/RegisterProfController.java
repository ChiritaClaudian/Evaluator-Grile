/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import service.LoginService;

/**
 * FXML Controller class
 *
 * @author chiri
 */
public class RegisterProfController implements Initializable {

   @FXML
    private TextField numeTextField;
    @FXML
    private TextField prenumeTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private PasswordField passwordCheckPasswordField;
    @FXML
    private Button confirmButton;
    
    private Alert info;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
    private void registration(){
        
        String nume = new String(numeTextField.getText());
        String prenume = new String(prenumeTextField.getText());
        String email = new String(emailTextField.getText());
        String clasa = new String("Prof");
        String password = new String(passwordPasswordField.getText());
        String passwordCheck = new String(passwordCheckPasswordField.getText());
          
        if(!(password.equals(passwordCheck))){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Parola si Parola de verificare nu sunt identice");
            alert.showAndWait();
             
        }
        else if(!email.contains("@") && !email.contains(".")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Introdu o adresa de mail valabila");
            alert.showAndWait();
           
        }
        else if(!clasa.contains("_")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Introdu o clasa valabila");
            alert.showAndWait();
        }
        else{
            
            if(LoginService.getInstance().register(nume, prenume, email, clasa, password)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succes");
                alert.setContentText("Inregistarea este cu succes");
                alert.showAndWait();
                
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Userul deja exista");
                alert.showAndWait();
               
            }
        }
    }
    
}
