/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddNewThesis;

import static CentralClasses.MainWindow.mainStage;
import static CentralClasses.MainWindow.newScene;

import CentralClasses.MainWindow;
import CentralClasses.MainWindowController;
import CentralClasses.StartPageController;
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
    private JFXButton updateTF;
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
	private JFXTextField nameTF;
    @FXML
    private JFXTextField authorTF;
    @FXML
    private JFXTextField informantCountTF;
    @FXML
    private JFXTextField levelTF;
    @FXML
    private JFXTextField typeTF;
    @FXML
    private JFXTextField languageTF;
    @FXML
    private JFXTextField informant1TF;
    @FXML
    private JFXTextField informant3TF;
    @FXML
    private JFXTextField informant4TF;
    @FXML
    private JFXTextField informant13TF;
    @FXML
    private JFXTextField informant14TF;
    @FXML
    private JFXTextField informantOtherTF;
    @FXML
    private JFXTextField source1TF;
    @FXML
    private JFXTextField sourceOtherTF;
    @FXML
    private JFXTextField methodOtherTF;
    @FXML
    private JFXTextField contextOtherTF;
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
	
	public Thesis thesis;
    String excelURL = StartPageController.excelSource;   
	int i, arrayCounter=0;
	ArrayList<JFXCheckBox> checkBoxes = new ArrayList<JFXCheckBox>();
	/*
	 * Variables for the creation of a new thesis-object
	 */
	String year; 
    String[] authors;
    int intauthors;
    String name;
    String level; 
    String type; 
    String articles; 
    String language; 
    String authorcount; 
    String[] researchSubjects = new String[4];
    String[] researchConcepts;
    String[] researchMethods;
    String[] sources;
    String[] informants;
    String informantCount; 
    String[] classes;
    String[] context;
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
	levelTF.setEditable(false);
	typeTF.setEditable(false);
	languageTF.setEditable(false);
	methodOtherTF.setEditable(false);
	contextOtherTF.setEditable(false);
    }    

    @FXML
	public void BackToMainAction(ActionEvent event) throws IOException {
        mainStage = (Stage) BackToMain.getScene().getWindow();
        Parent root = FXMLLoader.load(MainWindowController.class.getResource("MainWindow.fxml"));
        newScene = new Scene(root, 1000, 700);  
        mainStage.setScene(newScene);         
    }
    
    public void unlockTextField() {
    	if(!levelCB.getSelectionModel().isEmpty()&&levelCB.getSelectionModel().getSelectedItem().startsWith("3")) {
    		levelTF.setEditable(true);
    	} else {
    		levelTF.clear();
    		levelTF.setEditable(false);
    	}
    	if(!typeCB.getSelectionModel().isEmpty()&&typeCB.getSelectionModel().getSelectedItem().startsWith("3")) {
    		typeTF.setEditable(true);
    	} else {
    		typeTF.clear();
    		typeTF.setEditable(false);
    	}
    	if(!languageCB.getSelectionModel().isEmpty()&&languageCB.getSelectionModel().getSelectedItem().startsWith("3")) {
    		languageTF.setEditable(true);
    	} else {
    		languageTF.clear();
    		languageTF.setEditable(false);
    	}

    	for(String s : datamethodsLW.getSelectionModel().getSelectedItems()) {
    		if(s.startsWith("1")) {
    			source1TF.setEditable(true);
    		} else  {
    			source1TF.setEditable(false);
    		}
    		if(s.startsWith("7")) {
    			sourceOtherTF.setEditable(true);
    		} else {
    			sourceOtherTF.setEditable(false);
    		}
    	}
    	
    	if(methodsLW.getSelectionModel().getSelectedItems().contains("10. Muu")) {
    		methodOtherTF.setEditable(true);
    	} else {
    		methodOtherTF.clear();
    		methodOtherTF.setEditable(false);
    	}
    	if(contextLW.getSelectionModel().getSelectedItems().contains("8. Muu")) {
    		contextOtherTF.setEditable(true);
    	} else {
    		contextOtherTF.clear();
    		contextOtherTF.setEditable(false);
    	}
    }
    
    public void AddThesis() {
    	if(!yearCB.getSelectionModel().isEmpty()) {
    		year=yearCB.getSelectionModel().getSelectedItem();
    	}
    	if(authorTF.getText()!=null&&!authorsCB.getSelectionModel().isEmpty()) {
    		if(authorsCB.getSelectionModel().getSelectedItem().startsWith("1")) {
    			authors = new String[1];
    			authors[0]=authorTF.getText();
    		} else if(authorsCB.getSelectionModel().getSelectedItem().startsWith("2")) {
    			authors = new String[2];
    			if(authorTF.getText().contains(",") && authors.length>1) {
        			authors[0]=authorTF.getText(0,authorTF.getText().indexOf(","));
        			authors[1]=authorTF.getText(authorTF.getText().indexOf(",")+2, authorTF.getText().length());
        		}
    		} 
    	}
    	if(nameTF.getText()!=null) {
    		name=nameTF.getText();
    	}
    	
    	if(!levelCB.getSelectionModel().isEmpty()) {
    		if(levelCB.getSelectionModel().getSelectedItem().contentEquals("3. Muu")) {
    			level=levelTF.getText();
    		} else {
    			level=levelCB.getSelectionModel().getSelectedItem();
    		}
    	}
    	if(!typeCB.getSelectionModel().isEmpty()) {
    		if(typeCB.getSelectionModel().getSelectedItem().contentEquals("3. Muu")) {
    			type=typeTF.getText();
    		} else {
    			type=typeCB.getSelectionModel().getSelectedItem();
    		}
    		
    	}
    	if(!articlesCB.getSelectionModel().isEmpty()) {
    		articles=articlesCB.getSelectionModel().getSelectedItem();
    	}
    	if(!languageCB.getSelectionModel().isEmpty()) {
    		if(languageCB.getSelectionModel().getSelectedItem().contentEquals("3. Muu")) {
    			language=languageTF.getText();
    		} else {
    			language=languageCB.getSelectionModel().getSelectedItem();
    		}
    		
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
    		arrayCounter=0;
    		for(String s : tasksLW.getSelectionModel().getSelectedItems()) {
    			arrayCounter++;
    		}
    		researchConcepts = new String[arrayCounter];
    		i=0;
    		for(String s : tasksLW.getSelectionModel().getSelectedItems()) {
        		researchConcepts[i]=s;
        		i++;
        	}
    	}
    	if(!methodsLW.getSelectionModel().isEmpty()) {
    		arrayCounter=0;
    		for(String s : methodsLW.getSelectionModel().getSelectedItems()) {
    			arrayCounter++;
    		}
    		researchMethods = new String[arrayCounter];
    		i=0;
    		for(String s : methodsLW.getSelectionModel().getSelectedItems()) {
        		researchMethods[i]=s;
        		i++;
        	}
    		if(methodsLW.getSelectionModel().getSelectedItems().contains("10. Muu")) {
    			researchMethods[arrayCounter-1] = methodOtherTF.getText();
    		}
    	}
    	if(!datamethodsLW.getSelectionModel().isEmpty()) {
    		arrayCounter=0;
    		for(String s : datamethodsLW.getSelectionModel().getSelectedItems()) {
    			arrayCounter++;
    		}
    		sources = new String[arrayCounter];
    		i=0;
    		for(String s : datamethodsLW.getSelectionModel().getSelectedItems()) {
    			sources[i]=s;
        		i++;
        	}
    		for(i=0;i<sources.length;i++) {
    			if(sources[i].startsWith("1")) {
    				sources[i]=sources[i]+": "+source1TF.getText();
    			}else if(sources[i].startsWith("7")) {
    				sources[i]=sources[i]+": "+sourceOtherTF.getText();
    			}
    		}
    		
    	}
    	if(!sourceLW.getSelectionModel().isEmpty()) {
    		arrayCounter=0;
    		for(String s : sourceLW.getSelectionModel().getSelectedItems()) {
    			arrayCounter++;
    		}
    		informants = new String[arrayCounter];
    		i=0;
    		for(String s : sourceLW.getSelectionModel().getSelectedItems()) {
    			informants[i]=s;
        		i++;
        	}
    		for(i=0;i<informants.length;i++) {
    			if(informants[i].startsWith("1")) {
    				informants[i]=informants[i]+": "+informant1TF.getText();
    			} else if(informants[i].startsWith("3")) {
    				informants[i]=informants[i]+": "+informant3TF.getText();
    			} else if(informants[i].startsWith("4")) {
    				informants[i]=informants[i]+": "+informant4TF.getText();
    			} else if(informants[i].startsWith("13")) {
    				informants[i]=informants[i]+": "+informant13TF.getText();
    			} else if(informants[i].startsWith("14")) {
    				informants[i]=informants[i]+": "+informant14TF.getText();
    			} else if(informants[i].startsWith("15")) {
    				informants[i]=informants[i]+": "+informantOtherTF.getText();
    			} 
    		}
    	}
    	if(informantCountTF.getText()!=null) {
    		informantCount=informantCountTF.getText();
    	}
    	arrayCounter=0;
		for(String s : subject1LW.getSelectionModel().getSelectedItems()) {
			arrayCounter++;
		}
		for(String s : subject2LW.getSelectionModel().getSelectedItems()) {
			arrayCounter++;
		}
		for(String s : subject3LW.getSelectionModel().getSelectedItems()) {
			arrayCounter++;
		}
		for(String s : subject4LW.getSelectionModel().getSelectedItems()) {
			arrayCounter++;
		}
		classes = new String[arrayCounter];

    	if(!subject1LW.getSelectionModel().isEmpty()) {
    		i=0;
    		for(String s : subject1LW.getSelectionModel().getSelectedItems()) {
        		classes[i]=s;
        		i++;
        	}
    	}
    	if(!subject2LW.getSelectionModel().isEmpty()) {
    		for(String s : subject2LW.getSelectionModel().getSelectedItems()) {
        		classes[i]=s;
        		i++;
        	}
    	}
    	if(!subject3LW.getSelectionModel().isEmpty()) {
    		for(String s : subject3LW.getSelectionModel().getSelectedItems()) {
        		classes[i]=s;
        		i++;
        	}
    	}
    	if(!subject4LW.getSelectionModel().isEmpty()) {
    		for(String s : subject4LW.getSelectionModel().getSelectedItems()) {
        		classes[i]=s;
        		i++;
        	}
    	}
    	if(!contextLW.getSelectionModel().isEmpty()) {
    		arrayCounter=0;
    		for(String s : contextLW.getSelectionModel().getSelectedItems()) {
    			arrayCounter++;
    		}
    		context = new String[arrayCounter];
    		i=0;
    		for(String s : contextLW.getSelectionModel().getSelectedItems()) {
        		context[i]=s;
        		i++;
        	}
    		if(contextLW.getSelectionModel().getSelectedItems().contains("8. Muu")) {
    			context[arrayCounter-1] = contextOtherTF.getText();
    		}
    	}
    	thesis=new Thesis(year, authors, name, level, type, articles, language, authorcount, researchSubjects, 
    			researchConcepts, researchMethods, sources, informants, informantCount, classes, context);
    	
    	Stage stage = (Stage) Confirm.getScene().getWindow();
    	AddPreviewController.initiatePreview(thesis);
    	try {
			MainWindow.PreviewScene(stage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//
    }
    
}
