/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchClasses;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
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
    @FXML
    private HBox contentMain;
    @FXML
    private VBox content3 = new VBox();
    private VBox content4 = new VBox();
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
        contentMain.getChildren().clear();
        content1.getChildren().clear();
        content1.prefWidth(1000);
        content1.prefHeight(1000);        
        content2.getChildren().clear();
        content3.getChildren().clear();
        content3.prefWidth(390.0);
        content3.prefHeight(324.0);
        content4.getChildren().clear();
        //content1.prefWidth(1000);
        //content1.prefHeight(1000);
        contentMain.setMargin(content1, new Insets(0,10,0,0));
        contentMain.setMargin(content2, new Insets(0,10,0,0));
        contentMain.setMargin(content3, new Insets(0,10,0,0));
        contentMain.setMargin(content4, new Insets(0,10,0,0)); 
        //content4.prefHeight(50);
        //content4.prefWidth(50);
        SetupContent1();
        SetupContent2();
        SetupContent3();
        SetupContent4();

        
        contentMain.getChildren().addAll(content1,content2,content3,content4);
/*        
        content1
        JFXCheckBox subject1CB = new JFXCheckBox();
        JFXTextArea subject1 = new JFXTextArea();
        JFXTextArea subject1subclassesLW = new JFXTextArea();
        JFXComboBox framework1CB = new JFXComboBox();
        content1.getChildren().addAll(subject1CB, subject1, subject1subclassesLW, framework1CB);  */      
    }
    private void SetupContent1(){
        JFXCheckBox subject1CB = new JFXCheckBox();        
        subject1CB.setMnemonicParsing(false);
        subject1CB.setOnAction(new EventHandler<ActionEvent>() {

    
    public void handle(ActionEvent event) {
        System.out.println("Hello World!");
    }
});
        subject1CB.setText("Lisää hakuun");
        JFXTextArea subject1 = new JFXTextArea();
        subject1.prefHeight(38.0);
        subject1.prefWidth(100.0);
        subject1.setPadding(new Insets(0,0,80,0));
        JFXListView subject1subclassesLW = new JFXListView();
        subject1subclassesLW.prefHeight(120.0);
        subject1subclassesLW.prefWidth(150.0);  
        //subject1subclassesLW.setPadding(new Insets(0,60,60,0));
        ComboBox framework1CB = new ComboBox();
        framework1CB.getItems().add("testi");
        framework1CB.prefHeight(25);
        framework1CB.minWidth(255);
        framework1CB.prefWidth(655);
        //framework1CB.setPadding(new Insets(0,50,0,0));
        content1.getChildren().addAll(subject1CB, subject1, subject1subclassesLW, framework1CB);     
        content1.setMargin(subject1subclassesLW, new Insets(-70,0,0,0));  
        content1.setMargin(framework1CB, new Insets(0,0,10,0));
        
    }
    private void SetupContent2(){
        
        JFXCheckBox subject2CB = new JFXCheckBox();        
        subject2CB.setMnemonicParsing(false);
        subject2CB.setOnAction(new EventHandler<ActionEvent>() {

    
    public void handle(ActionEvent event) {
        System.out.println("Hello World!");
    }
});
        subject2CB.setText("Lisää hakuun");
        JFXTextArea subject2 = new JFXTextArea();
        subject2.prefHeight(38.0);
        subject2.prefWidth(100.0);
        subject2.setPadding(new Insets(0,0,80,0));
        JFXListView subject2subclassesLW = new JFXListView();
        subject2subclassesLW.prefHeight(120.0);
        subject2subclassesLW.prefWidth(150.0);
        //subject2subclassesLW.setPadding(new Insets(50,50,50,50));        
        JFXComboBox framework2CB = new JFXComboBox();
        framework2CB.prefWidth(150);
        content2.getChildren().addAll(subject2CB, subject2, subject2subclassesLW, framework2CB);     
        content2.setMargin(subject2subclassesLW, new Insets(-70,0,0,0));
        content2.setMargin(framework2CB, new Insets(0,0,10,0));    
        //content2.setMargin(subject2subclassesLW, new Insets(0,-30,0,0)); 
    }    
    private void SetupContent3(){
        JFXCheckBox subject3CB = new JFXCheckBox();        
        subject3CB.setMnemonicParsing(false);
        subject3CB.setOnAction(new EventHandler<ActionEvent>() {

    
    public void handle(ActionEvent event) {
        System.out.println("Hello World!");
    }
});
        subject3CB.setText("Lisää hakuun");
        JFXTextArea subject3 = new JFXTextArea();
        subject3.prefHeight(38.0);
        subject3.prefWidth(100.0);
        subject3.setPadding(new Insets(0,0,80,0));
        JFXListView subject3subclassesLW = new JFXListView();
        subject3subclassesLW.prefHeight(120.0);
        subject3subclassesLW.prefWidth(150.0);        
        JFXComboBox framework3CB = new JFXComboBox();
        framework3CB.prefWidth(150);
        content3.getChildren().addAll(subject3CB, subject3, subject3subclassesLW, framework3CB);     
        content3.setMargin(subject3subclassesLW, new Insets(-70,0,0,0));
        content3.setMargin(framework3CB, new Insets(0,0,10,0));        
    }
    private void SetupContent4(){
        JFXCheckBox subject4CB = new JFXCheckBox();        
        subject4CB.setMnemonicParsing(false);
        subject4CB.setOnAction(new EventHandler<ActionEvent>() {

    
    public void handle(ActionEvent event) {
        System.out.println("Hello World!");
    }
});
        subject4CB.setText("Lisää hakuun");
        JFXTextArea subject4 = new JFXTextArea();
        subject4.prefHeight(38.0);
        subject4.prefWidth(100.0);
        subject4.setPadding(new Insets(0,0,80,0));
        JFXListView subject4subclassesLW = new JFXListView();
        subject4subclassesLW.prefHeight(120.0);
        subject4subclassesLW.prefWidth(150.0);        
        JFXComboBox framework4CB = new JFXComboBox();
        framework4CB.prefWidth(150);
        content4.getChildren().addAll(subject4CB, subject4, subject4subclassesLW, framework4CB);     
        content4.setMargin(subject4subclassesLW, new Insets(-70,0,0,0)); 
        content4.setMargin(framework4CB, new Insets(0,0,10,0));
    }    
}
