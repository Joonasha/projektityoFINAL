/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchClasses;

import static CentralClasses.MainWindow.mainStage;
import static CentralClasses.MainWindow.newScene;
import CentralClasses.MainWindowController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author joonasha
 */
public class SeachGradesController implements Initializable {

    //public static Stage mainStage;
    //public static Scene newScene;
    //public static Parent root;    
	@FXML
	JFXTextField nameTF = new JFXTextField();
	@FXML
	JFXTextField authorsTF = new JFXTextField();
	@FXML
	JFXListView<String> thesesLW = new JFXListView<String>();
	@FXML
	JFXListView<String> conceptsLW = new JFXListView<String>();
	@FXML
	JFXListView<String> sourceLW = new JFXListView<String>();
	@FXML
	JFXListView<String> methodLW = new JFXListView<String>();
	@FXML
	JFXListView<String> datamethodLW = new JFXListView<String>();
	@FXML
	JFXListView<String> subjectsLW = new JFXListView<String>();
	@FXML
	JFXListView<String> subject1subclassesLW = new JFXListView<String>();
	@FXML
	JFXListView<String> subject2subclassesLW = new JFXListView<String>();
	@FXML
	JFXListView<String> subject3subclassesLW = new JFXListView<String>();
	@FXML
	JFXListView<String> subject4subclassesLW = new JFXListView<String>();
	@FXML
	JFXCheckBox subject1CB = new JFXCheckBox();
	@FXML
	JFXCheckBox subject2CB = new JFXCheckBox();
	@FXML
	JFXCheckBox subject3CB = new JFXCheckBox();
	@FXML
	JFXCheckBox subject4CB = new JFXCheckBox();
	@FXML
	JFXComboBox<String> yearCB = new JFXComboBox<String>();
	@FXML
	JFXComboBox<String> levelCB = new JFXComboBox<String>();
	@FXML
	JFXComboBox<String> typeCB = new JFXComboBox<String>();
	@FXML
	JFXComboBox<String> languageCB = new JFXComboBox<String>();
	@FXML
	JFXComboBox<String> authorsCB = new JFXComboBox<String>();
	@FXML
	JFXComboBox<String> framework1CB = new JFXComboBox<String>();
	@FXML
	JFXComboBox<String> framework2CB = new JFXComboBox<String>();
	@FXML
	JFXComboBox<String> framework3CB = new JFXComboBox<String>();
	@FXML
	JFXComboBox<String> framework4CB = new JFXComboBox<String>();
	@FXML
	JFXTextArea subject1 = new JFXTextArea();
	@FXML
	JFXTextArea subject2 = new JFXTextArea();
	@FXML
	JFXTextArea subject3 = new JFXTextArea();
	@FXML
	JFXTextArea subject4 = new JFXTextArea();
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
    private VBox content3 = new VBox();
    private VBox content4 = new VBox();
    @FXML
    private JFXButton BackToMain;
    @FXML
    private JFXButton Others;
    @FXML
    private JFXButton General;
    @FXML
    private Label nameLabel;
    @FXML
    private Label creatorsLabel;
    @FXML
    private Label yearLabel;
    @FXML
    private Label shapeLabel;
    @FXML
    private Label levelLabel;
    @FXML
    private Label lanquageLabel;
    @FXML
    private Label amountLabel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vbox1.setStyle("-fx-background-color:#94E2F7");
        vbox2.setStyle("-fx-background-color:#94E2F7");
        anchorpane.setStyle("-fx-background-color:#94E2F7");
        vboxMain.setStyle("-fx-background-color:white");
        
    }    
    @FXML
    private void GeneralAction(ActionEvent event) {
        contentMain.getChildren().clear();
        content1.getChildren().clear();
        content1 = new VBox();     
        content2.getChildren().clear();
        content2 = new VBox();
        content3.getChildren().clear();
        content4.getChildren().clear();
        
        content1.setPrefWidth(310); 
        //content1.setMaxWidth(310);
        content2.setPrefWidth(367);
        contentMain.setMargin(content1, new Insets(0,0,0,70));
        contentMain.setMargin(content2, new Insets(0,0,0,90));


        SetupGenContent1();
        SetupGenContent2();
    
        contentMain.getChildren().addAll(content1,content2);        
    }    
    private void SetupGenContent1(){        

        content1.getChildren().addAll(nameLabel, nameTF, creatorsLabel, authorsTF, yearLabel, yearCB, shapeLabel, typeCB);      

    }
    private void SetupGenContent2(){

        content2.getChildren().addAll(levelLabel, levelCB, lanquageLabel, languageCB, amountLabel, authorsCB); 

    }    
    @FXML
    private void ParadigmaButtonAction(ActionEvent event) {
        contentMain.getChildren().clear();
        content1.getChildren().clear();
        content1 = new VBox();     
        content2.getChildren().clear();
        content2 = new VBox();
        content3.getChildren().clear();
        content4.getChildren().clear();
        
        contentMain.setMargin(content1, new Insets(0,25,0,0));
        contentMain.setMargin(content2, new Insets(0,25,0,0));
        contentMain.setMargin(content3, new Insets(0,25,0,0));
        contentMain.setMargin(content4, new Insets(0,25,0,0)); 

        SetupParaContent1();
        SetupParaContent2();
        SetupParaContent3();
        SetupParaContent4();
        
        contentMain.getChildren().addAll(content1,content2,content3,content4);
  
    }
    private void SetupParaContent1(){
        subject1CB = new JFXCheckBox();        
        subject1CB.setMnemonicParsing(false);
        subject1CB.setOnAction(new EventHandler<ActionEvent>() {

    
    public void handle(ActionEvent event) {
        System.out.println("Hello World!");
    }
});
        subject1CB.setText("Lisää hakuun");
        subject1 = new JFXTextArea();
        subject1.prefHeight(38.0);
        subject1.prefWidth(100.0);
        subject1.setPadding(new Insets(0,0,80,0));
        subject1subclassesLW = new JFXListView();
        subject1subclassesLW.prefHeight(120.0);
        subject1subclassesLW.prefWidth(150.0);  
        framework1CB = new JFXComboBox();
        framework1CB.prefWidthProperty().bind(content1.widthProperty());
        framework1CB.maxWidth(750.0);
     
        content1.getChildren().addAll(subject1CB, subject1, subject1subclassesLW, framework1CB);    
        content1.setMargin(subject1, new Insets(10,0,0,0));
        content1.setMargin(subject1subclassesLW, new Insets(-70,0,0,0));  
        content1.setMargin(framework1CB, new Insets(10,0,10,0));
        
    }
    private void SetupParaContent2(){
               
        subject2CB.setMnemonicParsing(false);
        subject2CB.setOnAction(new EventHandler<ActionEvent>() {

    
    public void handle(ActionEvent event) {
        System.out.println("Hello World!");
    }
});
        subject2CB.setText("Lisää hakuun");
        subject2.prefHeight(38.0);
        subject2.prefWidth(100.0);
        subject2.setPadding(new Insets(0,0,80,0));
        subject2subclassesLW.prefHeight(120.0);
        subject2subclassesLW.prefWidth(150.0);       
        framework2CB.prefWidthProperty().bind(content2.widthProperty());
        content2.getChildren().addAll(subject2CB, subject2, subject2subclassesLW, framework2CB);  
        content2.setMargin(subject2, new Insets(10,0,0,0));        
        content2.setMargin(subject2subclassesLW, new Insets(-70,0,0,0));
        content2.setMargin(framework2CB, new Insets(10,0,10,0));    
    }    
    private void SetupParaContent3(){        
        subject3CB.setMnemonicParsing(false);
        subject3CB.setOnAction(new EventHandler<ActionEvent>() {

    
    public void handle(ActionEvent event) {
        System.out.println("Hello World!");
    }
});
        subject3CB.setText("Lisää hakuun");
        subject3 = new JFXTextArea();
        subject3.prefHeight(38.0);
        subject3.prefWidth(100.0);
        subject3.setPadding(new Insets(0,0,80,0));
        subject3subclassesLW = new JFXListView();
        subject3subclassesLW.prefHeight(120.0);
        subject3subclassesLW.prefWidth(150.0);        
        framework3CB = new JFXComboBox();
        framework3CB.prefWidthProperty().bind(content3.widthProperty());
        content3.getChildren().addAll(subject3CB, subject3, subject3subclassesLW, framework3CB);   
        content3.setMargin(subject3, new Insets(10,0,0,0));
        content3.setMargin(subject3subclassesLW, new Insets(-70,0,0,0));
        content3.setMargin(framework3CB, new Insets(10,0,10,0));        
    }
    private void SetupParaContent4(){
        subject4CB = new JFXCheckBox();        
        subject4CB.setMnemonicParsing(false);
        subject4CB.setOnAction(new EventHandler<ActionEvent>() {

    
    public void handle(ActionEvent event) {
        System.out.println("Hello World!");
    }
});
        subject4CB.setText("Lisää hakuun");
        subject4 = new JFXTextArea();
        subject4.prefHeight(38.0);
        subject4.prefWidth(100.0);
        subject4.setPadding(new Insets(0,0,80,0));
        subject4subclassesLW = new JFXListView();
        subject4subclassesLW.prefHeight(120.0);
        subject4subclassesLW.prefWidth(150.0);        
        framework4CB = new JFXComboBox();
        framework4CB.prefWidthProperty().bind(content4.widthProperty());
        content4.getChildren().addAll(subject4CB, subject4, subject4subclassesLW, framework4CB);   
        content4.setMargin(subject4, new Insets(10,0,0,0));        
        content4.setMargin(subject4subclassesLW, new Insets(-70,0,0,0)); 
        content4.setMargin(framework4CB, new Insets(10,0,10,0));
    }    


    @FXML
    private void OthersAction(ActionEvent event) {
        contentMain.getChildren().clear();
        content1.getChildren().clear();
        content1 = new VBox();      
        content2.getChildren().clear();
        content2 = new VBox();
        content3.getChildren().clear();
        content4.getChildren().clear();

        contentMain.setMargin(content1, new Insets(0,25,0,0));
        contentMain.setMargin(content2, new Insets(0,25,0,0));
        contentMain.setMargin(content3, new Insets(0,25,0,0));
        contentMain.setMargin(content4, new Insets(0,25,0,0)); 

        SetupOthersContent1();
        SetupOthersContent2();
        SetupOthersContent3();
        SetupOthersContent4();

        
        contentMain.getChildren().addAll(content1,content2,content3,content4);        
    }
    
    private void SetupOthersContent1(){
        Label text1 = new Label();        
        text1.setText("Tiedonhakumenetelmä");

        datamethodLW = new JFXListView();

        content1.getChildren().addAll(text1, datamethodLW);    
        content1.setMargin(text1, new Insets(10,0,0,5));
        content1.setMargin(datamethodLW, new Insets(10,0,10,0));  

    }
    
    private void SetupOthersContent2(){
        Label text2 = new Label();        
        text2.setText("Tutkimusmenetelmä");

        methodLW = new JFXListView();

        content2.getChildren().addAll(text2, methodLW);    
        content2.setMargin(text2, new Insets(10,5,0,5));
        content2.setMargin(methodLW, new Insets(10,0,10,0));  

    }

    private void SetupOthersContent3(){
        Label text3 = new Label();        
        text3.setText("Tehtävät");

        conceptsLW = new JFXListView();

        content3.getChildren().addAll(text3, conceptsLW);    
        content3.setMargin(text3, new Insets(10,5,0,5));
        content3.setMargin(conceptsLW, new Insets(10,0,10,0));  

    }

    private void SetupOthersContent4(){
        Label text4 = new Label();        
        text4.setText("Tietolähde");

        sourceLW = new JFXListView();

        content4.getChildren().addAll(text4, sourceLW);    
        content4.setMargin(text4, new Insets(10,5,0,5));
        content4.setMargin(sourceLW, new Insets(10,0,10,0));  

    }    

    @FXML
    public void BackToMainAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(MainWindowController.class.getResource("MainWindow.fxml"));
        newScene = new Scene(root, 1000, 700);  
        mainStage.setScene(newScene);        
    }


}
