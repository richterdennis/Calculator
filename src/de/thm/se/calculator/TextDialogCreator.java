package de.thm.se.calculator;

import java.util.Optional;

import javafx.scene.control.TextInputDialog;

public class TextDialogCreator extends TextInputDialog{
	String vOne;
	
	public TextDialogCreator(String title, String header, String content) {
		this.setTitle(title);
		this.setHeaderText(header);
		this.setContentText(content);
		
		Optional<String> result = this.showAndWait();
		if (result.isPresent()){
		    System.out.println("Result: " + result.get());
		    vOne = result.get();
		}
		
	}
	
	public void setValue(String vOne) {
		this.vOne = vOne;
	}
	
	public String getValue() {
		return vOne;
	}
	
	

	
}
