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

public class NewClass {

    //  1. Ask user for filepath to .csv file
    //  2. Read the file
    //  3. Load data into a data structure (designed by your team)
    //  4. Display data in a table in application

    // local variables
    BufferedReader fileBuffer = null;
    ArrayList<ArrayList> dataArrayList = new ArrayList<ArrayList>();
    String filepath = null;
    //  1. Ask user for filepath to .csv file
    // TODO: create input field in the ui to read filepath

    public void readFilePath(String filePath) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input filepath to .csv file");

        filePath = scanner.nextLine();
        scanner.close();
    }

    //  2. Read the file
    // TODO: create button in the ui to start reading in the data from the path

    public void readFile(ArrayList<ArrayList> dataArrayList, String filePath) {
        try {  
            String fileLine;
            fileBuffer = new BufferedReader(new FileReader(filePath));
   
            // copy values of each line into dataArrayList (list of lists)
            while ((fileLine = fileBuffer.readLine()) != null) {
                System.out.println("Raw CSV: " + fileLine);
                dataArrayList.add(CSVtoArrayList(fileLine));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileBuffer != null) {
                    fileBuffer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n");
    }

    // 3. Load data into a data structure (designed by your team)
    public void loadData(ArrayList<ArrayList> dataArrayList) {

        if (dataArrayList != null) {
            // iterate through entire list
            for(int i = 1; i < dataArrayList.size(); i++) {

                // iterate through each line

                // convert objects to respective types
                int id = Integer.parseInt(dataArrayList.get(i).get(0).toString());
                String lname = String.valueOf(dataArrayList.get(i).get(1));
                String fname = String.valueOf(dataArrayList.get(i).get(2));
                String vaccType = String.valueOf(dataArrayList.get(i).get(3));
                String vaccDate = String.valueOf(dataArrayList.get(i).get(4));
                String vaccLocation = String.valueOf(dataArrayList.get(i).get(5));

                Employee employee = new Employee(
                    id,
                    lname,
                    fname,
                    vaccType,
                    vaccDate,
                    vaccLocation    
                );

                // print for debugging
                System.out.println("ID: " + id);
                System.out.println("Last Name: " + lname);
                System.out.println("First Name: " + fname);
                System.out.println("Vaccine Type: " + vaccType);
                System.out.println("Vaccination Date: " + vaccDate);
                System.out.println("Vaccine Location: " + vaccLocation);  
                System.out.println("\n");
            }
        }
    }

    //  TODO: 4. Display data in a table in application
    //  (create ui data table)

    // util function that converts CSV to ArrayList using Split Operation
public static ArrayList<String> CSVtoArrayList(String CSV) {

ArrayList<String> result = new ArrayList<String>();

if (CSV != null) {

            // split data using regex
String[] splitData = CSV.split("\\s*,\\s*");

for (int i = 0; i < splitData.length; i++) {

                // trim data
if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
result.add(splitData[i].trim());
}
}
}
return result;
}

public class LocationsVisualize extends Application{
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




