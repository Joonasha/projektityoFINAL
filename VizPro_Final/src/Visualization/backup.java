package Visualization;

import HelperClasses.Thesis;
import HelperClasses.lists;
import javafx.scene.chart.XYChart;

public class backup {
	/*
	int year;
	if(!drawn) {
		pgrades = new int[7];
		for(Thesis t : theses) {
			switch(t.getPggrade()) {
				case 1: pgrades[0]++;
					break;
				case 2: pgrades[1]++;
					break;
				case 3: pgrades[2]++;
					break;
				case 4: pgrades[3]++;
					break;
				case 5: pgrades[4]++;
					break;
				case 6: pgrades[5]++;
					break;
				case 7: pgrades[6]++;
					break;
			}
		}
		
		for(Thesis t : theses) {
			switch(t.getPggrade()) {
				case 1: lineChartPGrades = new XYChart.Data<Number, Number>(t.getPggrade(), pgrades[0]);
					break;
				case 2: lineChartPGrades = new XYChart.Data<Number, Number>(t.getPggrade(), pgrades[1]);
					break;
				case 3: lineChartPGrades = new XYChart.Data<Number, Number>(t.getPggrade(), pgrades[2]);
					break;
				case 4: lineChartPGrades = new XYChart.Data<Number, Number>(t.getPggrade(), pgrades[3]);
					break;
				case 5: lineChartPGrades = new XYChart.Data<Number, Number>(t.getPggrade(), pgrades[4]);
					break;
				case 6: lineChartPGrades = new XYChart.Data<Number, Number>(t.getPggrade(), pgrades[5]);
					break;
				case 7: lineChartPGrades = new XYChart.Data<Number, Number>(t.getPggrade(), pgrades[6]);
					break;
			}
			if(!drawn) {
				linechartdata.getData().add(lineChartPGrades);
			}
		}
		drawn = true;
	}
	lineChart.getData().add(linechartdata);
	*/
	
	
	/*
	String year;
	if(!drawn) {
		pgrades = new int[7];
		for(Thesis t : theses) {
			switch(t.getPggrade()) {
				case 1: pgrades[0]++;
					break;
				case 2: pgrades[1]++;
					break;
				case 3: pgrades[2]++;
					break;
				case 4: pgrades[3]++;
					break;
				case 5: pgrades[4]++;
					break;
				case 6: pgrades[5]++;
					break;
				case 7: pgrades[6]++;
					break;
			}
		}
		
		for(Thesis t : theses) {
			year=t.getYear();
			if(!lineYear.getSelectionModel().isEmpty()) {
				if(lineYear.getSelectionModel().getSelectedItem().equals(year)) {
					switch(t.getPggrade()) {
					case 1: lineChartPGrades = new XYChart.Data<Number, Number>(t.getPggrade(), pgrades[0]);
						break;
					case 2: lineChartPGrades = new XYChart.Data<Number, Number>(t.getPggrade(), pgrades[1]);
						break;
					case 3: lineChartPGrades = new XYChart.Data<Number, Number>(t.getPggrade(), pgrades[2]);
						break;
					case 4: lineChartPGrades = new XYChart.Data<Number, Number>(t.getPggrade(), pgrades[3]);
						break;
					case 5: lineChartPGrades = new XYChart.Data<Number, Number>(t.getPggrade(), pgrades[4]);
						break;
					case 6: lineChartPGrades = new XYChart.Data<Number, Number>(t.getPggrade(), pgrades[5]);
						break;
					case 7: lineChartPGrades = new XYChart.Data<Number, Number>(t.getPggrade(), pgrades[6]);
						break;
					}
				}
				if(!drawn&&lineChartPGrades!=null) {
					linechartdata.getData().add(lineChartPGrades);
				}
			}
		}
		drawn = true;
	} 
	lineChart.getData().add(linechartdata);
	*/
	
