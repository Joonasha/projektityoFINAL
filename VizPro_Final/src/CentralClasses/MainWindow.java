/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CentralClasses;

import AddNewThesis.AddGradesController;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.VBox;
import SearchClasses.*;
import java.io.IOException;
//import HelperClasses.Excel;
import java.util.ArrayList;
import javafx.scene.chart.Chart;
import javafx.scene.control.ScrollPane;

/**
 *
 * @author Joonas
 */
public class MainWindow extends Application {
    
    public static Stage mainStage;
    public static Scene newScene;
    public static Parent root;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        
        Scene scene = new Scene(root);
        mainStage = primaryStage;
        mainStage.setHeight(900);
        mainStage.setWidth(1100);

        //VBox base0 = (VBox) FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        //frontpage = new Scene(base0, 640, 400);
        
        primaryStage.setTitle("Gradujen visualisointi työkalu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static void AddGradesScene(Stage stage) throws IOException {
        mainStage = stage;
        root = FXMLLoader.load(AddGradesController.class.getResource("AddGrades.fxml"));
        newScene = new Scene(root, 1000, 700);
        mainStage.setScene(newScene);
    }    
    public static void VisualizeGradesScene() {
    	mainStage.setScene(newScene);
    }
    public static void SearchGradesScene(Stage stage) throws IOException{
        mainStage = stage;
        Parent root = FXMLLoader.load(SearchGradesController.class.getResource("SearchGrades.fxml"));
        newScene = new Scene(root, 1000, 700);  
        mainStage.setScene(newScene);
    }    
}
