/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.login;

import db.Intrebari;
import db.Raspunsuri;
import db.User;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import service.IntrebariService;
import service.RaspunsuriService;
import service.TesteService;

/**
 * FXML Controller class
 *
 * @author chiri
 */
public class TestGUIController implements Initializable {
    @FXML
    private Label intrebareEnunt;
    @FXML
    private Label afisTest;
    @FXML
    private RadioButton enunt1;
    @FXML
    private RadioButton enunt3;
    @FXML
    private RadioButton enunt2;
    @FXML
    private Button next;
    @FXML
    private Button prev;
    @FXML
    private Button finish;
    @FXML
    private ToggleGroup raspunsuriToggleGroup;
    private Test[] teste;
    private int idTestCurent;
    private int numTesteCreat;
    private int numRaspCor;
    private int numMaxTeste;
    private ArrayList intrebari;
    private ArrayList raspunsuri;
    private Intrebari intrebare;
    private Raspunsuri raspuns;
    private boolean isCorrect;
    private String[] enunturi;
    private Random ram;
    private int idIntrebareCorecta;
    String capitol;
    User elev;
    public TestGUIController(User elev, String capitol){
        this.elev = elev;
        this.capitol = capitol;
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        prev.setDisable(true);
        finish.setDisable(true);
        idTestCurent = 1;
        numTesteCreat = 1;
        numRaspCor = 0;
        isCorrect = false;
        enunturi = new String[4];
        for(int i = 0; i< 4; i++)
            enunturi[i] = new String();
        intrebare = new Intrebari();
        int counter = 0;
        ram = new Random();
        intrebari = new ArrayList(IntrebariService.getInstance().getIntrebariByCapitol(capitol));
        numMaxTeste = intrebari.size();
        teste = new Test[intrebari.size() + 1];
        teste[0] = new Test();
        teste[0].setNumarTeste(numMaxTeste);
        intrebare = (Intrebari) intrebari.get(ram.nextInt(intrebari.size()));
        teste[idTestCurent] = new Test(intrebare.getTextIntrebare());
        intrebareEnunt.setText(intrebare.getTextIntrebare());
        raspunsuri = new ArrayList(RaspunsuriService.getInstance().getRaspunsuri(intrebare.getId()));
        intrebari.remove(intrebare);
        while(!raspunsuri.isEmpty()){
            raspuns = (Raspunsuri) raspunsuri.get(ram.nextInt(raspunsuri.size()));
            enunturi[counter] = raspuns.getTextRaspuns();
            teste[idTestCurent].setRaspuns(enunturi[counter],counter);
            if(raspuns.getIsCorrect() == 1){
                idIntrebareCorecta = counter + 1;
                teste[idTestCurent].setIdIntrebareCorecta(idIntrebareCorecta);
            }
            raspunsuri.remove(raspuns);
            counter++;
        }
        enunt1.setText(enunturi[0]);
        enunt2.setText(enunturi[1]);
        enunt3.setText(enunturi[2]);
        update();
    } 
    private void update(){
        afisTest.setText(idTestCurent + " din " + numMaxTeste);
    } 
    void reset(){
        enunt1.setSelected(false);
        enunt2.setSelected(false);
        enunt3.setSelected(false);
    }
    void save(){
        if(enunt1.isSelected()){
            teste[idTestCurent].setIdIntrebareAleasa(0);
        }
        else if(enunt2.isSelected()){
            teste[idTestCurent].setIdIntrebareAleasa(1);
        }
        else if(enunt3.isSelected()){
            teste[idTestCurent].setIdIntrebareAleasa(2);
              
        }
    }
    @FXML
    private void nextTest(){
        save();
        prev.setDisable(false);
        idTestCurent++;
        update();
        if(idTestCurent > numTesteCreat ){
            //if(!intrebari.isEmpty()){
                reset();
                isCorrect = false;
                int counter = 0;
                intrebare = (Intrebari) intrebari.get(ram.nextInt(intrebari.size()));
                teste[idTestCurent] = new Test(intrebare.getTextIntrebare());
                intrebareEnunt.setText(intrebare.getTextIntrebare());
                raspunsuri = new ArrayList(RaspunsuriService.getInstance().getRaspunsuri(intrebare.getId()));
                intrebari.remove(intrebare);
                while(!raspunsuri.isEmpty()){
                    raspuns = (Raspunsuri) raspunsuri.get(ram.nextInt(raspunsuri.size()));
                     teste[idTestCurent].setRaspuns(raspuns.getTextRaspuns(),counter);
                    enunturi[counter] = raspuns.getTextRaspuns();
                    if(raspuns.getIsCorrect() == 1){
                        idIntrebareCorecta = counter + 1;
                        teste[idTestCurent].setIdIntrebareCorecta(idIntrebareCorecta);
                    }
                    raspunsuri.remove(raspuns);
                    counter++;
                }
                enunt1.setText(enunturi[0]);
                enunt2.setText(enunturi[1]);
                enunt3.setText(enunturi[2]);
                numTesteCreat = idTestCurent;
            //}
            if(idTestCurent == numMaxTeste){
                next.setDisable(true);
                finish.setDisable(false);
            }
        }
        else if(idTestCurent <= numTesteCreat ){
            intrebareEnunt.setText(teste[idTestCurent].getIntrebare());
            enunt1.setText(teste[idTestCurent].getRaspunsuri()[0]);
            enunt2.setText(teste[idTestCurent].getRaspunsuri()[1]);
            enunt3.setText(teste[idTestCurent].getRaspunsuri()[2]);
            int idRaspunsMarcat = teste[idTestCurent].getIdIntrebareAleasa();
            switch (idRaspunsMarcat) {
                case 0:
                    enunt1.fire();
                    break;
                case 1:
                    enunt2.fire();
                    break;
                case 2:
                    enunt3.fire();
                    break;
            }
            if(idTestCurent == numMaxTeste){
                next.setDisable(true);
                finish.setDisable(false);
            }
        }
    }
    @FXML
    private void previous(){
        save();
        if(next.isDisabled())
            next.setDisable(false);
        if(!finish.isDisable())
            finish.setDisable(true);
        idTestCurent--;
        update();
        if(idTestCurent == 1)
            prev.setDisable(true);
        intrebareEnunt.setText(teste[idTestCurent].getIntrebare());
        enunt1.setText(teste[idTestCurent].getRaspunsuri()[0]);
        enunt2.setText(teste[idTestCurent].getRaspunsuri()[1]);
        enunt3.setText(teste[idTestCurent].getRaspunsuri()[2]);
        int idRaspunsMarcat = teste[idTestCurent].getIdIntrebareAleasa();
        switch (idRaspunsMarcat) {
            case 0:
                enunt1.fire();
                break;
            case 1:
                enunt2.fire();
                break;
            case 2:
                enunt3.fire();
                break;
        }
    }
    @FXML
    private void afisRez(ActionEvent event){
        save();
        numRaspCor = 0;
        for(int i = 1; i <= numMaxTeste; i++)
            if(teste[i].getIdIntrebareAleasa() + 1 == teste[i].getIdIntrebareCorecta())
                numRaspCor++;
        if(TesteService.getInstance().adaugaTest(elev.getNume(), elev.getPrenume(), elev.getClasa(), capitol, numRaspCor))
            System.out.println("Adaugare cu succes a rezultatelor");
        else
            System.out.println("ceva nu a functionat cum trebuie");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Rezultat");
        alert.setContentText("Ai raspuns corect la " + Integer.toString(numRaspCor) + " intrebari");
        alert.showAndWait();
        Parent root;
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VerificareTest.fxml"));
            VerificareTestController test = new VerificareTestController(teste); 
            loader.setController(test);
            root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Verificare Test");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
