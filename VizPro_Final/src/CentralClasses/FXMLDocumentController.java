/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CentralClasses;

import CentralClasses.MainWindow;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author Joonas
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private HBox LogosHbox;
    @FXML
    private JFXButton CreateGrade;
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private VBox ButtonVbox;
    @FXML
    private JFXButton VisualizeGrades;
    
    private DoubleProperty fontSize = new SimpleDoubleProperty(10);
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    CreateGrade.prefWidthProperty().bind(AnchorPane.widthProperty().subtract(250));
    CreateGrade.prefHeightProperty().bind(AnchorPane.heightProperty().subtract(100));
    Text text = new Text(CreateGrade.getText());
    fontSize.bind(AnchorPane.widthProperty().add(AnchorPane.heightProperty()).divide(50));  
    //text.setStyle("-fx-font: 40 Arial;");
    CreateGrade.setStyle("-fx-font-size: "+ fontSize.asString() + "px;");
    //CreateGrade.setStyle(String.format("-fx-font-size: %dpx;", (int)(0.45 * CreateGrade.)));
    }    
/*
    @FXML
    private void CreateGradeAction(ActionEvent event) {
        MainWindow.newThesis();
    }

    @FXML
    private void VisualizeGradesAction(ActionEvent event) {
        MainWindow.visualizationPage();
    }
   
    @FXML
    private void SearchGradesAction(ActionEvent event) {
        SearchGrades.visualizationPage();
    }     
*/ 
}
