package Visualization;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;

public class Charts {

    public static PieChart createPieChart(ArrayList<String[]> tmp) {
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
        for (String[] value : tmp) {
            data.add(new PieChart.Data(value[0], Double.valueOf(value[1])));
        }
        final PieChart chart = new PieChart(data);
        return chart;
    }
    
}
