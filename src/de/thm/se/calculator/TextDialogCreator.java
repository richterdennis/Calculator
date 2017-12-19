package de.thm.se.calculator;

import java.io.FileInputStream;
import java.util.Optional;

import javafx.fxml.FXMLLoader;
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
		    
		    /* if (vOne.contains("p")) vOne.replace("p",new Op new Decimal(Math.PI).toString());
		    System.out.println(vOne);
		    if (vOne.contains("e")) vOne.replace("e", new Decimal(Math.E).toString());
		    */
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
