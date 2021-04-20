import java.util.ArrayList;
import java.util.LinkedList;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;

public class Model {

	private LinkedList<Patient> list = new LinkedList<Patient>();
	private File file;

	public void LoadData(File file) {
		String path = file.toString(), line = "";
		this.file = file;
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			line = br.readLine();
			while ((line = br.readLine()) != null) {
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

	public void AddPatient(String[] data) {
		Patient p;
		try {
			p = new Patient(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5]);
		} catch (NumberFormatException e){
			e.printStackTrace();
			p = new Patient(0, data[1], data[2], data[3], data[4], data[5]);
		}
		list.add(p);
	}

	public int[] getVaccCount() {
		String[] Comparables = { "Pfizer", "Moderna", "Johnson&Johnson", "Novavax", "AstraZeneca", "Sinovac" };
		int[] returnlist = new int[6];

		for (int i = 0; i < list.size(); i++) {
			String test = list.get(i).getVaccineType();
			for (int j = 0; j < 6; j++) {
				if (test.equals(Comparables[j])) {
					returnlist[j] += 1;
				}
			}
		}
		return returnlist;
	}

	public int getNumDifferentLocations(){
		ArrayList<String> locations = new ArrayList<String>();
		for(int i = 0; i < list.size(); i++){
			if(locations.size() == 0){
				locations.add(list.get(i).getVaccineLocation());
			} else {
				boolean match = false;
				for(int j = 0; j < locations.size(); j++){
					if(locations.get(j).equals(list.get(i).getVaccineLocation())){
						match = true;
					}
				}
				if(!match) {
					locations.add(list.get(i).getVaccineLocation());
				}
			}
		}
		return locations.size();
	}

	public Object[][] getVaccinationbyLocation(){
		ArrayList<String> locations = new ArrayList<String>();
		ArrayList<Integer> number = new ArrayList<Integer>();
		for(int i = 0; i < list.size(); i++){
			if(locations.size() == 0){
				locations.add(list.get(i).getVaccineLocation());
				number.add(1);
			} else {
				boolean match = false;
				for(int j = 0; j < locations.size(); j++){
					if(locations.get(j).equals(list.get(i).getVaccineLocation())){
						number.set(j, number.get(j) + 1);
						match = true;
					}
				}
				if(!match){
					locations.add(list.get(i).getVaccineLocation());
					number.add(1);
				}
			}
		}
		Object[][] returnList = new Object[locations.size()][number.size()];
		for(int i = 0; i < locations.size(); i++){
			returnList[i][0] = locations.get(i);
			returnList[i][1] = number.get(i);
		}

		return returnList;
	}

	public Object[][] getPatientList() {
		Object[][] returnList = new Object[list.size()][6];

		for (int i = 0; i < list.size(); i++) {
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

	public void SaveData() {
		String headers = "ID, Last Name, First Name, Vaccine Type, Vaccination Date, Vaccine Location";

		try {
			FileWriter writer = new FileWriter(file.toString());
			writer.write(headers + "\n");
			for (int i = 0; i < list.size(); i++) {
				writer.write(list.get(i).toString() + "\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
