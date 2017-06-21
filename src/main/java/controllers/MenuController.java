package controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class MenuController {
	
	private MainController mainController;
	
	@FXML
	public void openApp() {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/AppScreen.fxml"));
		Pane pane = null;
		try {
			pane = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		AppController appController = loader.getController();
		appController.setMainController(mainController);
		mainController.setScreen(pane);
	}
	
	@FXML
	public void openRPGModule() {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/RPGScreen.fxml"));
		Pane pane = null;
		try {
			pane = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		RPGController rpgController = loader.getController();
		rpgController.setMainController(mainController);
		mainController.setScreen(pane);
	}
	
	@FXML
	public void openRandomGameModule() {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/RandomGameScreen.fxml"));
		Pane pane = null;
		try {
			pane = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		RandomGameController randomGameController = loader.getController();
		randomGameController.setMainController(mainController);
		mainController.setScreen(pane);
		
	}
	
	@FXML
	public void exitApp() {
		Platform.exit();
	}

	public MainController getMainController() {
		return mainController;
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	
	
}
