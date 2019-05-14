package Visualization;

import SearchClasses.SearchGradesController;

import static CentralClasses.MainWindow.mainStage;
import static CentralClasses.MainWindow.newScene;
import CentralClasses.MainWindowController;
import CentralClasses.StartPageController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import HelperClasses.ChartSubject;
import HelperClasses.Excel;
import HelperClasses.Thesis;
import HelperClasses.lists;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ChartsController {
	ObservableList<String> lineChartYears = FXCollections.observableArrayList(lists.listYears);
	ObservableList<PieChart.Data> piechartdata = FXCollections.observableArrayList();
	
	List<String> tmplist;
	public static ArrayList<String> selectedYears = new ArrayList<String>();
	ArrayList<ChartSubject> chartValues = new ArrayList<ChartSubject>();
	static ArrayList<Thesis> visualTheses;
	static ArrayList<Thesis> theses;
	int numberofCharts=0;
	String year;
	public static String filteredYear;
	int[] thesesBySelection, allTheses;
	int comparison;
	LineChart.Data<Number, Number> lineChartPGrades;
	LineChart.Data<String, Number> lineChartPGradesstring;
	BarChart.Data<String, Number> barChartData1, barChartData2, barChartData3, barChartData4, barChartData5;
	XYChart.Series<Number, Number> linechartSeries;
	XYChart.Series<String, Number> linechartSeriesstring;
	XYChart.Series<String, Number> barchartSeries1, barchartSeries2, barchartSeries3, barchartSeries4, barchartSeries5;
	boolean drawn = false, barDrawn = false;
	public static boolean filtered=false;
	
	
	@FXML
	JFXCheckBox lineC = new JFXCheckBox();
	@FXML
	JFXCheckBox pieC = new JFXCheckBox();
	@FXML
	JFXCheckBox radarC = new JFXCheckBox();
	@FXML
	JFXCheckBox barC = new JFXCheckBox();
	@FXML
	JFXButton drawChart = new JFXButton();
	@FXML
	JFXButton resetChart = new JFXButton();
	@FXML
	JFXButton fillBarchart = new JFXButton();
	@FXML
	JFXButton fillLinechart = new JFXButton();
	@FXML
	JFXButton clearBarchart = new JFXButton();
	@FXML
	JFXComboBox<String> chartType = new JFXComboBox<String>();
	@FXML
	JFXComboBox<String> pieData = new JFXComboBox<String>();
	@FXML
	JFXComboBox<String> radarData = new JFXComboBox<String>();
	@FXML
	JFXComboBox<String> lineYear = new JFXComboBox<String>();
	@FXML
	JFXComboBox<String> barOption = new JFXComboBox<String>();
	@FXML
	PieChart pieChart;
	@FXML
	LineChart<Number, Number> lineChart;
	@FXML
	LineChart<String, Number> lineChart2;
	@FXML
	NumberAxis linexAxis = new NumberAxis();
	@FXML
	CategoryAxis linexAxis2 = new CategoryAxis();
	@FXML
	NumberAxis lineyAxis = new NumberAxis(0, 100, 2);
	@FXML
	NumberAxis lineyAxis2 = new NumberAxis();
	@FXML
	NumberAxis baryAxis = new NumberAxis(0, 10, 1);
	@FXML
	CategoryAxis barxAxis = new CategoryAxis();
	
	@FXML
	BarChart<String, Number> barChart;
    @FXML
    private JFXButton BackToSearch;
    @FXML
    private BorderPane borderPane;
    @FXML
    //private ScrollPane scrollPane;
	
	
	
	public void initialize() {
		
		lineyAxis.setTickUnit(1);
		lineChartYears.add("Kaikki");
		String excelSource = StartPageController.excelSource;
		theses = Excel.readData(excelSource);
		System.out.println(excelSource);
		visualTheses = lists.visualTheses;
		
		barChart.setAnimated(false);
		baryAxis.setUpperBound(10);
		barOption.setItems(FXCollections.observableArrayList("Vuosi", "Arvosana"));
		fillBarchart.setDisable(true);
		fillLinechart.setDisable(true);
		
		lineYear.setItems(lineChartYears);
		linexAxis2.setCategories(lists.listGrades);
		
		pieData.setItems(lists.chartSubjects);
		pieChart.setLegendSide(Side.BOTTOM);
		pieChart.setLabelsVisible(true);
                
        borderPane.setStyle("-fx-background-color:white");
	}
	
	public static void visualizeTheses() {
		visualTheses = theses;
	}
	
	@FXML
	public void enableBarChart() {
		fillBarchart.setDisable(false);
	}
	
	
	@FXML
	public void enableLineChart() {
		fillLinechart.setDisable(false);
	}
	
	@FXML
	public void clearLineChart() {
		if(!filtered) {
			selectedYears.clear();
		}
		if(filteredYear!=null) {
			selectedYears.remove(selectedYears.indexOf(filteredYear));
		}
		lineChart.setTitle("");
		lineyAxis.setLabel("");
		lineyAxis.setUpperBound(10);
		lineyAxis2.setLabel("");
		lineyAxis2.setUpperBound(10);
		lineChart.getData().clear();
		lineChart2.getData().clear();
	}
	
	@FXML
	public void clearBarChart() {
		barChart.getData().clear();
	}

	@FXML
	public void fillBarChart() {
		
		if(barOption.getSelectionModel().getSelectedItem().equals("Arvosana")) {
			barChart.getData().clear();
			barxAxis.setCategories(lists.listGrades);
			barChart.setTitle("Gradujen jakauma paradigman tutkimuskohteiden mukaan arvosanoittain");
			barchartSeries1 = new XYChart.Series<String, Number>();
			barchartSeries1.setName(lists.listSubjects.get(0));
			barchartSeries2 = new XYChart.Series<String, Number>();
			barchartSeries2.setName(lists.listSubjects.get(1));
			barchartSeries3 = new XYChart.Series<String, Number>();
			barchartSeries3.setName(lists.listSubjects.get(2));
			barchartSeries4 = new XYChart.Series<String, Number>();
			barchartSeries4.setName(lists.listSubjects.get(3));
			barchartSeries5 = new XYChart.Series<String, Number>();
			barchartSeries5.setName("Useampi kuin yksi");
			baryAxis.setUpperBound(10);
			int highest=0;
			for(String g : lists.listGrades) {
				thesesBySelection = new int[5];
				for(Thesis t : visualTheses) {
					if(t.getPggrade()!=null) {
						if(t.getResearchSubjects().length>1&&Integer.valueOf(g.substring(0,1))==Integer.valueOf(t.getPggrade().substring(0,1))) {
							thesesBySelection[4]++;
						}
						if(t.getResearchSubjects()[0].startsWith("1")&&Integer.valueOf(g.substring(0,1))==Integer.valueOf(t.getPggrade().substring(0,1))) {
							thesesBySelection[0]++;
						}
						if(t.getResearchSubjects()[0].startsWith("2")&&Integer.valueOf(g.substring(0,1))==Integer.valueOf(t.getPggrade().substring(0,1))) {
							thesesBySelection[1]++;
						}
						if(t.getResearchSubjects()[0].startsWith("3")&&Integer.valueOf(g.substring(0,1))==Integer.valueOf(t.getPggrade().substring(0,1))) {
							thesesBySelection[2]++;
						}
						if(t.getResearchSubjects()[0].startsWith("4")&&Integer.valueOf(g.substring(0,1))==Integer.valueOf(t.getPggrade().substring(0,1))) {
							thesesBySelection[3]++;
						}
					}	
				}
				for (int t : thesesBySelection) {
					if (t > highest) {
						highest = t;
					}
				}
				baryAxis.setUpperBound(highest + 1);
				barChartData1 = new XYChart.Data<String, Number>(g, thesesBySelection[0]);
				barchartSeries1.getData().add(barChartData1);
				barChartData2 = new XYChart.Data<String, Number>(g, thesesBySelection[1]);
				barchartSeries2.getData().add(barChartData2);
				barChartData3 = new XYChart.Data<String, Number>(g, thesesBySelection[2]);
				barchartSeries3.getData().add(barChartData3);
				barChartData4 = new XYChart.Data<String, Number>(g, thesesBySelection[3]);
				barchartSeries4.getData().add(barChartData4);
				barChartData5 = new XYChart.Data<String, Number>(g, thesesBySelection[4]);
				barchartSeries5.getData().add(barChartData5);
				
				
			}
			barDrawn=true;
			barChart.getData().addAll(barchartSeries1, barchartSeries2, barchartSeries3, barchartSeries4, barchartSeries5);
		} else if(barOption.getSelectionModel().getSelectedItem().equals("Vuosi")) {
			barChart.getData().clear();
			barxAxis.setCategories(lists.listYears);
			barChart.setTitle("Gradujen jakauma paradigman tutkimuskohteiden mukaan vuosittain");
			barchartSeries1 = new XYChart.Series<String, Number>();
			barchartSeries1.setName(lists.listSubjects.get(0));
			barchartSeries2 = new XYChart.Series<String, Number>();
			barchartSeries2.setName(lists.listSubjects.get(1));
			barchartSeries3 = new XYChart.Series<String, Number>();
			barchartSeries3.setName(lists.listSubjects.get(2));
			barchartSeries4 = new XYChart.Series<String, Number>();
			barchartSeries4.setName(lists.listSubjects.get(3));
			barchartSeries5 = new XYChart.Series<String, Number>();
			barchartSeries5.setName("Useampi kuin yksi");
			baryAxis.setUpperBound(10);
			int highest=0;

			for(String y : lists.listYears) {
				thesesBySelection = new int[5];
				for(Thesis t : visualTheses) {
					if(t.getResearchSubjects().length>1&&t.getYear().contentEquals(y)) {
						thesesBySelection[4]++;
					}
					if(t.getResearchSubjects()[0].startsWith("1")&&t.getYear().contentEquals(y)) {
						thesesBySelection[0]++;
					}
					if(t.getResearchSubjects()[0].startsWith("2")&&t.getYear().contentEquals(y)) {
						thesesBySelection[1]++;
					}
					if(t.getResearchSubjects()[0].startsWith("3")&&t.getYear().contentEquals(y)) {
						thesesBySelection[2]++;
					}
					if(t.getResearchSubjects()[0].startsWith("4")&&t.getYear().contentEquals(y)) {
						thesesBySelection[3]++;
					}
				}
				for (int t : thesesBySelection) {
					if (t > highest) {
						highest = t;
					}
				}
				baryAxis.setUpperBound(highest + 1);
				lineyAxis2.setUpperBound(highest + 5);
				barChartData1 = new XYChart.Data<String, Number>(y, thesesBySelection[0]);
				barchartSeries1.getData().add(barChartData1);
				barChartData2 = new XYChart.Data<String, Number>(y, thesesBySelection[1]);
				barchartSeries2.getData().add(barChartData2);
				barChartData3 = new XYChart.Data<String, Number>(y, thesesBySelection[2]);
				barchartSeries3.getData().add(barChartData3);
				barChartData4 = new XYChart.Data<String, Number>(y, thesesBySelection[3]);
				barchartSeries4.getData().add(barChartData4);
				barChartData5 = new XYChart.Data<String, Number>(y, thesesBySelection[4]);
				barchartSeries5.getData().add(barChartData5);
				
				
			}
			barChart.getData().addAll(barchartSeries1, barchartSeries2, barchartSeries3, barchartSeries4, barchartSeries5);
			barDrawn=true;
		}
		
	}
	
	@FXML
	public void fillLineChart() {
		if(numberofCharts<2) {
			linechartSeriesstring = new XYChart.Series<String, Number>();
			lineChart2.setTitle("Arvosanojen jakauma vuoden mukaan");
			
			lineyAxis2.setLabel("Graduja");
			linexAxis2.setLabel("Arvosana");
			
			int i = 0, highest = 0;

			allTheses = new int[7];
			thesesBySelection = new int[7];
			comparison = 0;
			for (Thesis t : visualTheses) {
				if(t.getPggrade()!=null) {
					
					comparison = Integer.valueOf(t.getPggrade().substring(0,1));
					switch (comparison) {
					case 1:
						if (t.getYear().equals(lineYear.getSelectionModel().getSelectedItem())) {
							thesesBySelection[0]++;
						}
						allTheses[0]++;
						break;
					case 2:
						if (t.getYear().equals(lineYear.getSelectionModel().getSelectedItem())) {
							thesesBySelection[1]++;
						}
						allTheses[1]++;
						break;
					case 3:
						if (t.getYear().equals(lineYear.getSelectionModel().getSelectedItem())) {
							thesesBySelection[2]++;
						}
						allTheses[2]++;
						break;
					case 4:
						if (t.getYear().equals(lineYear.getSelectionModel().getSelectedItem())) {
							thesesBySelection[3]++;
						}
						allTheses[3]++;
						break;
					case 5:
						if (t.getYear().equals(lineYear.getSelectionModel().getSelectedItem())) {
							thesesBySelection[4]++;
						}
						allTheses[4]++;
						break;
					case 6:
						if (t.getYear().equals(lineYear.getSelectionModel().getSelectedItem())) {
							thesesBySelection[5]++;
						}
						allTheses[5]++;
						break;
					case 7:
						if (t.getYear().equals(lineYear.getSelectionModel().getSelectedItem())) {
							thesesBySelection[6]++;
						}
						allTheses[6]++;
						break;
					}
				}
			}

			if (lineYear.getSelectionModel().getSelectedItem() != null) {
				highest = 0;
				for (int t : thesesBySelection) {
					if (t > highest) {
						highest = t;
					}
				}
				lineyAxis.setUpperBound(highest+5);
				lineyAxis2.setUpperBound(highest + 5);
				for (Thesis t : visualTheses) {
					year = t.getYear();
					if(t.getPggrade()!=null) {
						comparison = Integer.valueOf(t.getPggrade().substring(0,1));
						switch (comparison) {
						case 1:
							lineChartPGradesstring = new XYChart.Data<String, Number>(lists.listGrades.get(0), thesesBySelection[0]);
							break;
						case 2:
							lineChartPGradesstring = new XYChart.Data<String, Number>(lists.listGrades.get(1), thesesBySelection[1]);
							break;
						case 3:
							lineChartPGradesstring = new XYChart.Data<String, Number>(lists.listGrades.get(2), thesesBySelection[2]);
							break;
						case 4:
							lineChartPGradesstring = new XYChart.Data<String, Number>(lists.listGrades.get(3), thesesBySelection[3]);
							break;
						case 5:
							lineChartPGradesstring = new XYChart.Data<String, Number>(lists.listGrades.get(4), thesesBySelection[4]);
							break;
						case 6:
							lineChartPGradesstring = new XYChart.Data<String, Number>(lists.listGrades.get(5), thesesBySelection[5]);
							break;
						case 7:
							lineChartPGradesstring = new XYChart.Data<String, Number>(lists.listGrades.get(6), thesesBySelection[6]);
							break;
						}
					}
					
					if (lineYear.getSelectionModel().getSelectedItem().equals(year)&&t.getPggrade()!=null) {
						if (!drawn && lineChartPGradesstring != null
								&& !selectedYears.contains(lineYear.getSelectionModel().getSelectedItem())) {
							linechartSeriesstring.getData().add(lineChartPGradesstring);
							linechartSeriesstring.setName(year);
						}
					}
				}
			}		
			if (lineYear.getSelectionModel().getSelectedItem()!=null&&lineYear.getSelectionModel().getSelectedItem().equals("Kaikki")) {
				highest = 0;
				for (int t : allTheses) {
					if (t > highest) {
						highest = t;
					}
				}			
				lineyAxis.setUpperBound(highest+5);
				lineyAxis2.setUpperBound(highest + 5);
				for (i = 0; i < allTheses.length; i++) {
					lineChartPGradesstring = new XYChart.Data<String, Number>(lists.listGrades.get(i), allTheses[i]);
					linechartSeriesstring.getData().add(lineChartPGradesstring);
					linechartSeriesstring.setName("Kaikki");
				}
			}
			if (!selectedYears.contains(lineYear.getSelectionModel().getSelectedItem())) {
				lineChart2.getData().add(linechartSeriesstring);
				selectedYears.add(lineYear.getSelectionModel().getSelectedItem());
			}
		} else {
			linechartSeries = new XYChart.Series<Number, Number>();
			lineChart.setTitle("Arvosanojen jakauma vuoden mukaan");
			
			lineyAxis.setLabel("Graduja");
			linexAxis.setLabel("Arvosana");
			
			int i = 0, highest = 0;

			allTheses = new int[7];
			thesesBySelection = new int[7];
			for (Thesis t : visualTheses) {
				if(t.getPggrade()!=null) {
					comparison = Integer.valueOf(t.getPggrade().substring(0,1));
					switch (comparison) {
					case 1:
						if (t.getYear().equals(lineYear.getSelectionModel().getSelectedItem())) {
							thesesBySelection[0]++;
						}
						allTheses[0]++;
						break;
					case 2:
						if (t.getYear().equals(lineYear.getSelectionModel().getSelectedItem())) {
							thesesBySelection[1]++;
						}
						allTheses[1]++;
						break;
					case 3:
						if (t.getYear().equals(lineYear.getSelectionModel().getSelectedItem())) {
							thesesBySelection[2]++;
						}
						allTheses[2]++;
						break;
					case 4:
						if (t.getYear().equals(lineYear.getSelectionModel().getSelectedItem())) {
							thesesBySelection[3]++;
						}
						allTheses[3]++;
						break;
					case 5:
						if (t.getYear().equals(lineYear.getSelectionModel().getSelectedItem())) {
							thesesBySelection[4]++;
						}
						allTheses[4]++;
						break;
					case 6:
						if (t.getYear().equals(lineYear.getSelectionModel().getSelectedItem())) {
							thesesBySelection[5]++;
						}
						allTheses[5]++;
						break;
					case 7:
						if (t.getYear().equals(lineYear.getSelectionModel().getSelectedItem())) {
							thesesBySelection[6]++;
						}
						allTheses[6]++;
						break;
					}
				}
			}
			for(int c=0;allTheses.length>c;c++) {
				System.out.println(thesesBySelection[c]);
				System.out.println(allTheses[c]);
			}

			if (lineYear.getSelectionModel().getSelectedItem() != null) {
				highest = 0;
				for (int t : thesesBySelection) {
					if (t > highest) {
						highest = t;
					}
				}
				lineyAxis.setUpperBound(highest + 5);
				for (Thesis t : visualTheses) {
					year = t.getYear();
					if(t.getPggrade()!=null) {
						comparison = Integer.valueOf(t.getPggrade().substring(0,1));
						switch (comparison) {
						case 1:
							lineChartPGrades = new XYChart.Data<Number, Number>(Integer.valueOf(t.getPggrade().substring(0,1)), thesesBySelection[0]);
							break;
						case 2:
							lineChartPGrades = new XYChart.Data<Number, Number>(Integer.valueOf(t.getPggrade().substring(0,1)), thesesBySelection[1]);
							break;
						case 3:
							lineChartPGrades = new XYChart.Data<Number, Number>(Integer.valueOf(t.getPggrade().substring(0,1)), thesesBySelection[2]);
							break;
						case 4:
							lineChartPGrades = new XYChart.Data<Number, Number>(Integer.valueOf(t.getPggrade().substring(0,1)), thesesBySelection[3]);
							break;
						case 5:
							lineChartPGrades = new XYChart.Data<Number, Number>(Integer.valueOf(t.getPggrade().substring(0,1)), thesesBySelection[4]);
							break;
						case 6:
							lineChartPGrades = new XYChart.Data<Number, Number>(Integer.valueOf(t.getPggrade().substring(0,1)), thesesBySelection[5]);
							break;
						case 7:
							lineChartPGrades = new XYChart.Data<Number, Number>(Integer.valueOf(t.getPggrade().substring(0,1)), thesesBySelection[6]);
							break;
						}
					}
					
					if (lineYear.getSelectionModel().getSelectedItem().equals(year)&&t.getPggrade()!=null) {
						if (!drawn && lineChartPGrades != null
								&& !selectedYears.contains(lineYear.getSelectionModel().getSelectedItem())) {
							linechartSeries.getData().add(lineChartPGrades);
							linechartSeries.setName(year);
						}
					}
				}
			}		
			if (lineYear.getSelectionModel().getSelectedItem()!=null&&lineYear.getSelectionModel().getSelectedItem().equals("Kaikki")) {
				highest = 0;
				for (int t : allTheses) {
					if (t > highest) {
						highest = t;
					}
				}			
				lineyAxis.setUpperBound(highest + 5);
				lineyAxis2.setUpperBound(highest + 5);
				for (i = 0; i < allTheses.length; i++) {
					lineChartPGrades = new XYChart.Data<Number, Number>(i + 1, allTheses[i]);
					linechartSeries.getData().add(lineChartPGrades);
					linechartSeries.setName("Kaikki");
				}
			}
			if (!selectedYears.contains(lineYear.getSelectionModel().getSelectedItem())) {
				lineChart.getData().add(linechartSeries);
				selectedYears.add(lineYear.getSelectionModel().getSelectedItem());
			}
		}
		
	}
	
	@FXML
	public void fillPieChart() {
		piechartdata.clear();
		chartValues.clear();
		int subject = pieData.getSelectionModel().getSelectedIndex()+1;

		switch(subject) {
		case 1:
			for(String s : lists.listYears) {
				chartValues.add(new ChartSubject(s, 0));
			}			
			for(Thesis t : visualTheses) {
				for(ChartSubject c : chartValues) {
					if(t.getYear().substring(0,4).equals(c.getName())) {
						c.setValue(c.getValue()+1);
					}
				}
			}			
			for(ChartSubject c : chartValues) {
				piechartdata.add(new PieChart.Data(c.getName(), c.getValue()));
			}			
			pieChart.setTitle("Graduja per vuosi");
			break;
		case 2:
			for(String s : lists.listLevels) {
				chartValues.add(new ChartSubject(s, 0));
			}			
			for(Thesis t : visualTheses) {
				for(ChartSubject c : chartValues) {
					if(t.getLevel().equals(c.getName())) {
						c.setValue(c.getValue()+1);
					}
				}
			}			
			for(ChartSubject c : chartValues) {
				piechartdata.add(new PieChart.Data(c.getName(), c.getValue()));
			}			
			pieChart.setTitle("Graduja per taso");
			break;
		case 3:
			for(String s : lists.listTypes) {
				chartValues.add(new ChartSubject(s, 0));
			}			
			for(Thesis t : visualTheses) {
				for(ChartSubject c : chartValues) {
					if(t.getType().equals(c.getName())) {
						c.setValue(c.getValue()+1);
					}
				}
			}
			for(ChartSubject c : chartValues) {
				piechartdata.add(new PieChart.Data(c.getName(), c.getValue()));
			}
			pieChart.setTitle("Graduja per tyyppi");
			break;
		case 4:
			for(String s : lists.listLanguages) {
				chartValues.add(new ChartSubject(s, 0));
			}
			for(Thesis t : visualTheses) {
				for(ChartSubject c : chartValues) {
					if(t.getLanguage().equals(c.getName())) {
						c.setValue(c.getValue()+1);
					}
				}
			}
			for(ChartSubject c : chartValues) {
				piechartdata.add(new PieChart.Data(c.getName(), c.getValue()));
			}
			pieChart.setTitle("Graduja per kieli");
			break;
		case 5:
			for(String s : lists.listSubjects) {
				chartValues.add(new ChartSubject(s, 0));
			}
			ChartSubject multiple1 = new ChartSubject("5. Enemmän kuin yksi tutkimuskohde", 0);
			for(Thesis t : visualTheses) {
				if(t.getResearchSubjects().length>1) {
					multiple1.setValue(multiple1.getValue()+1);
				} else {
					for(ChartSubject c : chartValues) {
						if(t.getResearchSubjects()[0].equals(c.getName())) {
							c.setValue(c.getValue()+1);
						}
					}
				}
			}
			chartValues.add(multiple1);
			for(ChartSubject c : chartValues) {
				piechartdata.add(new PieChart.Data(c.getName(), c.getValue()));
			}
			pieChart.setTitle("Graduja per tukimuskohde");
			break;
		case 6:
			for(String s : lists.listMethods) {
				chartValues.add(new ChartSubject(s, 0));
			}
			ChartSubject multiple2 = new ChartSubject("9. Enemmän kuin yksi metodi", 0);
			for(Thesis t : visualTheses) {
				if(t.getResearchMethods()!=null) {
					if(t.getResearchMethods().length>1) {
						multiple2.setValue(multiple2.getValue()+1);
					} else {
						for(ChartSubject c : chartValues) {
							if(t.getResearchMethods()[0].substring(0, 1).equals(c.getName().substring(0, 1))) {
								c.setValue(c.getValue()+1);
							}
						}
					}
				}	
			}
			chartValues.add(multiple2);
			for(ChartSubject c : chartValues) {
				piechartdata.add(new PieChart.Data(c.getName(), c.getValue()));
			}
			pieChart.setTitle("Graduja per tutkimusmetodi");
			break;
		case 7:
			for(String s : lists.listDatamethods) {
				chartValues.add(new ChartSubject(s, 0));
			}
			ChartSubject multiple3 = new ChartSubject("8. Enemmän kuin yksi hakumenetelmä", 0);
			for(Thesis t : visualTheses) {
				if(t.getSources()!=null) {
					if(t.getSources().length>1) {
						multiple3.setValue(multiple3.getValue()+1);
					} else {
						for(ChartSubject c : chartValues) {
							if(t.getSources()[0].substring(0, 1).equals(c.getName().substring(0, 1))) {
								c.setValue(c.getValue()+1);
							}
						}
					}
				}	
			}
			chartValues.add(multiple3);
			for(ChartSubject c : chartValues) {
				piechartdata.add(new PieChart.Data(c.getName(), c.getValue()));
			}
			pieChart.setTitle("Graduja per tutkimusmetodi");
			break;
		case 8:
			for(String s : lists.listGrades) {
				if(s.startsWith("1")) {
					chartValues.add(new ChartSubject("1. approbatur", 0, 1));
				} else if(s.startsWith("2")) {
					chartValues.add(new ChartSubject("2. lubenter approbatur", 0, 2));
				} else if(s.startsWith("3")) {
					chartValues.add(new ChartSubject("3. non sine laude approbatur", 0, 3));
				} else if(s.startsWith("4")) {
					chartValues.add(new ChartSubject("4. cum laude approbatur", 0, 4));
				} else if(s.startsWith("5")) {
					chartValues.add(new ChartSubject("5. magna cum laude approbatur", 0, 5));
				} else if(s.startsWith("6")) {
					chartValues.add(new ChartSubject("6. eximia cum laude approbatur", 0, 6));
				} else if(s.startsWith("7")) {
					chartValues.add(new ChartSubject("7. laudatur", 0, 7));
				}
			}
			for(Thesis t : visualTheses) {
				if(t.getPggrade()!=null) {
					comparison=Integer.valueOf(t.getPggrade().substring(0,1));
					for(ChartSubject c : chartValues) {
						if(comparison==(c.getGrade())) {
							c.setValue(c.getValue()+1);
						}
					}
				}
				
			}
			for(ChartSubject c : chartValues) {
				piechartdata.add(new PieChart.Data(c.getName(), c.getValue()));
			}
			pieChart.setTitle("Pro-graduja per arvosana");
			break;
		case 9:
			for(String s : lists.doctorateGrades) {
				if(s.startsWith("1")) {
					chartValues.add(new ChartSubject("1. kiittäen hyväksytty", 0, 1));
				} else if(s.startsWith("2")) {
					chartValues.add(new ChartSubject("2. hyväksytty", 0, 2));
				} 
			}
			for(Thesis t : visualTheses) {
				if(t.getDtgrade()!=null) {
					comparison=Integer.valueOf(t.getDtgrade());
					for(ChartSubject c : chartValues) {
						if(comparison==(c.getGrade())) {
							c.setValue(c.getValue()+1);
						}
					}
				}
			}
			for(ChartSubject c : chartValues) {
				piechartdata.add(new PieChart.Data(c.getName(), c.getValue()));
			}
			pieChart.setTitle("Väitöskirjoja per arvosana");
			break;

		}
		pieChart.setData(piechartdata);
	}
	@FXML
	public void updateCharts() {
		numberofCharts=0;
		if(barC.isSelected()) {
			numberofCharts++;
			barChart.setVisible(true);
		} else {
			barChart.setVisible(false);
		}
		if(pieC.isSelected()) {
			numberofCharts++;
			pieChart.setVisible(true);
		} else 
			pieChart.setVisible(false);
		if(lineC.isSelected()) {
			lineChart.setVisible(true);
			numberofCharts++;
		} else 
			lineChart.setVisible(false);
		switch(numberofCharts) {
		case 0:
			//clearLineChart();
			break;
		case 1:
			//clearLineChart();
			fillLineChart();
			if(barC.isSelected()) {
				barChart.setLayoutX(100);
				barChart.setLayoutY(200);
				barChart.setPrefSize(1000, 600);
				barxAxis.setTickLabelsVisible(true);
			} 
			if(pieC.isSelected()) {
				pieChart.setLayoutX(100);
				pieChart.setLayoutY(200);
				pieChart.setPrefSize(1000, 600);
				pieChart.setLabelsVisible(true);
			} 
			if(lineC.isSelected()) {
				lineChart.setVisible(false);
				lineChart2.setVisible(true);
				lineChart2.setLayoutX(100);
				lineChart2.setLayoutY(200);
				lineChart2.setPrefSize(1000, 600);
			} 	
			break;
		case 2:
			//clearLineChart();
			fillLineChart();
			if(barC.isSelected()) {
				barChart.setLayoutX(650);
				barChart.setLayoutY(200);
				barChart.setPrefSize(500, 500);
				barxAxis.setTickLabelsVisible(true);
			} 
			if(pieC.isSelected()) {
				pieChart.setLayoutX(100);
				pieChart.setLayoutY(200);
				pieChart.setPrefSize(500, 500);
				pieChart.setLabelsVisible(false);
			} 
			if(lineC.isSelected()&&barC.isSelected()) {
				lineChart.setVisible(true);
				lineChart2.setVisible(false);
				lineChart.setLayoutX(100);
				lineChart.setLayoutY(200);
				lineChart.setPrefSize(500, 500);
			} else if(lineC.isSelected()) {
				lineChart.setVisible(true);
				lineChart2.setVisible(false);
				lineChart.setLayoutX(650);
				lineChart.setLayoutY(200);
				lineChart.setPrefSize(500, 500);
			}
			break;
		case 3:
			//clearLineChart();
			fillLineChart();
			if(barC.isSelected()) {
				barChart.setLayoutX(700);
				barChart.setLayoutY(300);
				barChart.setPrefSize(300, 400);
				barxAxis.setTickLabelsVisible(false);
			} 
			if(pieC.isSelected()) {
				pieChart.setLayoutX(100);
				pieChart.setLayoutY(300);
				pieChart.setPrefSize(300, 400);
				pieChart.setLabelsVisible(false);
			} 
			if(lineC.isSelected()) {
				lineChart.setLayoutX(400);
				lineChart.setLayoutY(300);
				lineChart.setPrefSize(300, 400);
			} 
			break;
		}
	}

    @FXML
    private void BackToSearchAction(ActionEvent event) throws IOException {
        mainStage = (Stage) BackToSearch.getScene().getWindow();
        Parent root = FXMLLoader.load(SearchGradesController.class.getResource("SearchGrades.fxml"));
        newScene = new Scene(root, 1000, 700);  
        mainStage.setScene(newScene);        
    }
}
