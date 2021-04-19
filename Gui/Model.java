import java.util.LinkedList;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;

public class Model {
    
    private LinkedList<Patient> list = new LinkedList<Patient>();

    public void LoadData(File file){
        String path = file.toString(), line = "";
        try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			line = br.readLine();
            while ((line = br.readLine()) != null){
                String[] data = line.split(",");
                Patient p = new Patient(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5]);
                list.add(p);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void AddPatient(String[] data){
        Patient p = new Patient(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5]);
        list.add(p);
    }

    public Object[][] getPatientList(){
        Object[][] returnList = new Object[list.size()][6];

        for(int i = 0; i < list.size(); i++){
            Patient temp = list.get(i);
            returnList[i][0] = temp.getID();
            returnList[i][1] = temp.getLastName();
            returnList[i][2] = temp.getFirstName();
            returnList[i][3] = temp.getVaccineType();
            returnList[i][4] = temp.getVaccineDate();
            returnList[i][5] = temp.getVaccineLocation();
        }

        return returnList;
    }


    public void SaveData(){
        String headers = "ID, Last Name, First Name, Vaccine Type, Vaccination Date, Vaccine Location";

        try {
            FileWriter writer = new FileWriter("saveFile.csv");
            writer.write(headers+"\n");
            for(int i = 0; i < list.size(); i++){
                writer.write(list.get(i).toString()+ "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
