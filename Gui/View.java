import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.File;


public class View extends JFrame {

    private JButton buttonAbout, buttonAdd, buttonLoad, buttonVisualize, buttonSave, buttonConfirm;
    private JPanel menuPanel, blankPanel, aboutPanel, addPanel;
    private JLabel aboutLabel, memberOne, memberTwo, memberThree, memberFour,askID, askFirstName, askLastName, askVaccType, askVaccDate,askVaccLocation, loadError;
    private JTextField id, fname, lname, vaccType, vaccDate, vaccLoc;
    private JTable table;
    private JScrollPane sp;
    private Object[][] Data;
    private String[] Columns = {"ID", "Last Name", "First Name", "Vaccine Type", "Vaccine Date", "Vaccine Location"};
    
    View(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,480);
        this.setTitle("CSE 360 FINAL PROJECT");
        this.setLayout(new BorderLayout());
        //Menu Panel
        menuPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(200,480));
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.PAGE_AXIS));
        buttonAbout = new JButton("About");
        buttonAbout.setAlignmentX(CENTER_ALIGNMENT);
        buttonLoad = new JButton("Load Data");
        buttonLoad.setAlignmentX(CENTER_ALIGNMENT);
        buttonAdd = new JButton("Add Data");
        buttonAdd.setAlignmentX(CENTER_ALIGNMENT);
        buttonSave = new JButton("Save Data");
        buttonSave.setAlignmentX(CENTER_ALIGNMENT);
        buttonVisualize = new JButton("Visualize Data");
        buttonVisualize.setAlignmentX(CENTER_ALIGNMENT);

        menuPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuPanel.add(buttonAbout);
        menuPanel.add(Box.createRigidArea(new Dimension(0,50)));
        menuPanel.add(buttonLoad);
        menuPanel.add(buttonAdd);
        menuPanel.add(buttonSave);
        menuPanel.add(buttonVisualize);
        menuPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        //PlaceHolder Panel
        blankPanel = new JPanel();
        
        //About Panel
        aboutPanel = new JPanel();
        aboutPanel.setPreferredSize(new Dimension(600,480));
        aboutPanel.setLayout(new BoxLayout(aboutPanel, BoxLayout.Y_AXIS));
        aboutLabel = new JLabel("Team Members:");
        aboutLabel.setAlignmentX(CENTER_ALIGNMENT);
        memberOne = new JLabel("Derek Anderson");
        memberOne.setAlignmentX(CENTER_ALIGNMENT);
        memberTwo = new JLabel("Luke Macy");
        memberTwo.setAlignmentX(CENTER_ALIGNMENT);
        memberThree = new JLabel("Jarren McBride");
        memberThree.setAlignmentX(CENTER_ALIGNMENT);
        memberFour = new JLabel("Huy Tao");
        memberFour.setAlignmentX(CENTER_ALIGNMENT);
        aboutPanel.add(aboutLabel);
        aboutPanel.add(Box.createRigidArea(new Dimension(0,100)));
        aboutPanel.add(memberOne);
        aboutPanel.add(memberTwo);
        aboutPanel.add(memberThree);
        aboutPanel.add(memberFour);
        
        //Add Panel
        addPanel = new JPanel(new GridLayout(7,2));
        addPanel.setPreferredSize(new Dimension(600,480));
        id = new JTextField(15);
        lname = new JTextField(20);
        fname = new JTextField(20);
        vaccType = new JTextField(30);
        vaccDate = new JTextField(15);
        vaccLoc = new JTextField(30);
        askID = new JLabel("Enter your ID:");
        askLastName = new JLabel("Enter your last Name:");
        askFirstName = new JLabel("Enter your first Name:");
        askVaccType = new JLabel("Enter the type of Vaccine:");
        askVaccDate = new JLabel("Enter date of vaccination: MM/DD/YYYY:");
        askVaccLocation = new JLabel("Enter location of vaccination:");
        buttonConfirm = new JButton("Confirm");
        addPanel.add(askID);
        addPanel.add(id);
        addPanel.add(askLastName);
        addPanel.add(lname);
        addPanel.add(askFirstName);
        addPanel.add(fname);
        addPanel.add(askVaccType);
        addPanel.add(vaccType);
        addPanel.add(askVaccDate);
        addPanel.add(vaccDate);
        addPanel.add(askVaccLocation);
        addPanel.add(vaccLoc);
        addPanel.add(new JLabel(""));
        addPanel.add(buttonConfirm);
        
        //Load Error Message
        loadError = new JLabel("ERROR: file either not supported or no file selected. Try Again!");
        
        this.add(menuPanel, BorderLayout.LINE_START);
        this.add(blankPanel, BorderLayout.CENTER);
        
    }

    public void displayAboutPanel() {
    	if (blankPanel != null) {
    		this.remove(blankPanel);
    	}
    	
    	blankPanel = aboutPanel;
    	this.add(blankPanel, BorderLayout.CENTER);
    	this.setVisible(true);
    }
    
    public void displayAddPanel() {
    	if(blankPanel != null) {
    		this.remove(blankPanel);
    	}
    	
    	blankPanel = addPanel;
    	this.add(blankPanel, BorderLayout.CENTER);
    	this.setVisible(true);
    }
    
    public String[] getDataFromAdd() {
    	String returnData[] = new String[6];
    	
    	returnData[0] = id.getText();
    	returnData[1] = lname.getText();
    	returnData[2] = fname.getText();
    	returnData[3] = vaccType.getText();
    	returnData[4] = vaccDate.getText();
    	returnData[5] = vaccLoc.getText();
    	
    	return returnData;
    }
    
    public void displayLoadError() {
    	if(blankPanel != null) {
    		this.remove(blankPanel);
    	}
    	
    	blankPanel = new JPanel();
    	loadError.setAlignmentX(CENTER_ALIGNMENT);
    	loadError.setAlignmentY(CENTER_ALIGNMENT);
    	blankPanel.add(loadError);
    	
    	this.add(blankPanel, BorderLayout.CENTER);
    	this.setVisible(true);
    }
    
    public void update(Object[][] newData) {
    	Data = newData;
    	if(blankPanel != null) {
    		this.remove(blankPanel);
    	}
    	displayTable();
    }
    
    public void displayTable() {
    	table = new JTable(Data, Columns);
    	sp = new JScrollPane(table);
    	sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    	blankPanel.add(sp);
    	this.add(blankPanel, BorderLayout.CENTER);
    	this.setVisible(true);
    	
    }
    
    public void createBarChart(int[] itemList) {
    	if(blankPanel != null) {
    		this.remove(blankPanel);
    	}
    	BarChart test = new BarChart(itemList);
    	blankPanel = test;
    	this.add(blankPanel);
    	this.setVisible(true);
    }

    public void createPieChart(Object[][] data, int size){
        if(blankPanel != null) {
            this.remove(blankPanel);
        }
        PieChart test = new PieChart(data, size);
        blankPanel = test;
        this.add(blankPanel);
        this.setVisible(true);
    }
    
    
    public File getFile() {
        File file;
        JFileChooser chooser = new JFileChooser(".");
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setFileFilter(new CSVFilter());
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
        buttonConfirm.addActionListener(aListener);
    }
}