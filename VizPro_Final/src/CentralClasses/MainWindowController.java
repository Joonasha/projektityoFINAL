/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CentralClasses;

import CentralClasses.MainWindow;
import com.jfoenix.controls.JFXButton;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Joonas
 */
public class MainWindowController implements Initializable {
    
    private Label label;
    @FXML
    private HBox LogosHbox;
    @FXML
    private JFXButton CreateGrade;
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private VBox ButtonVbox;
    
    private DoubleProperty fontSize = new SimpleDoubleProperty(10);
    @FXML
    public JFXButton SearchGrades;
    @FXML
    private JFXButton Login;

    @FXML
    private Label title;
    @FXML
    private ImageView logoImage;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Login.setVisible(false);
        CreateGrade.setFocusTraversable(false);
        SearchGrades.setFocusTraversable(false);
        Login.setFocusTraversable(false);
        title.setText("Gradujen visualisointi\r\n   \t    työkalu");
        FileInputStream inputstream;
        /*
        try {
            inputstream = new FileInputStream("image001.jpg");

        Image image = new Image(inputstream); 
        logoImage.setImage(image);
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }    

    @FXML
    private void CreateGradeAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) CreateGrade.getScene().getWindow();
        MainWindow.AddGradesScene(stage);
    }

   
    @FXML
    private void SearchGradesAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) SearchGrades.getScene().getWindow();
        MainWindow.SearchGradesScene(stage);
    }     

    @FXML
    private void LoginAction(ActionEvent event) {
    }
}
