import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;

public class PieChart extends JPanel {

    public PieChart(Object[][] data, int size){
        DefaultPieDataset dataset = createDatset(data, size);

        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBackground(Color.white);
        this.add(chartPanel);
    }


    private DefaultPieDataset createDatset(Object[][] data, int size){
        var dataset = new DefaultPieDataset();
        for(int i = 0; i < size; i++){
            dataset.setValue(data[i][0].toString(), Integer.parseInt(data[i][1].toString()));
        }
        return dataset;
    }

    private JFreeChart createChart(DefaultPieDataset dataset){
        JFreeChart pieChart = ChartFactory.createPieChart("Vaccination by Date",dataset,false,true,false);

        return pieChart;
    }
}
