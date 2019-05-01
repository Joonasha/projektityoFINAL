/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddNewThesis;

import static CentralClasses.MainWindow.mainStage;
import static CentralClasses.MainWindow.newScene;
import CentralClasses.MainWindowController;
import HelperClasses.Excel;
import HelperClasses.Thesis;
import HelperClasses.lists;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXScrollPane;
import com.jfoenix.controls.JFXTextField;

import java.awt.Dimension;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
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
    private JFXButton Confirm;
    @FXML
    private JFXComboBox<String> yearCB;
    @FXML
    private JFXComboBox<String> levelCB;
    @FXML
    private JFXComboBox<String> typeCB;
    @FXML
    private JFXComboBox<String> languageCB;
    @FXML
    private JFXComboBox<String> authorsCB;
    @FXML
    private JFXComboBox<String> articlesCB;
    @FXML
	private JFXTextField studyTF;
    @FXML
    private JFXTextField authorTF;
    @FXML
    private JFXTextField informantCountTF;
    @FXML
	private JFXListView<String> methodsLW;
    @FXML
	private JFXListView<String> tasksLW;
    @FXML
	private JFXListView<String> datamethodsLW;
    @FXML
	private JFXListView<String> sourceLW;
    @FXML
    private Label title;
    @FXML
    private ScrollPane scrollpane;
	@FXML
	private JFXListView<String> subject1LW;
	@FXML
	private JFXListView<String> subject2LW;
	@FXML
	private JFXListView<String> subject3LW;
	@FXML
	private JFXListView<String> subject4LW;
	@FXML
	private JFXListView<String> contextLW;
	@FXML
	private JFXCheckBox subject1Chk;
	@FXML
	private JFXCheckBox subject2Chk;
	@FXML
	private JFXCheckBox subject3Chk;
	@FXML
	private JFXCheckBox subject4Chk;
	
	Thesis thesis;
	String excelURL = "Testiaineisto.xlsx";
	int i;
	/*
	 * Variables for the creation of a new thesis-object
	 */
	String year; 
    String[] authors = new String[2]; 
    String name;
    String level; 
    String type; 
    String articles; 
    String language; 
    String authorcount; 
    String[] researchSubjects = new String[4]; 
    String[] researchConcepts = new String[4]; 
    String[] researchMethods = new String[10];
    String[] sources = new String[7]; 
    String[] informants = new String[15]; 
    String informantCount; 
    String[] classes = new String[21]; 
    String[] context = new String[8]; 
    String pggrade; 
    String dtgrade;
  
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    anchorpane.setStyle("-fx-background-color:white");
    mainLayout.setStyle("-fx-background-color:white");
    yearCB.setItems(lists.listYears);
	levelCB.setItems(lists.listLevels);
	typeCB.setItems(lists.listTypes);
	languageCB.setItems(lists.listLanguages);
	authorsCB.setItems(lists.listNumberofAuthors);
	articlesCB.setItems(lists.listNumberofArticles);
	tasksLW.setItems(lists.listTasks);
	tasksLW.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	methodsLW.setItems(lists.listMethods);
	methodsLW.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	datamethodsLW.setItems(lists.listDatamethods);
	datamethodsLW.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	sourceLW.setItems(lists.listSources);
	sourceLW.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	subject1LW.setItems(lists.subject1subclasses);
	subject1LW.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	subject2LW.setItems(lists.subject2subclasses);
	subject2LW.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	subject3LW.setItems(lists.subject3subclasses);
	subject3LW.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	subject4LW.setItems(lists.subject4subclasses);
	subject4LW.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	contextLW.setItems(lists.listContext);
	contextLW.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }    

    @FXML
    private void BackToMainAction(ActionEvent event) throws IOException {
        mainStage = (Stage) BackToMain.getScene().getWindow();
        Parent root = FXMLLoader.load(MainWindowController.class.getResource("MainWindow.fxml"));
        newScene = new Scene(root, 1000, 700);  
        mainStage.setScene(newScene);         
    }
    
    public void AddThesis() {
    	if(!yearCB.getSelectionModel().isEmpty()) {
    		year=yearCB.getSelectionModel().getSelectedItem();
    	}
    	if(authorTF.getText()!=null) {
    		if(authorTF.getText().contains(",")) {
    			authors[0]=authorTF.getText(0,authorTF.getText().indexOf(","));
    			authors[1]=authorTF.getText(authorTF.getText().indexOf(","), authorTF.getText().length());
    		} else {
    			authors[0]=authorTF.getText();
    		}
    	}
    	if(studyTF.getText()!=null) {
    		name=studyTF.getText();
    	}
    	if(!levelCB.getSelectionModel().isEmpty()) {
    		level=levelCB.getSelectionModel().getSelectedItem();
    	}
    	if(!typeCB.getSelectionModel().isEmpty()) {
    		type=typeCB.getSelectionModel().getSelectedItem();
    	}
    	if(!articlesCB.getSelectionModel().isEmpty()) {
    		articles=articlesCB.getSelectionModel().getSelectedItem();
    	}
    	if(!languageCB.getSelectionModel().isEmpty()) {
    		language=languageCB.getSelectionModel().getSelectedItem();
    	}
    	if(!authorsCB.getSelectionModel().isEmpty()) {
    		authorcount=authorsCB.getSelectionModel().getSelectedItem();
    	}
    	if(subject1Chk.isSelected()) {
			if(researchSubjects[0]==null) {
				researchSubjects[0]=lists.listSubjects.get(0);
			} else if(researchSubjects[1]==null) {
				researchSubjects[1]=lists.listSubjects.get(0);
			} else if(researchSubjects[2]==null) {
				researchSubjects[2]=lists.listSubjects.get(0);
			} else if(researchSubjects[3]==null) {
				researchSubjects[3]=lists.listSubjects.get(0);
			}
		}
    	if(subject2Chk.isSelected()) {
			if(researchSubjects[0]==null) {
				researchSubjects[0]=lists.listSubjects.get(1);
			} else if(researchSubjects[1]==null) {
				researchSubjects[1]=lists.listSubjects.get(1);
			} else if(researchSubjects[2]==null) {
				researchSubjects[2]=lists.listSubjects.get(1);
			} else if(researchSubjects[3]==null) {
				researchSubjects[3]=lists.listSubjects.get(1);
			}
		}
    	if(subject3Chk.isSelected()) {
			if(researchSubjects[0]==null) {
				researchSubjects[0]=lists.listSubjects.get(2);
			} else if(researchSubjects[1]==null) {
				researchSubjects[1]=lists.listSubjects.get(2);
			} else if(researchSubjects[2]==null) {
				researchSubjects[2]=lists.listSubjects.get(2);
			} else if(researchSubjects[3]==null) {
				researchSubjects[3]=lists.listSubjects.get(2);
			}
		}
    	if(subject4Chk.isSelected()) {
			if(researchSubjects[0]==null) {
				researchSubjects[0]=lists.listSubjects.get(3);
			} else if(researchSubjects[1]==null) {
				researchSubjects[1]=lists.listSubjects.get(3);
			} else if(researchSubjects[2]==null) {
				researchSubjects[2]=lists.listSubjects.get(3);
			} else if(researchSubjects[3]==null) {
				researchSubjects[3]=lists.listSubjects.get(3);
			}
		}
 
    	
    	if(!tasksLW.getSelectionModel().isEmpty()) {
    		i=0;
    		for(String s : tasksLW.getSelectionModel().getSelectedItems()) {
        		researchConcepts[i]=s;
        		i++;
        	}
    	}
    	if(!methodsLW.getSelectionModel().isEmpty()) {
    		i=0;
    		for(String s : methodsLW.getSelectionModel().getSelectedItems()) {
        		researchMethods[i]=s;
        		i++;
        	}
    	}
    	if(!datamethodsLW.getSelectionModel().isEmpty()) {
    		i=0;
    		for(String s : datamethodsLW.getSelectionModel().getSelectedItems()) {
        		sources[i]=s;
        		i++;
        	}
    	}
    	if(!sourceLW.getSelectionModel().isEmpty()) {
    		i=0;
    		for(String s : sourceLW.getSelectionModel().getSelectedItems()) {
        		informants[i]=s;
        		i++;
        	}
    	}
    	if(informantCountTF.getText()!=null) {
    		informantCount=informantCountTF.getText();
    	}
    	if(!subject1LW.getSelectionModel().isEmpty()) {
    		i=0;
    		for(String s : subject1LW.getSelectionModel().getSelectedItems()) {
        		classes[i]=s;
        		i++;
        	}
    	}
    	if(!subject1LW.getSelectionModel().isEmpty()) {
    		for(String s : subject2LW.getSelectionModel().getSelectedItems()) {
        		classes[i]=s;
        		i++;
        	}
    	}
    	if(!subject1LW.getSelectionModel().isEmpty()) {
    		for(String s : subject3LW.getSelectionModel().getSelectedItems()) {
        		classes[i]=s;
        		i++;
        	}
    	}
    	if(!subject1LW.getSelectionModel().isEmpty()) {
    		for(String s : subject4LW.getSelectionModel().getSelectedItems()) {
        		classes[i]=s;
        		i++;
        	}
    	}
    	if(!contextLW.getSelectionModel().isEmpty()) {
    		i=0;
    		for(String s : contextLW.getSelectionModel().getSelectedItems()) {
        		context[i]=s;
        		i++;
        	}
    	}
    	thesis=new Thesis(year, authors, name, level, articles, language, authorcount, researchSubjects, 
    			researchConcepts, researchMethods, sources, informants, informantCount, classes, context);
    	Excel.addNewThesis(thesis, excelURL);
    }
    
}
