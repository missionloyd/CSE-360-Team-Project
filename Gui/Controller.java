import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

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

            }
            if(e.getActionCommand() == "Add Data"){
                
            }
            if(e.getActionCommand() == "Save Data"){
                model.SaveData();
            }
            if(e.getActionCommand() == "Load Data"){
                model.LoadData(root.getFile());
            }
            if(e.getActionCommand() == "Visualize Data"){
                
            }
        }
    }
}