	/*
	allTheses = new int[5];
		thesesBySelection = new int[5];
		for(Thesis t : visualTheses) {
			if(t.getResearchSubjects().length>1) {
				subject = 5;
			} else {
				System.out.println(t.getResearchSubjects()[0]);
				subject = Integer.valueOf(t.getResearchSubjects()[0].substring(0,1));
			}
			
			switch (subject) {
			case 1:
				if(t.getResearchSubjects()[0].substring(0,1).equals(lineSubject.getSelectionModel().getSelectedItem().substring(0,1))) {
					thesesBySelection[0]++;
				}
				allTheses[0]++;
				break;
			case 2:
				if(t.getResearchSubjects()[0].substring(0,1).equals(lineSubject.getSelectionModel().getSelectedItem().substring(0,1))) {
					thesesBySelection[1]++;
				}
				allTheses[1]++;
				break;
			case 3:
				if(t.getResearchSubjects()[0].substring(0,1).equals(lineSubject.getSelectionModel().getSelectedItem().substring(0,1))) {
					thesesBySelection[2]++;
				}
				allTheses[2]++;
				break;
			case 4:
				if(t.getResearchSubjects()[0].substring(0,1).equals(lineSubject.getSelectionModel().getSelectedItem().substring(0,1))) {
					thesesBySelection[3]++;
				}
				allTheses[3]++;
				break;
			case 5:
				if(t.getResearchSubjects()[0].substring(0,1).equals(lineSubject.getSelectionModel().getSelectedItem().substring(0,1))) {
					thesesBySelection[4]++;
				}
				allTheses[4]++;
				break;
			}
		}
		if (lineSubject.getSelectionModel().getSelectedItem() != null) {
			highest = 0;
			for (int t : thesesBySelection) {
				if (t > highest) {
					highest = t;
				}
			}
			yAxis.setUpperBound(highest + 5);
			
			for (Thesis t : visualTheses) {
				if(t.getResearchSubjects().length>1) {
					subject = 5;
				} else {
					subject = Integer.valueOf(t.getResearchSubjects()[0].substring(0,1));
				}
				switch (subject) {
				case 1:
					lineChartSubjects = new XYChart.Data<Number, Number>(Integer.valueOf(t.getResearchSubjects()[0].substring(0,1)), thesesBySelection[0]);
					break;
				case 2:
					lineChartSubjects = new XYChart.Data<Number, Number>(Integer.valueOf(t.getResearchSubjects()[0].substring(0,1)), thesesBySelection[1]);
					break;
				case 3:
					lineChartSubjects = new XYChart.Data<Number, Number>(Integer.valueOf(t.getResearchSubjects()[0].substring(0,1)), thesesBySelection[2]);
					break;
				case 4:
					lineChartSubjects = new XYChart.Data<Number, Number>(Integer.valueOf(t.getResearchSubjects()[0].substring(0,1)), thesesBySelection[3]);
					break;
				case 5:
					lineChartSubjects = new XYChart.Data<Number, Number>(Integer.valueOf(t.getResearchSubjects()[0].substring(0,1)), thesesBySelection[4]);
					break;
				}

				if (lineSubject.getSelectionModel().getSelectedItem().substring(0,1).equals(t.getResearchSubjects()[0].substring(0,1))) {
					System.out.println("DAS");
					if (!drawn && lineChartSubjects != null
							&& !selectedSubjects.contains(lineSubject.getSelectionModel().getSelectedItem().substring(0,1))) {
						linechartdata.getData().add(lineChartSubjects);
						linechartdata.setName(year);

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
			yAxis.setUpperBound(highest + 5);
			for (i = 0; i < allTheses.length; i++) {
				lineChartPGrades = new XYChart.Data<Number, Number>(i + 1, allTheses[i]);
				linechartdata.getData().add(lineChartSubjects);
				linechartdata.setName("Kaikki");
			}
		}

		if (!selectedSubjects.contains(lineSubject.getSelectionModel().getSelectedItem().substring(0,1))) {
			System.out.println("ASD");
			lineChart.getData().add(linechartdata);
			selectedSubjects.add(lineSubject.getSelectionModel().getSelectedItem().substring(0,1));
		}
	 */
	
	/*
	checkSelection();
		linechartSeries =new XYChart.Series<String, Number>();
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
			for (Thesis t : visualTheses) {
				year = t.getYear();
				switch (t.getPggrade()) {
				case 1:
					lineChartPGrades = new XYChart.Data<String, Number>(lists.listGrades.get(0), thesesBySelection[0]);
					break;
				case 2:
					lineChartPGrades = new XYChart.Data<String, Number>(lists.listGrades.get(1), thesesBySelection[1]);
					break;
				case 3:
					lineChartPGrades = new XYChart.Data<String, Number>(lists.listGrades.get(2), thesesBySelection[2]);
					break;
				case 4:
					lineChartPGrades = new XYChart.Data<String, Number>(lists.listGrades.get(3), thesesBySelection[3]);
					break;
				case 5:
					lineChartPGrades = new XYChart.Data<String, Number>(lists.listGrades.get(4), thesesBySelection[4]);
					break;
				case 6:
					lineChartPGrades = new XYChart.Data<String, Number>(lists.listGrades.get(5), thesesBySelection[5]);
					break;
				case 7:
					lineChartPGrades = new XYChart.Data<String, Number>(lists.listGrades.get(6), thesesBySelection[6]);
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
			lineyAxis.setUpperBound(highest+5);
			for (i = 0; i < allTheses.length; i++) {
				lineChartPGrades = new XYChart.Data<String, Number>(lists.listGrades.get(i), allTheses[i]);
				linechartSeries.getData().add(lineChartPGrades);
				linechartSeries.setName("Kaikki");
			}
		}
		if (!selectedYears.contains(lineYear.getSelectionModel().getSelectedItem())) {
			lineChart.getData().add(linechartSeries);
			selectedYears.add(lineYear.getSelectionModel().getSelectedItem());
		}
	 */
}
