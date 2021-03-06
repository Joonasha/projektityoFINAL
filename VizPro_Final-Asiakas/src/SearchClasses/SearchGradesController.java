/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchClasses;

import CentralClasses.MainWindow;
import static CentralClasses.MainWindow.mainStage;
import static CentralClasses.MainWindow.newScene;
import CentralClasses.MainWindowController;
import CentralClasses.StartPageController;
import HelperClasses.Excel;
import HelperClasses.Thesis;
import HelperClasses.lists;
import Visualization.ChartsController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author joonasha
 */
public class SearchGradesController implements Initializable {

    //public static Stage mainStage;
    //public static Scene newScene;
    //public static Parent root;
    @FXML
    JFXTextField nameTF = new JFXTextField();
    @FXML
    JFXTextField authorsTF = new JFXTextField();
    @FXML
    TableView<Grade> thesesTW;
    //TableView<String> thesesLW = new TableView<String>();
    JFXListView<String> conceptsLW = new JFXListView<String>();
    JFXListView<String> sourceLW = new JFXListView<String>();
    JFXListView<String> methodLW = new JFXListView<String>();
    JFXListView<String> datamethodLW = new JFXListView<String>();
    JFXListView<String> subjectsLW = new JFXListView<String>();
    JFXListView<String> subject1subclassesLW = new JFXListView<String>();
    JFXListView<String> subject2subclassesLW = new JFXListView<String>();
    JFXListView<String> subject3subclassesLW = new JFXListView<String>();
    JFXListView<String> subject4subclassesLW = new JFXListView<String>();
    JFXCheckBox subject1CB = new JFXCheckBox();
    JFXCheckBox subject2CB = new JFXCheckBox();
    JFXCheckBox subject3CB = new JFXCheckBox();
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
    JFXComboBox<String> framework1CB = new JFXComboBox<String>();
    JFXComboBox<String> framework2CB = new JFXComboBox<String>();
    JFXComboBox<String> framework3CB = new JFXComboBox<String>();
    JFXComboBox<String> framework4CB = new JFXComboBox<String>();
    //TextArea subject1 = new TextArea();
    //JFXTextArea subject2 = new JFXTextArea();
    //JFXTextArea subject3 = new JFXTextArea();
    //JFXTextArea subject4 = new JFXTextArea();
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
    int i;
    
    ObservableList<String> nameTheses = FXCollections.observableArrayList();
    ObservableList<Grade> nameTheses2 = FXCollections.observableArrayList();
    //String excelSource = "Testiaineisto.xlsx";
    String excelSource = StartPageController.excelSource;    
    ArrayList<Thesis> theses = Excel.readData(excelSource);
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> tmpSubjects = new ArrayList<String>();
    ArrayList<String> tmpSubclass1 = new ArrayList<String>();
    ArrayList<String> tmpSubclass2 = new ArrayList<String>();
    ArrayList<String> tmpSubclass3 = new ArrayList<String>();
    ArrayList<String> tmpSubclass4 = new ArrayList<String>();
    ArrayList<String> tmpConcepts = new ArrayList<String>();
    ArrayList<String> tmpSources = new ArrayList<String>();
    ArrayList<String> tmpMethods = new ArrayList<String>();
    ArrayList<String> tmpInformants = new ArrayList<String>();
    @FXML
    private Label title;
    @FXML
    private JFXButton VisualizationButton;
    //t�st� nimi lista:
    //ObservableList<Grade> testNameTheses = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Grade, String> ratingCol;
    @FXML
    private TableColumn<Grade, String> nameCol;
    @FXML
    private JFXButton rateButton;
    @FXML
    private JFXButton DeleteButton;

