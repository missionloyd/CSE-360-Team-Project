import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;
import java.util.ArrayList;
import static javafx.application.Application.launch;


public class pieChart extends Application{
            @Override public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setWidth(500);
        stage.setHeight(500);
        int flag = 1;
        int reminder = 0;
        ArrayList<ArrayList> dataArrayList = new ArrayList<ArrayList>();
        ArrayList<String> numberOfLocations = new ArrayList<String>();
        for (int i = 0; i < dataArrayList.size(); i++)
        {
              if (numberOfLocations.isEmpty()){
                String firstlocation = String.valueOf(dataArrayList.get(0).get(5));
                int firstNumber = 1;
                numberOfLocations.add(firstlocation);
                numberOfLocations.add(String.valueOf(firstNumber));
            }  
            String location = String.valueOf(dataArrayList.get(i).get(5));
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
            if (location == dataArrayList.get(k).get(5) && flag == 1)
                {
                   int number1 = Integer.parseInt(numberOfLocations.get(reminder + 1));
                   number1 = number1 + 1;
                   numberOfLocations.set(reminder + 1, String.valueOf(number1));
                }
            }
            flag = 0;
            reminder = reminder + 2;
        }
   
        PieChart pieChart = new PieChart();
                for(int i = 0; i < numberOfLocations.size(); i = i+2)
                {
                    PieChart.Data slice = new PieChart.Data(numberOfLocations.get(i), Double.parseDouble(numberOfLocations.get(i+1)));
                    pieChart.getData().add(slice);
                }
        pieChart.setTitle("Vaccine Location");
        JPanel piePanel = new JPanel();
        piePanel.setPrefferedSize(new Dimension(40, 400));
        piePanel.setLayout(new BoxLayout(piePanel, BoxLayout.Y_AXIS));
        piePanel.add(pieChart);
        
        ((Group) scene.getRoot()).getChildren().add(piePanel);
        stage.setScene(scene);
        stage.show();
        
        
    }
    public void main(String[] args) {
        launch(args);
    }
}
}




