import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{
	
	ArrayList<String> aList = new ArrayList<String>();; 
	public Main() 
	{	
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(0,1));
		
		JButton addButton = new JButton("Add");
		
		jp.add(addButton);
		
		JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(3,1));
		frame.setSize(500,500);
		frame.add(jp);
		
		frame.setVisible(true);
		
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JFrame newFrame = new JFrame();	
				newFrame.setSize(500,500);
				
				JPanel addPanel = new JPanel();
				GridLayout layout = new GridLayout(7,2);
				addPanel.setLayout(layout);
				
				// ID label and textfield
				JLabel idLab = new JLabel("Enter your ID: ");
				JTextField idText = new JTextField(15);
				addPanel.add(idLab);
				addPanel.add(idText);
				
				//last name label and textfield
				JLabel lNameLab = new JLabel("What is your Last Name: ");
				JTextField lNameText = new JTextField(25);
				addPanel.add(lNameLab);
				addPanel.add(lNameText);
				
				//first name label and textfield
				JLabel fNameLab = new JLabel("What is your First Name: ");
				JTextField fNameText = new JTextField(25);
				addPanel.add(fNameLab);
				addPanel.add(fNameText);
				
				//vaccination type label and textfield
				JLabel vaccTypeLab = new JLabel("Enter the type of vaccine: ");
				JTextField vaccTypeText = new JTextField(25);
				addPanel.add(vaccTypeLab);
				addPanel.add(vaccTypeText);
				
				//Vaccination date label and textfield
				JLabel vaccDateLab = new JLabel("Enter the date of vaccination MM/DD/YYYY: ");
				JTextField vaccDateText = new JTextField(25);
				addPanel.add(vaccDateLab);
				addPanel.add(vaccDateText);
				
				//vaccination location label and textfield
				JLabel vaccLocLab = new JLabel("Enter the location of vaccination: ");
				JTextField vaccLocText = new JTextField(25);
				addPanel.add(vaccLocLab);
				addPanel.add(vaccLocText);
				
				newFrame.add(addPanel);
				
				JButton submit = new JButton("Submit");
				
				JPanel panel = new JPanel();
				panel.add(submit);
				jp.add(panel);
				addPanel.add(panel);
				
				submit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String id = idText.getText();
						String lName = lNameText.getText();
						String fName = fNameText.getText();
						String vaccType = vaccTypeText.getText();
						String vaccDate = vaccDateText.getText();
						String vaccLoc = vaccLocText.getText();

						aList.add(id);	
						aList.add(lName);
						aList.add(fName);
						aList.add(vaccType);
						aList.add(vaccDate);
						aList.add(vaccLoc);
						
						//Print to see if adds to list
						System.out.println(aList);	
						
						//TODO add to table 
						
						aList.clear();
						
					}
				});
				
				newFrame.setVisible(true);	
				
			}
		});
		
	}

	public static void main(String[] args) 
	{
		new Main();	
		
	}

}
