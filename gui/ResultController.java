package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class ResultController {
	
	@FXML
	private AnchorPane rootPane;
	
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}
	
	//When one of the following is pressed, it will change the scene.
	public void homeButtonClicked(ActionEvent event) throws IOException {
		System.out.println("Loading Home...");
		AnchorPane pane = FXMLLoader.load(getClass().getResource("HomeFXML.fxml"));
		rootPane.getChildren().setAll(pane);
		
	}
	
	public void subnetButtonClicked(ActionEvent event) throws IOException {
		System.out.println("Loading Subnet...");
		AnchorPane pane = FXMLLoader.load(getClass().getResource("SubnetFXML.fxml"));
		rootPane.getChildren().setAll(pane);
		
	}
	
	public void vlsmButtonClicked() throws IOException {
		System.out.println("Loading VLSM...");
		AnchorPane pane = FXMLLoader.load(getClass().getResource("VLSMFXML.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	public void resultButtonClicked() throws IOException {
		System.out.println("You're already here...");
		AnchorPane pane = FXMLLoader.load(getClass().getResource("ResultFXML.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
}
