package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class VLSMController {
	
	@FXML private AnchorPane rootPane;
	@FXML GridPane grid;
	@FXML TextField subnets;
	@FXML Label currentStatus;
	
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
		System.out.println("You're already here!");
		AnchorPane pane = FXMLLoader.load(getClass().getResource("VLSMFXML.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	public void resultButtonClicked() throws IOException {
		System.out.println("Loading Results...");
		AnchorPane pane = FXMLLoader.load(getClass().getResource("ResultFXML.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	/*
	@FXML
	private void addSubnetFields(ActionEvent event)  {     
		TextField newField = new TextField();
		newField.setStyle("-fx-background-color: #282e36; -fx-text-fill: #e3e3e3;");
		//grid.setConstraints(newField, 1, 0);
		//grid.getChildren().add(new Label(), 1, 0);
		grid.add(newField, 0, 0);
	}
	*/
	
	@FXML
	private void addSubnetFields(ActionEvent event) {
		System.out.println("Starting...");
		
		System.out.println(subnets.getText());
		int subnetAmount = 0;
		
		if(subnets.getText().equals("")) {
			subnetAmount = 0;
			System.out.println("Missing content in the subnets field.");
			currentStatus.setText("Missing content in the subnets field.");
		}
		else if(subnets.getText().equals("0")) {
			subnetAmount = 0;
			System.out.println("Subnets cannot be 0.");
			currentStatus.setText("Subnets cannot be 0.");
		}
		else {
			subnetAmount = Math.abs(Integer.parseInt(subnets.getText()));
		}
		
		ArrayList<Label> subnetLabels = new ArrayList<Label>(subnetAmount);
		ArrayList<TextField> subnetFields = new ArrayList<TextField>(subnetAmount);
		
		int j = 0, k = 0, l = 0, m = 0;
		for(int i = 0; i < subnetAmount; i++) {
			subnetLabels.add(new Label("Subnet " + Integer.toString(i) + ":"));
			subnetLabels.get(i).setFont(new Font("System", 14));
			subnetLabels.get(i).setTextFill(Color.web("#e3e3e3"));
			subnetFields.add(new TextField());
			subnetFields.get(i).setPromptText("enter hosts...");
			subnetFields.get(i).setStyle("-fx-background-color: #282e36; -fx-text-fill: #e3e3e3; -fx-alignment: center;");
			
			if(subnetAmount > 12) {
				System.out.println("Subnets cannot exceed 12. Sorry");
				currentStatus.setText("Subnets cannot exceed 12. Sorry");
				subnetAmount = 0;
			}
			else if(i < 3) {
				grid.add(subnetLabels.get(i), 0, j);
				grid.add(subnetFields.get(i), 0, j+1);
				j += 2;
			}
			else if(i >= 3 && i < 6) {
				grid.add(subnetLabels.get(i), 1, k);
				grid.add(subnetFields.get(i), 1, k+1);
				k += 2;
			}
			else if(i >= 6 && i < 9) {
				grid.add(subnetLabels.get(i), 2, l);
				grid.add(subnetFields.get(i), 2, l+1);
				l += 2;
			}
			else if(i >= 9) {
				grid.add(subnetLabels.get(i), 3, m);
				grid.add(subnetFields.get(i), 3, m+1);
				m += 2;
			}
		}
		
	}
}