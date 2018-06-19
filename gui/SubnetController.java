package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SubnetController {
	
	@FXML private AnchorPane rootPane;
	@FXML TextField ipAddress;
	@FXML TextField addClass;
	@FXML TextField nSubnets;
	@FXML TextField nHosts;
	@FXML TextField defaultMask;
	@FXML TextField uSubnets;
	@FXML TextField uHosts;
	@FXML TextField customMask;
	@FXML Label status;
	
	private int oct[] = new int[4];
	
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
		System.out.println("You're already here!");
		AnchorPane pane = FXMLLoader.load(getClass().getResource("SubnetFXML.fxml"));
		rootPane.getChildren().setAll(pane);
		
	}
	
	public void vlsmButtonClicked() throws IOException {
		System.out.println("Loading VLSM...");
		AnchorPane pane = FXMLLoader.load(getClass().getResource("VLSMFXML.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	public void resultButtonClicked() throws IOException {
		System.out.println("Loading Results...");
		AnchorPane pane = FXMLLoader.load(getClass().getResource("ResultFXML.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	public void infoSetting(ActionEvent event) {
		
		//int savedIPAddress = Integer.parseInt(ipAddress.getText());
		//sendIP(ipAddress.getText());
		System.out.println(ipAddress.getText());
		
		if(nSubnets.getText().equals("") && nHosts.getText().equals("")) {
			int savedNSubnets = 0;
			int savedNHosts = 0;
			status.setText("You must enter valid data into each field.");
			System.out.println("You must enter valid data into each field.");
		}
		else if(nSubnets.getText().equals("")) {
			int savedNSubnets = 0;
			int savedNHosts = Integer.parseInt(nHosts.getText());
		}
		else if(nHosts.getText().equals("")) {
			int savedNHosts = 0;
			int savedNSubnets = Integer.parseInt(nSubnets.getText());
		}
		
	}
	
}