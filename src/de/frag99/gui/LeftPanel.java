package de.frag99.gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import de.frag99.machine.DoubleRhyme;

public class LeftPanel extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7152458506548820465L;
	
	private JTextField inputField;
	private JButton searchButton;
	private RadioButtonPanel rhymeSelect;
	private JComboBox<String> languageSelect;
	private final String[] languages  = {"de"};
	
	public LeftPanel() {
		
		this.setBackground(Color.LIGHT_GRAY);
		this.setLayout(new GridLayout(4, 1, 10, 20));
		
		inputField = new JTextField();
		inputField.setPreferredSize(new Dimension(50, 50));
		inputField.addActionListener(this);
		
		searchButton = new JButton();
		searchButton.setText("Search");
		searchButton.setFocusable(false);
		searchButton.addActionListener(this);
		
		
		
		languageSelect = new JComboBox<>(languages);
		
		
		
		this.add(inputField);
		this.add(searchButton);
		
		rhymeSelect = new RadioButtonPanel();
		this.add(rhymeSelect);
		
		this.add(languageSelect);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==inputField || e.getSource() == searchButton) {
			DoubleRhyme.userInput = inputField.getText();
			DoubleRhyme.rhymeType = rhymeSelect.getSelectedButton();
			
			
			DoubleRhyme.lang = String.valueOf(languageSelect.getSelectedItem());
			
			inputField.setEnabled(false);
			searchButton.setEnabled(false);
			rhymeSelect.setButtonsEnabled(false);
			languageSelect.setEnabled(false);
			
			//search rhymes
			DoubleRhyme.start();
		}

	}
	
	public void reenable() {
		inputField.setEnabled(true);
		searchButton.setEnabled(true);
		rhymeSelect.setButtonsEnabled(true);
		languageSelect.setEnabled(true);
	}
	

	
}