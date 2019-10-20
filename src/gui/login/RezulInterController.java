/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author chiri
 */
public class RezulInterController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField clasaTextField;
    @FXML
    private TextField capitolTextField;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    void next(ActionEvent event){
        String clasa = clasaTextField.getText();
        String capitol = capitolTextField.getText();
        Parent root;
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Rezultate.fxml"));
            RezultateController rez = new RezultateController(clasa, capitol);
            loader.setController(rez);
            root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Home Page");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
