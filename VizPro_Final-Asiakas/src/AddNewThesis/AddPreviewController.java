package AddNewThesis;

import static CentralClasses.MainWindow.mainStage;
import static CentralClasses.MainWindow.newScene;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;

import CentralClasses.MainWindow;
import CentralClasses.MainWindowController;
import CentralClasses.StartPageController;
import HelperClasses.Excel;
import HelperClasses.Thesis;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AddPreviewController implements Initializable {
	@FXML
	JFXTextArea previewYear = new JFXTextArea();
	@FXML
	JFXTextArea previewAuthors = new JFXTextArea();
	@FXML
	JFXTextArea previewName = new JFXTextArea();
	@FXML
	JFXTextArea previewLevel = new JFXTextArea();
	@FXML
	JFXTextArea previewType = new JFXTextArea();
	@FXML
	JFXTextArea previewArticles = new JFXTextArea();
	@FXML
	JFXTextArea previewLanguage = new JFXTextArea();
	@FXML
	JFXTextArea previewSubjects = new JFXTextArea();
	@FXML
	JFXTextArea previewConcepts = new JFXTextArea();
	@FXML
	JFXTextArea previewMethods = new JFXTextArea();
	@FXML
	JFXTextArea previewSources = new JFXTextArea();
	@FXML
	JFXTextArea previewInformants = new JFXTextArea();
	@FXML
	JFXTextArea previewClasses = new JFXTextArea();
	@FXML
	JFXTextArea previewContext = new JFXTextArea();
	@FXML
	JFXButton returnBtn = new JFXButton();
	@FXML
	JFXButton confirmBtn = new JFXButton();
	@FXML
	HBox base = new HBox();
	
	static String year;
	static String[] authors;
	static String name;
	static String level; 
	static String type;
	static String articles; 
	static String language; 
	static String authorcount; 
	static String[] researchSubjects;
	static String[] researchConcepts;
	static String[] researchMethods;
	static String[] sources;
	static String[]informants; 
	static String informantCount; 
	static String[] classes;
	static String[] context;
	static Thesis previewThesis;
	String excelURL = StartPageController.excelSource;   
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		previewYear.setText("Vuosi: \n"+year);
		if(authors!=null&&authorcount=="2.") {
			previewAuthors.setText("Tekijät: \n"+authors[0]+" ja "+authors[1]);
		} else if(authors!=null){
			previewAuthors.setText("Tekijä: \n"+authors[0]);
		}
		
		previewName.setText("Tutkielman nimi: \n"+name);
		previewLevel.setText("Tutkielman taso: \n"+level);
		previewType.setText("Tutkielman tyyppi: \n"+type);
		previewArticles.setText("Artikkelien määrä ja kieli: \n"+articles);
		previewLanguage.setText("Tutkielman kieli: \n"+language);
		previewSubjects.setText("Paradigman tutkimuskohteet: ");
		for(String s : researchSubjects) {
			if(s!=null) {
				previewSubjects.setText(previewSubjects.getText()+"\n "+s);
			} 
		}
		previewClasses.setText("Alaluokat: ");
		if(classes.length>1) {
			for(String s : classes) {
				previewClasses.setText(previewClasses.getText()+"\n "+s);
			}
		} else if(classes.length>0) {
			previewClasses.setText("Alaluokat: \n"+ classes[0]);
		}
		previewConcepts.setText("Tutkimustehtävien ja -käsitteiden sijoittuminen: ");
		if(researchConcepts!=null&&researchConcepts.length>1) {
			for(String s : researchConcepts) {
				previewConcepts.setText(previewConcepts.getText()+"\n "+s);
			}
		} else if(researchConcepts!=null) {
			previewConcepts.setText("Tutkimustehtävien ja -käsitteiden sijoittuminen: \n"+ researchConcepts[0]);
		}
		previewMethods.setText("Tutkimusmetodit: ");
		if(researchMethods!=null&&researchMethods.length>1) {
			for(String s : researchMethods) {
				previewMethods.setText(previewMethods.getText()+"\n "+s);
			}
		} else if(researchMethods!=null) {
			previewMethods.setText("Tutkimusmetodit: \n"+researchMethods[0]);
		}
		
		previewSources.setText("Aineistonkeruumenetelmät: ");
		if(sources!=null&&sources.length>1) {
			for(String s : sources) {
				previewSources.setText(previewSources.getText()+"\n "+s);
			}
		} else if(sources!=null){
			previewSources.setText("Aineistonkeruumenetelmät: \n"+sources[0]);
		}
		previewInformants.setText("Tietolähteiden määrä: "+informantCount+"\nTietolähteet: ");
		if(informants!=null&&informants.length>1) {
			for(String s : informants) {
				previewInformants.setText(previewInformants.getText()+"\n "+s);
			}
		} else if(informants!=null) {
			previewInformants.setText("Tietolähteiden määrä: "+informantCount+"\nTietolähteet: \n"+informants[0]);
		}
		previewContext.setText("Tutkimuksen konteksti: ");
		if(context!=null&&context.length>1) {
			for(String s : context) {
				previewContext.setText(previewContext.getText()+"\n "+s);
			}
		} else if(context!=null){
			previewContext.setText("Tutkimuksen konteksti: \n"+context[0]);
		}
	}
	public static void initiatePreview(Thesis thesis) {
		year=thesis.getYear();
		authors=thesis.getAuthors();
		name=thesis.getName();
		level=thesis.getLevel();
		type=thesis.getType();
		articles=thesis.getArticles();
		language=thesis.getLanguage();
		authorcount=thesis.getAuthorcount();
		researchMethods=thesis.getResearchMethods();
		researchSubjects=thesis.getResearchSubjects();
		researchConcepts=thesis.getResearchConcepts();
		sources=thesis.getSources();
		informants=thesis.getInformants();
		informantCount=thesis.getInformantCount();
		classes=thesis.getClasses();
		context=thesis.getContext();
		previewThesis=thesis;
	}
	
	public void confirmAdd() throws IOException {
        
		if(previewThesis.getResearchConcepts()!=null) {
			if(previewThesis.getResearchMethods()!=null) {
				if(previewThesis.getContext()!=null) {
					if(previewThesis.getInformants()!=null) {
						if(previewThesis.getSources()!=null) {
							if(previewThesis.getYear()!=null) {
								if(previewThesis.getAuthors()!=null) {
									if(previewThesis.getName()!=null) {
										if(previewThesis.getAuthorcount()!=null) {
											if(previewThesis.getType()!=null) {
												if(previewThesis.getLevel()!=null) {
													if(previewThesis.getClasses()!=null) {
														if(previewThesis.getResearchSubjects()!=null) {
															if(previewThesis.getLanguage()!=null) {
																if(previewThesis.getArticles()!=null) {
																	if(previewThesis.getInformantCount()!=null) {
																		System.out.println("Gradu lisätty");
																		Excel.addNewThesis(previewThesis, excelURL);
																		MainWindow.closePreview();
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
		} else {
			System.out.println("Joku kenttä puuttuu");
		}
	}
}
