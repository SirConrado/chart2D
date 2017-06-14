package controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class MainController {
	@FXML
	private StackPane mainStackPane; 
	
	@FXML
	public void initialize(){
		loadMenuScreen();
	}

	public void loadMenuScreen() {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("menuScreen.fxml"));
		GridPane gridPane = null;
		try {
			gridPane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		MenuController menuController = loader.getController();
		menuController.setMainController(this);
		setScreen(gridPane);
	}

	public void setScreen(Pane pane) {
		getMainStackPane().getChildren().clear();
		getMainStackPane().getChildren().add(pane);
	}
	public void hideScreen() {
		getMainStackPane().getChildren().clear();
		getMainStackPane().getScene().getWindow().hide();
	}


	public StackPane getMainStackPane() {
		return mainStackPane;
	}

	public void setMainStackPane(StackPane mainStackPane) {
		this.mainStackPane = mainStackPane;
	}
}
