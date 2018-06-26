package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.StackPane;
//import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Display extends Application{
		
	public static void main(String[] args) {
		
		launch(args);
		
	}
	
	
	@Override
	public void start(Stage stage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("HomeFXML.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Subnetter by Luke Dependahl");
		stage.setScene(scene);
		stage.show();
	}
			
}