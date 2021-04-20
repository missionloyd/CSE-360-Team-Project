import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;
import static javafx.application.Application.launch;
import javafx.scene.Group;


/**
 * JavaFX App
 */
public class App extends Application {

           
    @Override
    public void start(Stage stage) {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc =
                new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Vaccines Administered");
        xAxis.setLabel("Vaccine Type");
        yAxis.setLabel("Number of Vaccines Administered");
        int flag = 1;
        int reminder = 0;
        ArrayList<ArrayList> dataArrayList = new ArrayList<ArrayList>();
        ArrayList<String> numberOfLocations = new ArrayList<String>();
        for (int i = 0; i < dataArrayList.size(); i++)
        {
              if (numberOfLocations.isEmpty()){
                String firstlocation = String.valueOf(dataArrayList.get(0).get(3));
                int firstNumber = 1;
                numberOfLocations.add(firstlocation);
                numberOfLocations.add(String.valueOf(firstNumber));
            }  
            String location = String.valueOf(dataArrayList.get(i).get(3));
            int number = 1;
            for (int j = 0; j < numberOfLocations.size(); j++)
            {
                if (numberOfLocations.get(j).equals(location))
                {
                    flag = 0;
                }
            }
            if (flag == 1)
                {
                    numberOfLocations.add(location);
                    numberOfLocations.add(String.valueOf(number));
                }
                
            for (int k = 0; k < dataArrayList.size(); k++)
            {
            if (location == dataArrayList.get(k).get(3) && flag == 1)
                {
                   int number1 = Integer.parseInt(numberOfLocations.get(reminder + 1));
                   number1 = number1 + 1;
                   numberOfLocations.set(reminder + 1, String.valueOf(number1));
                }
            }
            flag = 0;
            reminder = reminder + 2;
        }
        XYChart.Series series = new XYChart.Series();
        for(int i = 0; i < numberOfLocations.size(); i = i+2)
        {
            series.getData().add(new XYChart.Data(numberOfLocations.get(i), Double.parseDouble(numberOfLocations.get(i+1))));
        }
        bc.getData().add(series);
        JPanel barPanel = new JPanel();
        barPanel.setPrefferedSize(new Dimension(40, 400));
        barPanel.setLayout(new BoxLayout(barPanel, BoxLayout.Y_AXIS));
        barPanel.add(bc);
        
        Scene scene = new Scene(barPanel,800,600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

