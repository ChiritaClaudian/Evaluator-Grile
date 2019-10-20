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
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import service.IntrebariService;

/**
 * FXML Controller class
 *
 * @author chiri
 */
public class ElevHomeController implements Initializable {
    
    String clasa;
    User elev;
    @FXML
    public Label label;
    /**
     * Initializes the controller class.
     */
    @FXML
    ListView listView ;
    @FXML
    TableView tabel;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
        listView.setItems(FXCollections.observableArrayList( IntrebariService.getInstance().getIntrebariByClasa(elev.getClasa().replaceAll("\\D+", ""))));
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Nu exista teste pentru clasa in care te afli");
            alert.showAndWait();
        }
    }   
    public ElevHomeController(User elev){
        this.elev = elev;
    }
   
    @FXML
    public void startTest(){
        
        String capitol =(String) listView.getSelectionModel().getSelectedItem();
         Parent root;
        try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TestGUI.fxml"));
            TestGUIController testGuiController = new TestGUIController(elev,capitol);
            loader.setController(testGuiController);
            root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Test");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException ex) {
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Alege un capitol");
            alert.showAndWait();
        }
    }
   
    
}
