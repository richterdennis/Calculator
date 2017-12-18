package de.thm.se.calculator;

import java.util.Optional;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

public class DialogCreator extends Dialog{
	
	String vOne;
	String vTwo;


	
	public DialogCreator(String header, String title, String one, String two) {
		this.setHeaderText(header);
	    this.setTitle(title);
	    ButtonType okbutton = new ButtonType("OK", ButtonData.OK_DONE);
	    this.getDialogPane().getButtonTypes().addAll(okbutton, ButtonType.CANCEL);
	    GridPane gridPane = new GridPane();
	    gridPane.setHgap(10);
	    gridPane.setVgap(10);
	    gridPane.setPadding(new Insets(20, 150, 10, 10));
	    TextField eins = new TextField();
	    eins.setPromptText(one);
	    TextField zwei = new TextField();
	    zwei.setPromptText(two);
	    gridPane.add(new Label(one), 0, 0);
	    gridPane.add(eins, 0, 1);
	    gridPane.add(new Label(two), 1, 0);
	    gridPane.add(zwei, 1, 1);
	    this.getDialogPane().setContent(gridPane);

	    // Set Focus to Basis-Field
	    Platform.runLater(() -> eins.requestFocus());

	    // Convert the result to a username-password-pair when the login button is clicked.
	    this.setResultConverter(dialogButton -> {
	        if (dialogButton == okbutton) {
	            return new Pair<>(eins.getText(), zwei.getText());
	        }
	        return null;
	    });
	    
	 Optional<Pair<String, String>> result = this.showAndWait();

	   result.ifPresent(pair -> {
	    	vOne = pair.getKey();
	    	vTwo = pair.getValue();
	    });
		
	}

	public String getOne() {
		return vOne;
	}
	
	public String getTwo() {
		return vTwo;
	}
	
	public void setOne(String one) {
		this.vOne = vOne;
	}
	
	public void setTwo(String two) {
		this.vTwo = vTwo;
	}
	
	

}
