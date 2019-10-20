/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.login;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeTableColumn;
import service.TesteService;
import db.Teste;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.scene.control.TreeItem;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author chiri
 */
public class RezultateController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private JFXTreeTableView<TestViewTable> treeView;
    private String clasa;
    private String capitol;
    public RezultateController(String clasa, String capitol){
        this.clasa = clasa;
        this.capitol = capitol;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        JFXTreeTableColumn<TestViewTable, String> numeCol = new JFXTreeTableColumn<>("Nume");
        numeCol.setPrefWidth(150);
        numeCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<TestViewTable, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<TestViewTable, String> param) {
                return param.getValue().getValue().nume;
            }
        });
        
        JFXTreeTableColumn<TestViewTable, String> prenumeCol = new JFXTreeTableColumn<>("Preume");
        prenumeCol.setPrefWidth(150);
        prenumeCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<TestViewTable, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<TestViewTable, String> param) {
                return param.getValue().getValue().prenume;
            }
        });
        
        JFXTreeTableColumn<TestViewTable, String> notaCol = new JFXTreeTableColumn<>("Nota");
        notaCol.setPrefWidth(150);
        notaCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<TestViewTable, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<TestViewTable, String> param) {
                return param.getValue().getValue().nota;
            }
        });
        
        List testeRaw =  TesteService.getInstance().getTesteByClasa(clasa);
        ObservableList<TestViewTable> rezultate = FXCollections.observableArrayList();
        
        for (Iterator it = testeRaw.iterator(); it.hasNext();) {
            Teste test = (Teste) it.next();
            rezultate.add(new TestViewTable(test.getNume(), test.getPrenume(), Integer.toString(test.getNota())));
        }
        
        final TreeItem<TestViewTable> root = new RecursiveTreeItem<TestViewTable>(rezultate, RecursiveTreeObject::getChildren);
        treeView.getColumns().setAll(numeCol, prenumeCol, notaCol);
        treeView.setRoot(root);
        treeView.setShowRoot(false);
    }

   
    class TestViewTable extends RecursiveTreeObject<TestViewTable>{
        StringProperty nume;
        StringProperty prenume;
        StringProperty nota;
        
        public TestViewTable(String nume, String prenume, String nota){
            this.nume = new SimpleStringProperty(nume);
            this.prenume = new SimpleStringProperty(prenume);
            this.nota = new SimpleStringProperty(nota);
        }
    }
}
