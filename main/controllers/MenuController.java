package controllers;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MenuController {
	private byte chartID = 1;
	private MainController mainController;
	
	public byte getChartID() {
		return chartID;
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	@FXML
	public void openOption() {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("OptionsScreen.fxml"));
		GridPane pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		OptionsController optionController = loader.getController();
		optionController.setMainController(mainController);
		mainController.setScreen(pane);
	}
	public void openChart(ActionEvent event, int id) throws Exception{
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ChartScreen1.fxml"));  
		//Pane pane = null;
		Parent root = (Parent)fxmlLoader.load();          
		ChartController1 controller = fxmlLoader.<ChartController1>getController();
		controller.setChartID(id);
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Wykresy 3D - przykład " + id );
		stage.show(); 
		//
		((Node)(event.getSource())).getScene().getWindow().hide();
	}
	@FXML
	public void openChart1(ActionEvent event) throws Exception{
		openChart(event, 1);
	}
	@FXML
	public void openChart2(ActionEvent event) throws Exception{
		openChart(event, 2);
	}
	@FXML
	public void openChart3(ActionEvent event) throws Exception{
		openChart(event, 3);
	}
	@FXML
	public void openChart4(ActionEvent event) throws Exception{
		openChart(event, 4);
	}
	@FXML
	public void exit() {
		Platform.exit();
	}

}
