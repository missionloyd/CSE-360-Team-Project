import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoadData {

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
}


