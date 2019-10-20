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
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author chiri
 */
public class VerificareTestController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML 
    private Label intrebare;
    @FXML 
    private Label raspuns1;
    @FXML 
    private Label raspuns2;
    @FXML 
    private Label raspuns3;
    @FXML
    private Label status;
    @FXML 
    private Label indexIntrebare;
    @FXML 
    private Button nextButton;
    @FXML
    private Button prevButton;
    private int idTestCurent;
    private int numTesteMax;
    private Test[] teste;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        idTestCurent = 1;
        update();
        prevButton.setDisable(true);
    }    
    private void update(){
        indexIntrebare.setText(Integer.toString(idTestCurent) + " din " + Integer.toString(numTesteMax));
        intrebare.setText(teste[idTestCurent].getIntrebare());
        raspuns1.setText(teste[idTestCurent].getRaspunsuri()[0]);
        raspuns2.setText(teste[idTestCurent].getRaspunsuri()[1]);
        raspuns3.setText(teste[idTestCurent].getRaspunsuri()[2]);
        int idIntrebAleasa = teste[idTestCurent].getIdIntrebareAleasa();
        if(teste[idTestCurent].getIdIntrebareCorecta() == idIntrebAleasa + 1){
            status.setText("Ai raspuns corect");
            switch (idIntrebAleasa) {
                case 0:
                    raspuns1.setStyle("-fx-background-color: 	#00FF00");
                    break;
                case 1:
                    raspuns2.setStyle("-fx-background-color: 	#00FF00");
                    break;
                case 2:
                    raspuns3.setStyle("-fx-background-color: 	#00FF00");
                    break;
            }
        }
        else{
            status.setText("Ai raspuns gresit");
             switch (idIntrebAleasa) {
                case 0:
                    raspuns1.setStyle("-fx-background-color: #FF4500");
                    break;
                case 1:
                    raspuns2.setStyle("-fx-background-color: #FF4500");
                    break;
                case 2:
                    raspuns3.setStyle("-fx-background-color: #FF4500");
                    break;
             }
             switch (teste[idTestCurent].getIdIntrebareCorecta()) {
                case 1:
                    raspuns1.setStyle("-fx-background-color: 	#00FF00");
                    break;
                case 2:
                    raspuns2.setStyle("-fx-background-color: 	#00FF00");
                    break;
                case 3:
                    raspuns3.setStyle("-fx-background-color: 	#00FF00");
                    break;       
             }
        }
    }
    private void reset(){
        raspuns1.setStyle("");
        raspuns2.setStyle("");
        raspuns3.setStyle("");
    }
    public VerificareTestController(Test[] teste) {
        this.teste = teste;
        numTesteMax = teste[0].getNumarTeste();
    }
    
    @FXML
    private void nextTest(){
        idTestCurent++;
        if(idTestCurent == numTesteMax)
            nextButton.setDisable(true);
        if(prevButton.isDisabled())
            prevButton.setDisable(false);
        reset();
        update();
    }
    @FXML
    private void prevTest(){
        idTestCurent--;
        if(idTestCurent == 1)
            prevButton.setDisable(true);
        if(nextButton.isDisabled())
            nextButton.setDisable(false);
        reset();
        update();
    }
}
