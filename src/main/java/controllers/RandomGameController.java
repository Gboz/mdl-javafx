package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import custom.NumberTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RandomGameController {

	private MainController mainController;
	
	@FXML
	private NumberTextField numberOne;
	@FXML
	private NumberTextField numberTwo;
	@FXML
	private NumberTextField numberThree;
	@FXML
	private NumberTextField numberFour;
	@FXML
	private NumberTextField numberFive;
	@FXML
	private NumberTextField numberSix;
	
	@FXML
	private Label playerNumberOne;
	@FXML
	private Label playerNumberTwo;
	@FXML
	private Label playerNumberThree;
	@FXML
	private Label playerNumberFour;
	@FXML
	private Label playerNumberFive;
	@FXML
	private Label playerNumberSix;
	
	@FXML
	private Label drawNumberOne;
	@FXML
	private Label drawNumberTwo;
	@FXML
	private Label drawNumberThree;
	@FXML
	private Label drawNumberFour;
	@FXML
	private Label drawNumberFive;
	@FXML
	private Label drawNumberSix;
	
	@FXML
	private Label result;
	
	List<Integer> drawNumbers = new ArrayList<Integer>();
	List<Integer> playerNumbers = new ArrayList<Integer>();
	List<Integer> theSameNumbers = new ArrayList<Integer>();
	
	Random generator = new Random();
	
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
	public void playRandom() {
		try {
			playerNumbers.add(Integer.parseInt(numberOne.getText()));
			playerNumbers.add(Integer.parseInt(numberTwo.getText()));
			playerNumbers.add(Integer.parseInt(numberThree.getText()));
			playerNumbers.add(Integer.parseInt(numberFour.getText()));
			playerNumbers.add(Integer.parseInt(numberFive.getText()));
			playerNumbers.add(Integer.parseInt(numberSix.getText()));
			
			System.out.println(playerNumbers);
			
			playerNumberOne.setText(String.valueOf(playerNumbers.get(0)));
			playerNumberTwo.setText(String.valueOf(playerNumbers.get(1)));
			playerNumberThree.setText(String.valueOf(playerNumbers.get(2)));
			playerNumberFour.setText(String.valueOf(playerNumbers.get(3)));
			playerNumberFive.setText(String.valueOf(playerNumbers.get(4)));
			playerNumberSix.setText(String.valueOf(playerNumbers.get(5)));
			
			drawRandom();
			
			drawNumberOne.setText(String.valueOf(drawNumbers.get(0)));
			drawNumberTwo.setText(String.valueOf(drawNumbers.get(1)));
			drawNumberThree.setText(String.valueOf(drawNumbers.get(2)));
			drawNumberFour.setText(String.valueOf(drawNumbers.get(3)));
			drawNumberFive.setText(String.valueOf(drawNumbers.get(4)));
			drawNumberSix.setText(String.valueOf(drawNumbers.get(5)));
			
			int liczbaTrafien = 0;
			int przebieg = 0;
			
			for(int i = 0; i < playerNumbers.size(); i++) {
				for(int j = 0; j < 6; j++) {
					if(playerNumbers.get(i).equals(drawNumbers.get(j))) {
						liczbaTrafien++;
						
						
						System.out.println(playerNumbers.get(i).equals(drawNumbers.get(j)));
					}
					przebieg++;
				}
			}
			
			
			System.out.println("liczba trafieñ = " + liczbaTrafien);
			System.out.println("przebieg = " + przebieg);
		
			result.setText("Trafi³eœ: " + String.valueOf(liczbaTrafien));
			
			drawNumbers.removeAll(drawNumbers);
			playerNumbers.removeAll(playerNumbers);
		
		}	catch (Exception e) {
			result.setText("wpisz liczby");
		}
	}
	
	public void drawRandom() {
		for(int i = 1; i <= 49; i++) {
			drawNumbers.add(i);
		}
		System.out.println(drawNumbers);
		Collections.shuffle(drawNumbers);
		drawNumbers.remove(drawNumbers.size() - 1);
		drawNumbers.remove(drawNumbers.size() - 1);
		drawNumbers.remove(drawNumbers.size() - 1);
		System.out.println(drawNumbers);
		System.out.println(drawNumbers.size());
	}
	
}
