package de.thm.se.calculator;

import java.util.Optional;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

public class DialogCreator extends Dialog{
	
	String vOne;
	String vTwo;


	// Create Dialog
	public DialogCreator(String header, String title, String one, String two) {
		// Set Details of Dialog (Header, Title, Gridpane with two Textfields)
		this.setHeaderText(header);
	    this.setTitle(title);
	    ButtonType okbutton = new ButtonType("OK", ButtonData.OK_DONE);
	    this.getDialogPane().getButtonTypes().addAll(okbutton, ButtonType.CANCEL);
	    GridPane gridPane = new GridPane();
	    gridPane.setPrefSize(500, 150);
	    gridPane.setHgap(10);
	    gridPane.setVgap(10);
	    gridPane.setPadding(new Insets(20, 150, 10, 10));
	    TextField eins = new TextField();
	    eins.setPrefSize(240, 50);
	    eins.setPromptText(one);
	    TextField zwei = new TextField();
	    zwei.setPrefSize(240, 50);
	    zwei.setPromptText(two);
	    gridPane.add(new Label(one), 0, 0);
	    gridPane.add(eins, 0, 1);
	    gridPane.add(new Label(two), 1, 0);
	    gridPane.add(zwei, 1, 1);
	    this.getDialogPane().setContent(gridPane);

	    // Set Focus to First Field
	    Platform.runLater(() -> eins.requestFocus());

	    // Convert the result to a Pair
	    this.setResultConverter(dialogButton -> {
	        if (dialogButton == okbutton) {
	            return new Pair<>(eins.getText(), zwei.getText());
	        }
	        return null;
	    });
	    
	    // Get the Pair
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
}
