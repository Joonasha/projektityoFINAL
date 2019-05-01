/*
package Visualization;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
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

public class ChartsControllerINT {
	ObservableList<String> lineChartYears = FXCollections.observableArrayList(lists.listYears);
	ObservableList<PieChart.Data> piechartdata = FXCollections.observableArrayList();
	
	List<String> tmplist;
	public static ArrayList<String> selectedYears = new ArrayList<String>();
	ArrayList<ChartSubject> chartValues = new ArrayList<ChartSubject>();
	static ArrayList<Thesis> visualTheses;
	static ArrayList<Thesis> theses;
	int numberofCharts;
	String year;
	public static String filteredYear;
	int[] thesesBySelection, allTheses;
	LineChart.Data<Number, Number> lineChartPGrades;
	LineChart.Data<Number, Number> lineChartDGrades;
	LineChart.Data<Number, Number> lineChartSubjects;
	BarChart.Data<String, Number> barChartData1, barChartData2, barChartData3, barChartData4, barChartData5;
	XYChart.Series<Number, Number> linechartSeries;
	XYChart.Series<String, Number> barchartSeries1, barchartSeries2, barchartSeries3, barchartSeries4, barchartSeries5;
	boolean drawn = false, barDrawn = false;
	public static boolean filtered=false;
	
	@FXML
	CheckBox lineC = new CheckBox();
	@FXML
	CheckBox pieC = new CheckBox();
	@FXML
	CheckBox radarC = new CheckBox();
	@FXML
	CheckBox barC = new CheckBox();
	@FXML
	Button drawChart = new Button();
	@FXML
	Button resetChart = new Button();
	@FXML
	Button fillBarchart = new Button();
	@FXML
	Button clearBarchart = new Button();
	@FXML
	ComboBox<String> chartType = new ComboBox<String>();
	@FXML
	ComboBox<String> pieData = new ComboBox<String>();
	@FXML
	ComboBox<String> radarData = new ComboBox<String>();
	@FXML
	ComboBox<String> lineYear = new ComboBox<String>();
	@FXML
	ComboBox<String> lineSubject = new ComboBox<String>();
	@FXML
	ComboBox<String> barOption = new ComboBox<String>();
	@FXML
	PieChart pieChart;
	@FXML
	LineChart<Number, Number> lineChart;
	@FXML
	NumberAxis linexAxis = new NumberAxis();
	@FXML
	NumberAxis lineyAxis = new NumberAxis(0, 100, 2);
	@FXML
	NumberAxis baryAxis = new NumberAxis(0, 10, 1);
	@FXML
	CategoryAxis barxAxis = new CategoryAxis();
	@FXML
	BarChart<String, Number> barChart;
	
	public void initialize() {
		lineyAxis.setTickUnit(1);
		lineChartYears.add("Kaikki");
		String excelSource = "Testiaineisto.xlsx";
		theses = Excel.readData(excelSource);
		visualTheses = lists.visualTheses;
		
		barChart.setAnimated(false);
		baryAxis.setUpperBound(10);
		barOption.setItems(FXCollections.observableArrayList("Vuosi", "Arvosana"));
		
		lineYear.setItems(lineChartYears);
		
		pieData.setItems(lists.chartSubjects);
		pieChart.setLegendSide(Side.BOTTOM);
		pieChart.setLabelsVisible(true);
	}
	
	@FXML
	public static void visualizeTheses() {
		visualTheses = theses;
	}
	
	@FXML
	public void checkSelection() {
		lineSubject.setDisable(false);
		lineYear.setDisable(false);
		if(!lineYear.getSelectionModel().isEmpty()) {
			lineSubject.setDisable(true);
		} else if(!lineSubject.getSelectionModel().isEmpty()) {
			lineYear.setDisable(true);
		}
	}
	
	@FXML
	public void clearChart() {
		if(!filtered) {
			selectedYears.clear();
		}
		if(filteredYear!=null) {
			selectedYears.remove(selectedYears.indexOf(filteredYear));
		}

		lineYear.getSelectionModel().clearSelection();
		lineSubject.getSelectionModel().clearSelection();
		lineChart.setTitle("");
		lineyAxis.setLabel("");
		lineyAxis.setUpperBound(10);
		lineChart.getData().clear();
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
			System.out.println(barxAxis.getCategories());
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
					if(t.getResearchSubjects().length>1&&Integer.valueOf(g.substring(0,1))==t.getPggrade()) {
						thesesBySelection[4]++;
					}
					if(t.getResearchSubjects()[0].startsWith("1")&&Integer.valueOf(g.substring(0,1))==t.getPggrade()) {
						thesesBySelection[0]++;
					}
					if(t.getResearchSubjects()[0].startsWith("2")&&Integer.valueOf(g.substring(0,1))==t.getPggrade()) {
						thesesBySelection[1]++;
					}
					if(t.getResearchSubjects()[0].startsWith("3")&&Integer.valueOf(g.substring(0,1))==t.getPggrade()) {
						thesesBySelection[2]++;
					}
					if(t.getResearchSubjects()[0].startsWith("4")&&Integer.valueOf(g.substring(0,1))==t.getPggrade()) {
						thesesBySelection[3]++;
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
			System.out.println(barxAxis.getCategories());
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
		checkSelection();
		linechartSeries = new XYChart.Series<Number, Number>();
		lineChart.setTitle("Arvosanojen jakauma vuoden mukaan");
		
		lineyAxis.setLabel("Graduja");
		linexAxis.setLabel("Arvosana");
		
		int i = 0, highest = 0;

		allTheses = new int[7];
		thesesBySelection = new int[7];
		for (Thesis t : visualTheses) {
			switch (t.getPggrade()) {
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
				switch (t.getPggrade()) {
				case 1:
					lineChartPGrades = new XYChart.Data<Number, Number>(t.getPggrade(), thesesBySelection[0]);
					break;
				case 2:
					lineChartPGrades = new XYChart.Data<Number, Number>(t.getPggrade(), thesesBySelection[1]);
					break;
				case 3:
					lineChartPGrades = new XYChart.Data<Number, Number>(t.getPggrade(), thesesBySelection[2]);
					break;
				case 4:
					lineChartPGrades = new XYChart.Data<Number, Number>(t.getPggrade(), thesesBySelection[3]);
					break;
				case 5:
					lineChartPGrades = new XYChart.Data<Number, Number>(t.getPggrade(), thesesBySelection[4]);
					break;
				case 6:
					lineChartPGrades = new XYChart.Data<Number, Number>(t.getPggrade(), thesesBySelection[5]);
					break;
				case 7:
					lineChartPGrades = new XYChart.Data<Number, Number>(t.getPggrade(), thesesBySelection[6]);
					break;
				}
				if (lineYear.getSelectionModel().getSelectedItem().equals(year)) {
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
				if(t.getSource()!=null) {
					if(t.getSource().length>1) {
						multiple3.setValue(multiple3.getValue()+1);
					} else {
						for(ChartSubject c : chartValues) {
							if(t.getSource()[0].substring(0, 1).equals(c.getName().substring(0, 1))) {
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
				for(ChartSubject c : chartValues) {
					if(t.getPggrade()==(c.getGrade())) {
						c.setValue(c.getValue()+1);
					}
				}
			}
			for(ChartSubject c : chartValues) {
				System.out.println(c.getValue());
				piechartdata.add(new PieChart.Data(c.getName(), c.getValue()));
			}
			pieChart.setTitle("Pro-graduja per arvosana");
			break;
		case 9:
			for(String s : lists.listGrades) {
				if(s.startsWith("1")) {
					chartValues.add(new ChartSubject("1. kiittäen hyväksytty", 0, 1));
				} else if(s.startsWith("2")) {
					chartValues.add(new ChartSubject("2. hyväksytty", 0, 2));
				} 
			}
			for(Thesis t : visualTheses) {
				for(ChartSubject c : chartValues) {
					if(t.getDtgrade()==(c.getGrade())) {
						c.setValue(c.getValue()+1);
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
		if(radarC.isSelected()) {
			numberofCharts++;
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
			break;
		case 1:
			if(barC.isSelected()) {
				barChart.setLayoutX(100);
				barChart.setLayoutY(200);
				barChart.setPrefSize(1000, 600);
			} 
			if(pieC.isSelected()) {
				pieChart.setLayoutX(250);
				pieChart.setLayoutY(200);
				pieChart.setPrefSize(600, 600);
			} 
			if(lineC.isSelected()) {
				lineChart.setLayoutX(250);
				lineChart.setLayoutY(200);
				lineChart.setPrefSize(600, 600);
			} 
			if(radarC.isSelected()) {
				
			}
				
			break;
		case 2:
			if(barC.isSelected()&&lineC.isSelected()) {
				barChart.setLayoutX(100);
				barChart.setLayoutY(200);
				barChart.setPrefSize(500, 500);
			} else if(barC.isSelected()) {
				barChart.setLayoutX(650);
				barChart.setLayoutY(200);
				barChart.setPrefSize(500, 500);
			}
			if(pieC.isSelected()) {
				pieChart.setLayoutX(100);
				pieChart.setLayoutY(200);
				pieChart.setPrefSize(500, 500);
			} 
			if(lineC.isSelected()) {
				lineChart.setLayoutX(650);
				lineChart.setLayoutY(200);
				lineChart.setPrefSize(500, 500);
			} 
			if(radarC.isSelected()) {
			}
			break;
		case 3:
			if(barC.isSelected()) {
				barChart.setLayoutX(700);
				barChart.setLayoutY(300);
				barChart.setPrefSize(300, 300);
			} 
			if(pieC.isSelected()) {
				pieChart.setLayoutX(100);
				pieChart.setLayoutY(300);
				pieChart.setPrefSize(300, 300);
			} 
			if(lineC.isSelected()) {
				lineChart.setLayoutX(400);
				lineChart.setLayoutY(300);
				lineChart.setPrefSize(300, 300);
			} 
			if(radarC.isSelected()) {
			}
			break;
		case 4:
			if(barC.isSelected()) {
				barChart.setLayoutX(100);
				barChart.setLayoutY(600);
				barChart.setPrefSize(400, 400);
			} 
			if(pieC.isSelected()) {
				pieChart.setLayoutX(100);
				pieChart.setLayoutY(150);
				pieChart.setPrefSize(400, 400);
			} 
			if(lineC.isSelected()) {
				lineChart.setLayoutX(600);
				lineChart.setLayoutY(150);
				lineChart.setPrefSize(400, 400);
			} 
			if(radarC.isSelected()) {
			}
			break;
		}
	}
}
*/
