package de.thm.se.calculator;
	

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			// Get Screen Size
			// Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
			//root.setMaxHeight(visualBounds.getHeight());
			//root.setMaxWidth(visualBounds.getWidth());
			VBox root = (VBox) FXMLLoader.load(getClass().getResource("GUI.fxml"));
			root.setFillWidth(false);
			Scene scene = new Scene(root,1920, 1080);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setFullScreen(true);
			primaryStage.setMaximized(true);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();}
		
	} 
	
	public static void main(String[] args) { 
		Application.launch(args);
	}
	
	}
