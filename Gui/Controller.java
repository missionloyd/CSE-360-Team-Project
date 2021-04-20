import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class Controller{

    private Model model;
    private View root;
    
    Controller(View panel, Model aModel){
        this.root = panel;
        this.model = aModel;
        root.addListeners(new ButtonListener());
    }

    class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getActionCommand() == "About"){
            	root.displayAboutPanel();
            }
            if(e.getActionCommand() == "Add Data"){
            	root.displayAddPanel();
            }
            if(e.getActionCommand() == "Save Data"){
                model.SaveData();
                root.update(model.getPatientList());
            }
            if(e.getActionCommand() == "Load Data"){
            	File file = root.getFile();
            	
            	if(file !=null) {
            		model.LoadData(file);
            		root.update(model.getPatientList());
            	} else {
            		root.displayLoadError();
            	}
            }
            if(e.getActionCommand() == "Visualize Data"){
                //root.createBarChart(model.getVaccCount());
                root.createPieChart(model.getVaccinationbyDate(), model.getNumDifferentDates());
            }
            if(e.getActionCommand() == "Confirm") {
            	model.AddPatient(root.getDataFromAdd());
            	root.update(model.getPatientList());
            }
        }
    }
}