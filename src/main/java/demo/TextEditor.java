package demo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TextEditor{
	public JTextArea textField;
	public TextEditor(int x, int y){
		JFrame frame = new JFrame();
		frame.setTitle("Text Editor by Salih in JAVA");
		frame.setSize(x, y);
		JPanel panel = new JPanel();

		textField = new JTextArea(40, 88);
		textField.setLineWrap(true);
		textField.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(textField);

		//Button
		JButton button = new JButton("Save File");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveFile();

			}
		});



		panel.add(scrollPane);
		panel.add(button);
		frame.add(panel);
		frame.setVisible(true);

	}
	public String getTextArea(){
		return textField.getText();
	}
	public void saveFile(){
		String text = getTextArea();

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
			writer.write(text);
			writer.close();
			System.out.println("JTextArea content saved to file successfully.");
		} catch (IOException e) {
			System.out.println("An error occurred while saving the file.");
			e.printStackTrace();
		}
	}

	public static void main(String[]args){
		TextEditor textEditor = new TextEditor(1000, 800);

	}
}
