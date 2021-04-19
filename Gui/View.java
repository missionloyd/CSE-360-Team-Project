import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.File;

public class View extends JFrame {

    private JButton buttonAbout, buttonAdd, buttonLoad, buttonVisualize, buttonSave;
    private JPanel menuPanel, emptyPanel;

    View(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,400);
        this.setTitle("CSE 360 FINAL PROJECT");

        menuPanel = new JPanel();
        menuPanel.setBounds(0, 0, 200, 400);
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.PAGE_AXIS));
        buttonAbout = new JButton("About");
        buttonLoad = new JButton("Load Data");
        buttonAdd = new JButton("Add Data");
        buttonSave = new JButton("Save Data");
        buttonVisualize = new JButton("Visualize Data");

        menuPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuPanel.add(buttonAbout);
        menuPanel.add(Box.createRigidArea(new Dimension(0,50)));
        menuPanel.add(buttonLoad);
        menuPanel.add(buttonAdd);
        menuPanel.add(buttonSave);
        menuPanel.add(buttonVisualize);
        menuPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        emptyPanel = new JPanel();
        emptyPanel.setBounds(200,0,400,400);

        this.add(menuPanel);
        this.add(emptyPanel);
    }

    public File getFile() {
        File file;
        JFileChooser chooser = new JFileChooser(".");
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int response = chooser.showOpenDialog(null);

        if(response == JFileChooser.APPROVE_OPTION){
            file = chooser.getSelectedFile();
        } else {
            file = null;
        }
        return file;
    }

    public void addListeners(ActionListener aListener) {
        buttonAbout.addActionListener(aListener);
        buttonSave.addActionListener(aListener);
        buttonLoad.addActionListener(aListener);
        buttonAdd.addActionListener(aListener);
        buttonVisualize.addActionListener(aListener);
    }
}