/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CentralClasses;

import static CentralClasses.MainWindow.mainStage;
import static CentralClasses.MainWindow.newScene;
import SearchClasses.SearchGradesController;
import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JFileChooser;

/**
 * FXML Controller class
 *
 * @author joonasha
 */
public class StartPageController implements Initializable {

    @FXML
    private Label title;
    @FXML
    private JFXButton MainWindow;

    public static String excelSource = "";
    @FXML
    private TextField textfield;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        textfield.setFocusTraversable(false);
    }    

    @FXML
    private void OpenFileDialog(ActionEvent event) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(null);
    if (result == JFileChooser.APPROVE_OPTION) {
    File selectedFile = fileChooser.getSelectedFile();
    excelSource =  selectedFile.toString();
    textfield.setText(excelSource);
    MainWindow.setVisible(true);
    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
    
}                
    }

    @FXML
    private void MainWindowAction(ActionEvent event) throws IOException {
        if(!textfield.getText().equals("")){
        excelSource =  textfield.getText();
        mainStage = (Stage) MainWindow.getScene().getWindow();        
        Parent root = FXMLLoader.load(MainWindowController.class.getResource("MainWindow.fxml"));
        newScene = new Scene(root, 1000, 700);  
        mainStage.setScene(newScene);      
        }
    }

    @FXML
    private void textFieldAction(ActionEvent event) {
        
    }
    
}
