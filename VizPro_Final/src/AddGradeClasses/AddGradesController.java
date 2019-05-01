/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddGradeClasses;

import static CentralClasses.MainWindow.mainStage;
import static CentralClasses.MainWindow.newScene;
import CentralClasses.MainWindowController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXScrollPane;
import java.awt.Dimension;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Joonas
 */
public class AddGradesController implements Initializable {

    @FXML
    private AnchorPane anchorpane;
    @FXML
    private VBox mainLayout;
    @FXML
    private JFXButton BackToMain;
    @FXML
    private Label title;
    @FXML
    private ScrollPane scrollpane;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    anchorpane.setStyle("-fx-background-color:white");
    mainLayout.setStyle("-fx-background-color:white");
    }    

    @FXML
    private void BackToMainAction(ActionEvent event) throws IOException {
        mainStage = (Stage) BackToMain.getScene().getWindow();
        Parent root = FXMLLoader.load(MainWindowController.class.getResource("MainWindow.fxml"));
        newScene = new Scene(root, 1000, 700);  
        mainStage.setScene(newScene);         
    }
    
}
