/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchClasses;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author joonasha
 */
public class SeachGradesController implements Initializable {

    @FXML
    private JFXTextField nameTF;
    @FXML
    private JFXTextField authorsTF;
    @FXML
    private JFXComboBox<?> yearCB;
    @FXML
    private JFXComboBox<?> typeCB;
    @FXML
    private JFXComboBox<?> levelCB;
    @FXML
    private JFXComboBox<?> languageCB;
    @FXML
    private JFXComboBox<?> authorsCB;
    @FXML
    private VBox vbox1;
    @FXML
    private VBox vbox2;
    @FXML
    private VBox vboxMain;
    @FXML
    private AnchorPane anchorpane;
    @FXML
    private JFXButton ParadigmaButton;
    @FXML
    private VBox content1;
    @FXML
    private VBox content2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vbox1.setStyle("-fx-background-color:black");
        vbox2.setStyle("-fx-background-color:black");
        anchorpane.setStyle("-fx-background-color:black");
        vboxMain.setStyle("-fx-background-color:white");
        
        
        
        
        
    }    

    @FXML
    private void ParadigmaButtonAction(ActionEvent event) {
        content1.getChildren().clear();
    }
    
}
