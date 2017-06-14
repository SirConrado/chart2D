package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class OptionsController {

	
	private MainController mainController;
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
		optionPane.setOpacity(1);
		mainController.getMainStackPane().setOpacity(1);
		opacity1.setValue(optionPane.getOpacity());
	}
	@FXML
	private Slider opacity1;
	@FXML
	private GridPane optionPane;
	@FXML
	private ColorPicker colorPicker1;
	public void backMenu(){
		mainController.loadMenuScreen();
	}
	@FXML
	public void onMouseEReleasedlider1(){
		optionPane.setOpacity(opacity1.getValue());
		mainController.getMainStackPane().setOpacity(opacity1.getValue());
		System.out.println(opacity1.getValue());
	}
	public void onHiddenColorPicker1(){
		optionPane.setStyle("-fx-background-color:'"+ colorPicker1.getValue() +"';");
		mainController.getMainStackPane().setStyle("-fx-background-color:'"+ colorPicker1.getValue() +"';");
		System.out.println(colorPicker1.getValue());
	}
}
