package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import models.Character;

public class RPGController {
	
	private MainController mainController;
	Character ch1 = new Character(20, 5);
	Character ch2 = new Character(14, 6);
	int x = ch1.getHealthPoints();
	int y = ch2.getHealthPoints();
	
	@FXML
	private Label hpFirstPL;
	
	@FXML
	private Label hpSecondPL;
	
	public MainController getMainController() {
		return mainController;
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	
	@FXML
	public void backButton() {
		mainController.loadMenuScreen();
	}
	
	@FXML
	public void hitFirstPL() {
		int val = ch1.attack(ch2);
		String val2 = "dead";
		if(val <= 0) {
			hpSecondPL.setText(val2);
		} else {
			hpSecondPL.setText(String.valueOf(val));
		}
	}
	
	@FXML
	public void hitSecondPL() {
		int val = ch2.attack(ch1);
		String val2 = "dead";
		if(val <= 0) {
			hpFirstPL.setText(val2);
		} else {
			hpFirstPL.setText(String.valueOf(val));
		}
	}
	
	@FXML
	public void initialize() {
		hpFirstPL.setText(String.valueOf(ch1.getHealthPoints()));
		hpSecondPL.setText(String.valueOf(ch2.getHealthPoints()));
		System.out.println(ch1.equals(ch2));
		System.out.println(ch1.hashCode());
		System.out.println(ch2.hashCode());
		
	}
}
