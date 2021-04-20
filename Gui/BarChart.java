import java.awt.Color;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


public class BarChart extends JPanel{

	public BarChart(int[] data) {
		CategoryDataset dataset = createDataset(data);
		
		JFreeChart chart = createChart(dataset);
		ChartPanel chartPanel =  new ChartPanel(chart);
		chartPanel.setBackground(Color.white);
		this.add(chartPanel);
	}
	private CategoryDataset createDataset(int[] data) {
		var dataset = new DefaultCategoryDataset();
        dataset.setValue(data[0], "Number of Vaccinations", "Pfizer");
        dataset.setValue(data[1], "Number of Vaccinations", "Moderna");
        dataset.setValue(data[2], "Number of Vaccinations", "Johnson&Johnson");
        dataset.setValue(data[3], "Number of Vaccinations", "Novavax");
        dataset.setValue(data[4], "Number of Vaccinations", "AstraZeneca");
        dataset.setValue(data[5], "Number of Vaccinations", "Sinovac");
        return dataset;
	}
	
	private JFreeChart createChart(CategoryDataset dataset) {
		
		JFreeChart barChart = ChartFactory.createBarChart("Vaccination by type", "", "Number of Vaccinations", dataset, PlotOrientation.VERTICAL, false, true, false);
		
		return barChart;
	}

}
