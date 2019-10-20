/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author chiri
 */
public class ProfHomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField clasa;
    @FXML
    private TextField capitol;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    public void creareTest(){
        Parent root;
        try {
            root =FXMLLoader.load(getClass().getResource("CreareTest.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Creare Test");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    @FXML
    void vizRezolvare(){
        Parent root;
        try {
            root =FXMLLoader.load(getClass().getResource("RezulInter.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Rezultate");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