    private String getGrade;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vbox1.setStyle("-fx-background-color:#94E2F7");
        vbox2.setStyle("-fx-background-color:#94E2F7");
        anchorpane.setStyle("-fx-background-color:#94E2F7");
        vboxMain.setStyle("-fx-background-color:white");
        nameCol.prefWidthProperty().bind(thesesTW.widthProperty().subtract(300));
        ratingCol.setPrefWidth(185);
        //ratingCol.prefWidthProperty().bind(thesesLW.widthProperty().subtract(660));
        /*
                                   <columnResizePolicy>
                               <TableView fx:constant="CONSTRAINED_RESIZE_POLICY" />
                           </columnResizePolicy> 
         */
        listTheses();
        //nameTheses.add(new Grade(rating, name));
        //thesesLW.setItems(nameTheses);
        thesesTW.getItems().setAll(nameTheses2);
        yearCB.setItems(lists.listYears);
        levelCB.setItems(lists.listLevels);
        typeCB.setItems(lists.listTypes);
        languageCB.setItems(lists.listLanguages);
        authorsCB.setItems(lists.listNumberofAuthors);
        framework1CB.setItems(lists.subject1frameworks);
        framework2CB.setItems(lists.subject2frameworks);
        framework3CB.setItems(lists.subject3frameworks);
        framework4CB.setItems(lists.subject4frameworks);
        subject1subclassesLW.setItems(lists.subject1subclasses);
        subject1subclassesLW.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        subject2subclassesLW.setItems(lists.subject2subclasses);
        subject2subclassesLW.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        subject3subclassesLW.setItems(lists.subject3subclasses);
        subject3subclassesLW.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        subject4subclassesLW.setItems(lists.subject4subclasses);
        subject4subclassesLW.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        subjectsLW.setItems(lists.listSubjects);
        //subject1.setText(lists.listSubjects.get(0));
        //subject2.setText(lists.listSubjects.get(1));
        //subject3.setText(lists.listSubjects.get(2));
        //subject4.setText(lists.listSubjects.get(3));
        sourceLW.setItems(lists.listSources);
        sourceLW.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        conceptsLW.setItems(lists.listTasks);
        conceptsLW.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        methodLW.setItems(lists.listMethods);
        methodLW.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        datamethodLW.setItems(lists.listDatamethods);
        datamethodLW.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        initCol();
    }

    private void initCol() {
        ratingCol.setCellValueFactory(new PropertyValueFactory<>("rating"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
    }

    public void listTheses() {
        for (Thesis e : theses) {
            nameTheses.add(e.getName());
            nameTheses2.add(new Grade(e.getPggrade(), e.getName()));
            //e.getGradesRating(e.getName())
        }
    }

    @FXML
    public void updateList() {
        thesesTW.getItems().clear();
        //names.clear();
        nameTheses2.clear();
        nameTheses.clear();
        for (Thesis e : theses) {
            if(checkYear(e)) {
            	if(checkName(e)) {
            		if(checkAuthor(e)) {
            			if (checkType(e)) {
            				if (checkLevel(e)) {
    	                        if (checkLanguage(e)) {
    	                            if (checkNumberofauthors(e)) {
    	                                if (checkResearchsubjects(e)) {
    	                                    if (checkResearchConcepts(e)) {
    	                                    	if(checkResearchMethods(e)) {
    	                                    		if(checkSources(e)) {
    	                                    			if(checkInformants(e)) {
    	                                    				if(checkSubject1(e)) {
    	                                    					if(checkSubject2(e)) {
    	                                    						if(checkSubject3(e)) {
    	                                    							if(checkSubject4(e)) {
    	                                    								if (e.getDtgrade() != null) {
    	                        	                                            getGrade = e.getDtgrade();
    	                        	                                        } else {
    	                        	                                            getGrade = e.getPggrade();
    	                        	                                        }
    	                        	                                        nameTheses2.add(new Grade(getGrade, e.getName()));
    	                        	                                        nameTheses.add(e.getName());
    	                                    							}
    	                                    						}
    	                                    					}
    	                                    				}
    	                                    			}
    	                                    		}
    	                                    	}
    	                                    }
    	                                }
    	                            }
    	                        }
    	                    }
    	                } 
            		}    
            	}
            }	  	
        }

        //thesesLW.setItems(FXCollections.observableArrayList(names));	
        //thesesLW.setItems(nameTheses);
        thesesTW.getItems().setAll(nameTheses2);
    }

    public boolean checkAuthor(Thesis e) {
    	if(authorsTF.getText()=="") {
    		return true;
    	} else {
    		for(String s : e.getAuthors()) {
    			if(s.contains(authorsTF.getText())) {
    				return true;
    			}
    		}
    		return false;
    	}
    	
    }
    
    public boolean checkName(Thesis e) {
    	if(nameTF.getText()=="") {
    		return true;
    	} else if(e.getName().contains(nameTF.getText())) {
    		return true;
    	} else {
    		return false;
    	}
    	
    }
    
    public boolean checkYear(Thesis e) {
        if (yearCB.getValue() == null) {
            return true;
        } else if (yearCB.getValue().equals(e.getYear().substring(0, 4))) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkType(Thesis e) {
        if (typeCB.getValue() == null) {
            return true;
        } else if (typeCB.getValue().equals(e.getType())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkLevel(Thesis e) {
        if (levelCB.getValue() == null) {
            return true;
        } else if (levelCB.getValue().equals(e.getLevel())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkLanguage(Thesis e) {
        if (languageCB.getValue() == null) {
            return true;
        } else if (languageCB.getValue().equals(e.getLanguage())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkNumberofauthors(Thesis e) {
        if (authorsCB.getValue() == null) {
            return true;
        } else if (authorsCB.getValue().equals(e.getAuthorcount())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkResearchsubjects(Thesis e) {
        for (i = 0; i < e.getResearchSubjects().length; i++) {
            tmpSubjects.add(e.getResearchSubjects()[i]);
        }
        if (!subject1CB.isSelected()
                && !subject2CB.isSelected()
                && !subject3CB.isSelected()
                && !subject4CB.isSelected()) {
            tmpSubjects.clear();
            return true;
        } else if (subject1CB.isSelected() && tmpSubjects.contains(lists.listSubjects.get(0))) {
            tmpSubjects.clear();
            return true;
        } else if (subject2CB.isSelected() && tmpSubjects.contains(lists.listSubjects.get(1))) {
            tmpSubjects.clear();
            return true;
        } else if (subject3CB.isSelected() && tmpSubjects.contains(lists.listSubjects.get(2))) {
            tmpSubjects.clear();
            return true;
        } else if (subject4CB.isSelected() && tmpSubjects.contains(lists.listSubjects.get(3))) {
            tmpSubjects.clear();
            return true;
        } else {
            tmpSubjects.clear();
        }
        return false;
    }

    public boolean checkSubject1(Thesis e) {
    	tmpSubclass1.clear();
        if (!subject1subclassesLW.getSelectionModel().isEmpty()) {
            if (e.getClasses() != null) {
                for (i = 0; i < e.getClasses().length; i++) {
                	tmpSubclass1.add(e.getClasses()[i]);
                }
            }
        }
        if (subject1subclassesLW.getSelectionModel().isEmpty()) {
        	tmpSubclass1.clear();
            return true;
        }
        if (tmpSubclass1.contains(subject1subclassesLW.getSelectionModel().getSelectedItem())) {
        	tmpSubclass1.clear();
            return true;
        } else {
            System.out.println(tmpSubclass1);
        }
        tmpSubclass1.clear();
        return false;
    }
    public boolean checkSubject2(Thesis e) {
    	tmpSubclass2.clear();
        if (!subject2subclassesLW.getSelectionModel().isEmpty()) {
            if (e.getClasses() != null) {
                for (i = 0; i < e.getClasses().length; i++) {
                	tmpSubclass2.add(e.getClasses()[i]);
                }
            }
        }
        if (subject2subclassesLW.getSelectionModel().isEmpty()) {
        	tmpSubclass2.clear();
            return true;
        }
        if (tmpSubclass2.contains(subject2subclassesLW.getSelectionModel().getSelectedItem())) {
        	tmpSubclass2.clear();
            return true;
        } else {
            System.out.println(tmpSubclass2);
        }
        tmpSubclass2.clear();
        return false;
    }
    public boolean checkSubject3(Thesis e) {
    	tmpSubclass3.clear();
        if (!subject3subclassesLW.getSelectionModel().isEmpty()) {
            if (e.getClasses() != null) {
                for (i = 0; i < e.getClasses().length; i++) {
                	tmpSubclass3.add(e.getClasses()[i]);
                }
            }
        }
        if (subject3subclassesLW.getSelectionModel().isEmpty()) {
        	tmpSubclass3.clear();
            return true;
        }
        if (tmpSubclass3.contains(subject3subclassesLW.getSelectionModel().getSelectedItem())) {
        	tmpSubclass3.clear();
            return true;
        } else {
            System.out.println(tmpSubclass3);
        }
        tmpSubclass3.clear();
        return false;
    }
    public boolean checkSubject4(Thesis e) {
    	tmpSubclass4.clear();
        if (!subject4subclassesLW.getSelectionModel().isEmpty()) {
            if (e.getClasses() != null) {
                for (i = 0; i < e.getClasses().length; i++) {
                	tmpSubclass4.add(e.getClasses()[i]);
                }
            }
        }
        if (subject4subclassesLW.getSelectionModel().isEmpty()) {
        	tmpSubclass4.clear();
            return true;
        }
        if (tmpSubclass4.contains(subject4subclassesLW.getSelectionModel().getSelectedItem())) {
        	tmpSubclass4.clear();
            return true;
        } else {
            System.out.println(tmpSubclass4);
        }
        tmpSubclass4.clear();
        return false;
    }
    public boolean checkResearchMethods(Thesis e) {
    	tmpMethods.clear();
        if (!methodLW.getSelectionModel().isEmpty()) {
            if (e.getResearchMethods() != null) {
                for (i = 0; i < e.getResearchMethods().length; i++) {
                	tmpMethods.add(e.getResearchMethods()[i]);
                }
            }
        }
        if (methodLW.getSelectionModel().isEmpty()) {
        	tmpMethods.clear();
            return true;
        }
        if (tmpMethods.contains(methodLW.getSelectionModel().getSelectedItem())) {
        	tmpMethods.clear();
            return true;
        } else {
            System.out.println(tmpMethods);
        }
        tmpMethods.clear();
        return false;
    }
    public boolean checkSources(Thesis e) {
    	tmpSources.clear();
        if (!datamethodLW.getSelectionModel().isEmpty()) {
            if (e.getSources() != null) {
                for (i = 0; i < e.getSources().length; i++) {
                	tmpSources.add(e.getSources()[i].substring(0,1));
                }
            }
        }
        if (datamethodLW.getSelectionModel().isEmpty()) {
        	tmpSources.clear();
            return true;
        }
        if (tmpSources.contains(datamethodLW.getSelectionModel().getSelectedItem().substring(0,1))) {
        	tmpSources.clear();
            return true;
        } else {
            System.out.println(tmpSources);
        }
        tmpSources.clear();
        return false;
    }
    public boolean checkInformants(Thesis e) {
    	tmpInformants.clear();
        if (!sourceLW.getSelectionModel().isEmpty()) {
            if (e.getInformants() != null) {
                for (i = 0; i < e.getInformants().length; i++) {
                	tmpInformants.add(e.getInformants()[i].substring(0,2));
                }
            }
        }
        if (sourceLW.getSelectionModel().isEmpty()) {
        	tmpInformants.clear();
            return true;
        }
        if (tmpInformants.contains(sourceLW.getSelectionModel().getSelectedItem().substring(0,2))) {
        	tmpInformants.clear();
            return true;
        } else {
            System.out.println(tmpInformants);
        }
        tmpSources.clear();
        return false;
    }
    public boolean checkResearchConcepts(Thesis e) {
        tmpConcepts.clear();
        if (!conceptsLW.getSelectionModel().isEmpty()) {
            if (e.getResearchConcepts() != null) {
                for (i = 0; i < e.getResearchConcepts().length; i++) {
                    tmpConcepts.add(e.getResearchConcepts()[i]);
                }
            }
        }
        if (conceptsLW.getSelectionModel().isEmpty()) {
            tmpConcepts.clear();
            return true;
        }
        if (tmpConcepts.contains(conceptsLW.getSelectionModel().getSelectedItem())) {
            tmpConcepts.clear();
            return true;
        } else {
            System.out.println(tmpConcepts);
        }
        tmpConcepts.clear();
        return false;
    }

    @FXML
    public void visualize() throws IOException {
        lists.visualTheses.clear();
        for (Thesis t : theses) {
            if (nameTheses.contains((t.getName()))) {
                lists.visualTheses.add(t);
            }
        }
        if (!yearCB.getSelectionModel().isEmpty()) {
            for (String s : lists.listYears) {
                if (!yearCB.getSelectionModel().getSelectedItem().contentEquals(s)) {
                    ChartsController.selectedYears.add(s);
                    ChartsController.filtered = true;
                    ChartsController.filteredYear = yearCB.getSelectionModel().getSelectedItem();
                }
            }
        }
        VisualizationScene();
    }

    private void VisualizationScene() throws IOException {
        mainStage = (Stage) VisualizationButton.getScene().getWindow();
        //ScrollPane root = (ScrollPane) FXMLLoader.load(ChartsController.class.getResource("Charts.fxml"));
        Parent root = FXMLLoader.load(ChartsController.class.getResource("Charts.fxml"));
        newScene = new Scene(root, 1000, 700);
        mainStage.setScene(newScene);
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
        contentMain.setMargin(content1, new Insets(0, 0, 0, 70));
        contentMain.setMargin(content2, new Insets(0, 0, 0, 90));

        SetupGenContent1();
        SetupGenContent2();

        contentMain.getChildren().addAll(content1, content2);
    }

    private void SetupGenContent1() {

        content1.getChildren().addAll(nameLabel, nameTF, creatorsLabel, authorsTF, yearLabel, yearCB, shapeLabel, typeCB);

    }

    private void SetupGenContent2() {

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

        contentMain.setMargin(content1, new Insets(0, 25, 0, 0));
        contentMain.setMargin(content2, new Insets(0, 25, 0, 0));
        contentMain.setMargin(content3, new Insets(0, 25, 0, 0));
        contentMain.setMargin(content4, new Insets(0, 25, 0, 0));

        SetupParaContent1();
        SetupParaContent2();
        SetupParaContent3();
        SetupParaContent4();

        content1.setPrefWidth(300);
        content2.setPrefWidth(300);
        content3.setPrefWidth(300);
        content4.setPrefWidth(300);
        contentMain.getChildren().addAll(content1, content2, content3, content4);

    }

    private void SetupParaContent1() {
        subject1CB.setMnemonicParsing(false);
        subject1CB.setText("Lis�� hakuun");
        Label text1 = new Label();
        text1.setText("1. Toimintaprosessien tiedon hallinnan organisointi ja ohjaus");
        text1.setPadding(new Insets(0, 0, 80, 0));
        //subject1.prefHeight(38.0);
        //subject1.prefWidth(100.0);
        //subject1.setPadding(new Insets(0,0,80,0));
        subject1subclassesLW.prefHeight(120.0);
        subject1subclassesLW.prefWidth(150.0);
        //framework1CB.prefWidthProperty().bind(content1.widthProperty());
        //framework1CB.maxWidth(750.0);

        content1.getChildren().addAll(subject1CB, text1, subject1subclassesLW);
        content1.setMargin(text1, new Insets(10, 0, 0, 0));
        content1.setMargin(subject1subclassesLW, new Insets(-70, 0, 0, 0));
        content1.setMargin(framework1CB, new Insets(10, 0, 10, 0));

    }

    private void SetupParaContent2() {

        subject2CB.setMnemonicParsing(false);
        subject2CB.setText("Lisää hakuun");
        Label text2 = new Label();
        text2.setText("2. Tieto- ja viestint�tekniikan k�ytt�");
        text2.setPadding(new Insets(0, 0, 80, 0));
        //subject2.prefHeight(38.0);
        //subject2.prefWidth(100.0);
        //subject2.setPadding(new Insets(0,0,80,0));
        subject2subclassesLW.prefHeight(120.0);
        subject2subclassesLW.prefWidth(350.0);
        //framework2CB.prefWidthProperty().bind(content2.widthProperty());
        content2.getChildren().addAll(subject2CB, text2, subject2subclassesLW);
        content2.setMargin(text2, new Insets(10, 0, 0, 0));
        content2.setMargin(subject2subclassesLW, new Insets(-70, 0, 0, 0));
        content2.setMargin(framework2CB, new Insets(10, 0, 10, 0));
    }

    private void SetupParaContent3() {
        subject3CB.setMnemonicParsing(false);
        subject3CB.setText("Lis�� hakuun");
        Label text3 = new Label();
        text3.setText("3. Tiedonhallinnan osaaminen ja tiedolla johtaminen");
        text3.setPadding(new Insets(0, 0, 80, 0));
        //subject3.prefHeight(38.0);
        //subject3.prefWidth(100.0);
        //subject3.setPadding(new Insets(0,0,80,0));
        subject3subclassesLW.prefHeight(120.0);
        subject3subclassesLW.prefWidth(150.0);
        //framework3CB.prefWidthProperty().bind(content3.widthProperty());
        content3.getChildren().addAll(subject3CB, text3, subject3subclassesLW);
        content3.setMargin(text3, new Insets(10, 0, 0, 0));
        content3.setMargin(subject3subclassesLW, new Insets(-70, 0, 0, 0));
        content3.setMargin(framework3CB, new Insets(10, 0, 10, 0));
    }

    private void SetupParaContent4() {
        subject4CB.setMnemonicParsing(false);
        subject4CB.setText("Lis�� hakuun");
        Label text4 = new Label();
        text4.setText("4. Tietorakenteet- ja mallit");
        text4.setPadding(new Insets(0, 0, 80, 0));
        //subject4.prefHeight(38.0);
        //subject4.prefWidth(100.0);
        //subject4.setPadding(new Insets(0,0,80,0));
        subject4subclassesLW.prefHeight(120.0);
        subject4subclassesLW.prefWidth(150.0);
        //framework4CB.prefWidthProperty().bind(content4.widthProperty());
        content4.getChildren().addAll(subject4CB, text4, subject4subclassesLW);
        content4.setMargin(text4, new Insets(10, 0, 0, 0));
        content4.setMargin(subject4subclassesLW, new Insets(-70, 0, 0, 0));
        content4.setMargin(framework4CB, new Insets(10, 0, 10, 0));
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

        contentMain.setMargin(content1, new Insets(0, 25, 0, 0));
        contentMain.setMargin(content2, new Insets(0, 25, 0, 0));
        contentMain.setMargin(content3, new Insets(0, 25, 0, 0));
        contentMain.setMargin(content4, new Insets(0, 25, 0, 0));

        SetupOthersContent1();
        SetupOthersContent2();
        SetupOthersContent3();
        SetupOthersContent4();

        contentMain.getChildren().addAll(content1, content2, content3, content4);
    }

    private void SetupOthersContent1() {
        Label text1 = new Label();
        text1.setText("Tiedonhakumenetelm�t");

        content1.getChildren().addAll(text1, datamethodLW);
        content1.setMargin(text1, new Insets(10, 0, 0, 5));
        content1.setMargin(datamethodLW, new Insets(10, 0, 10, 0));

    }

    private void SetupOthersContent2() {
        Label text2 = new Label();
        text2.setText("Tutkimusmenetelm�");

        content2.getChildren().addAll(text2, methodLW);
        content2.setMargin(text2, new Insets(10, 5, 0, 5));
        content2.setMargin(methodLW, new Insets(10, 0, 10, 0));

    }

    private void SetupOthersContent3() {
        Label text3 = new Label();
        text3.setText("Teht�v�t");

        content3.getChildren().addAll(text3, conceptsLW);
        content3.setMargin(text3, new Insets(10, 5, 0, 5));
        content3.setMargin(conceptsLW, new Insets(10, 0, 10, 0));

    }

    private void SetupOthersContent4() {
        Label text4 = new Label();
        text4.setText("Tietol�hde");

        content4.getChildren().addAll(text4, sourceLW);
        content4.setMargin(text4, new Insets(10, 5, 0, 5));
        content4.setMargin(sourceLW, new Insets(10, 0, 10, 0));

    }

    @FXML
    public void BackToMainAction(ActionEvent event) throws IOException {
        mainStage = (Stage) BackToMain.getScene().getWindow();
        Parent root = FXMLLoader.load(MainWindowController.class.getResource("MainWindow.fxml"));
        newScene = new Scene(root, 1000, 700);
        mainStage.setScene(newScene);
    }

    @FXML
    private void rateGrade(ActionEvent event) {
        String name = thesesTW.getSelectionModel().getSelectedItem().getName();
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setContentText("Valittuna: '" + name + "'   Arvosana:");
        dialog.showAndWait();
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            //arvosanan muutos
        }
    }

    @FXML
    private void delete(ActionEvent event) {
        String name = thesesTW.getSelectionModel().getSelectedItem().getName();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Poistetaanko ' " + name + " '?");
        alert.showAndWait();
        if (alert.getResult() == ButtonType.OK) {
            thesesTW.getItems().removeAll(thesesTW.getSelectionModel().getSelectedItem());
            Thesis thesis = null;
            for (Thesis e : theses) {
                if (e.getName() == name) {
                    thesis = e;
                }
            }
            //osoit valittavaksi!
            Excel.removeThesis(thesis, excelSource);
        }

    }

    public static class Grade {

        private final SimpleStringProperty rating;
        private final SimpleStringProperty name;

        Grade(String rating, String name) {
            this.rating = new SimpleStringProperty(rating);
            this.name = new SimpleStringProperty(name);
        }

        public String getRating() {
            return rating.get();
        }

        public String getName() {
            return name.get();
        }
    }

}
