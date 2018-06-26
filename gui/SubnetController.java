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
import work.BtoD;
import work.ClassId;
import work.Defaults;
import work.NandG;

public class SubnetController {
	
	@FXML private AnchorPane rootPane;
	@FXML TextField ipAddress;
	@FXML TextField addClass;
	@FXML TextField nSubnets;
	@FXML TextField nHosts;
	@FXML TextField defaultMask;
	@FXML TextField uSubnets;
	@FXML TextField uHosts;
	@FXML TextField tSubnets;
	@FXML TextField tHosts;
	@FXML TextField customMask;
	@FXML TextField bitsBorrowed;
	@FXML Label currentStatus;
	
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
	
	//Begins process for calculation
	public void infoSetting(ActionEvent event) {
		
		System.out.println(ipAddress.getText());
		
		//Case of nothing entered.
		if(ipAddress.getText().equals("") && nSubnets.getText().equals("") && nHosts.getText().equals("")) {
			//int ipAddress = 0;
			currentStatus.setText("You must enter valid data into each field.");
			System.out.println("You must enter valid data into each field.");
		}
		
		//Case of no IP Address entered.
		else if(ipAddress.getText().equals("")) {
			int ipAddress = 0;
			currentStatus.setText("IP Address field left blank.");
			System.out.println("IP Address field left blank.");
		}
		
		//Case of IP but no S or H.
		else if(nSubnets.getText().equals("") && nHosts.getText().equals("")) {
			int savedNSubnets = 0;
			int savedNHosts = 0;
			
			//Sending entered IP Address to be converted into integers.
			//ipConversion(ipAddress.getText());
			currentStatus.setText("You must enter valid data into at least two fields. (Missing either Subnets Needed or Hosts Needed)");
			System.out.println("You must enter valid data into at least two fields. (Missing either Subnets Needed or Hosts Needed)");
			calculator(oct, savedNSubnets, savedNHosts);
		}
		
		//Case of all present.
		else if(ipAddress.getText().length() > 0 && nHosts.getText().length() > 0 && nSubnets.getText().length() > 0) {
			int savedNHosts = Integer.parseInt(nHosts.getText());
			int savedNSubnets = Integer.parseInt(nSubnets.getText());
			ipConversion(ipAddress.getText());
			calculator(oct, savedNSubnets, savedNHosts);
			currentStatus.setText("calculating...");
			System.out.println("calculating...");
		}
		
		//Case of S only.
		else if(nSubnets.getText().equals("")) {
			int savedNSubnets = 0;
			int savedNHosts = Integer.parseInt(nHosts.getText());
			ipConversion(ipAddress.getText());
			calculator(oct, savedNSubnets, savedNHosts);
			currentStatus.setText("calculating...");
			System.out.println("calculating...");
		}
		
		//Case of H only.
		else if(nHosts.getText().equals("")) {
			int savedNHosts = 0;
			int savedNSubnets = Integer.parseInt(nSubnets.getText());
			ipConversion(ipAddress.getText());
			calculator(oct, savedNSubnets, savedNHosts);
			currentStatus.setText("calculating...");
			System.out.println("calculating...");
		}
		
		
	}
	
	//Converts IP address entered into individual integers in an array.
	public void ipConversion(String ipBefore) {
		
		//Splits string into parts for processing.
		String[] ipString = ipBefore.split("\\.");
		
		//Assigns each part of the string into a place in the integer array.
		for(int i = 0; i < oct.length; i++) {
			oct[i] = Integer.parseInt(ipString[i]);
		}
	}
	
	public void calculator(int[] ip, int s, int h) {
		//Class ID
		ClassId classIdentification = new ClassId(ip);
		addClass.setText(classIdentification.getClassId());
		
		//Defaults
		Defaults getDefs = new Defaults(classIdentification.getClassId());
		int getDefMask[] = new int[4];
		getDefMask = getDefs.getDefaultMask();	
		defaultMask.setText(Integer.toString(getDefMask[0]) + "." + Integer.toString(getDefMask[1]) + "." + Integer.toString(getDefMask[2]) + "." + Integer.toString(getDefMask[3]));
		
		
		//Needed and Given Subnets and Hosts and Bits Borrowed.
		NandG getNG = new NandG(h, s);
		tHosts.setText(Integer.toString(getNG.getGHosts()));
		tSubnets.setText(Integer.toString(getNG.getGSubnets()));
		uHosts.setText(Integer.toString(getNG.getGHosts()-2));
		uSubnets.setText(Integer.toString(getNG.getGSubnets()));
		bitsBorrowed.setText(Integer.toString(getNG.getBB()));
		
		//Custom Subnet.
		BtoD binToDec = new BtoD(getNG.getBB());
		int total[] = new int[3];
		total = binToDec.getDecimal();
		if(classIdentification.getClassId().equals("A")) {
			customMask.setText(Integer.toString(getDefMask[0]) + "." + Integer.toString(total[2]) + "." + Integer.toString(total[1]) + "." + Integer.toString(total[0]));
		}
		else if(classIdentification.getClassId().equals("B")) {
			customMask.setText(Integer.toString(getDefMask[0]) + "." + Integer.toString(getDefMask[1]) + "." + Integer.toString(total[1]) + "." + Integer.toString(total[0]));
		}
		else if(classIdentification.getClassId().equals("C")) {
			customMask.setText(Integer.toString(getDefMask[0]) + "." + Integer.toString(getDefMask[1]) + "." + Integer.toString(getDefMask[2]) + "." + Integer.toString(total[0]));
		}
		
		
	}
	
}