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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import service.IntrebariService;
import service.RaspunsuriService;

/**
 * FXML Controller class
 *
 * @author chiri
 */
public class CreareTestController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField intrebareTextField;
    @FXML
    private TextField raspunsTextField;
    @FXML
    private TextField capitolTextField;
    @FXML
    private TextField clasaTextField;
    @FXML
    private ToggleButton isCorrect;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    }    
    
    @FXML
    public void adaugaIntrebare(){
        String intrebare = new String(intrebareTextField.getText());
        String capitol = new String(capitolTextField.getText());
        String clasa = new String(clasaTextField.getText());
        if(IntrebariService.getInstance().adaugareIntrebare(intrebare, clasa, capitol)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succes");
            alert.setContentText("Adaugarea intrebari este cu succes");
            alert.showAndWait();
        
        }
    }
    
    @FXML
    public void adaugaRaspuns(){
        int idIntrebare=0;
        String raspuns = new String(raspunsTextField.getText());
        if(!intrebareTextField.getText().isEmpty()){
            idIntrebare = IntrebariService.getInstance().getIntrebare(intrebareTextField.getText()).getId();
            int isCorrect;
            if(this.isCorrect.isSelected())
                isCorrect = 1;
            else
                isCorrect = 0;
            if(RaspunsuriService.getInstance().adaugareRaspuns(idIntrebare, raspuns, isCorrect)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succes");
                alert.setContentText("Adaugarea raspunsului este cu succes");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Campul intrebare trebuie sa fie completat cu intrebarea");
                alert.showAndWait();
               
        }
    }
}
