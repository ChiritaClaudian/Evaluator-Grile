/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.login;

import db.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.LoginService;

/**
 *
 * @author chiri
 */
public class LoginGUIController implements Initializable {
    
    @FXML
    private Label label; 
    @FXML
    private TextField emailnameTextField;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private Button loginButton;
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      /*passwordPasswordField.setOnKeyPressed((KeyEvent event) -> {
          if(event.getCode() == KeyCode.ENTER){
             
          }
      });
*/
    }    
    @FXML
    private void login(ActionEvent event){
        String email = new String (emailnameTextField.getText());
        String password = new String (passwordPasswordField.getText());
        User user = LoginService.getInstance().login(email,password);
        if(user != null ){
           
            Parent root;
            if(user.getClasa().equals("Prof")){
                try {
                    root =FXMLLoader.load(getClass().getResource("ProfHome.fxml"));
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setTitle("Home Page");
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }else{
                 try {  
                    
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ElevHome.fxml"));
                    ElevHomeController elev = new ElevHomeController(user);
                    loader.setController(elev);
                    root = loader.load();
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setTitle("Home Page");
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
            
        
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Email sau parola gresita");
            alert.showAndWait();
        }
    }
    
    @FXML 
    private void registerElev(MouseEvent event){
        Parent root;
        try {
            
            root =FXMLLoader.load(getClass().getResource("Register.fxml"));
            //Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Stage stage = new Stage();
            stage.setTitle("Inregistrare");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    @FXML
    private void registerProf(MouseEvent event){
        Parent root;
        try {
            root =FXMLLoader.load(getClass().getResource("RegisterProf.fxml"));
            //Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Stage stage = new Stage();
            stage.setTitle("Inregistrare");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
