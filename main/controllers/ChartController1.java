package controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ChartController1{
	private MainController mainController;
	private MenuController menuController;
	private Label customerName;
	private ArrayList <String> etykiety;
	private ArrayList <String> nazwySerri;
	private List <Double> wartosciSerii;
	private List<XYChart.Series> xYchartSeries;
	int counter;
	
	@FXML
	private Pane anchorPane;
	@FXML
	private BarChart<String,Number> bc1;
	public Pane getAnchorPane() {
		return anchorPane;
	}
	public void setAnchorPane(AnchorPane anchorPane) {
		this.anchorPane = anchorPane;
	}
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	public void initialize() throws Exception{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Wybór przykładu");
		alert.setHeaderText("Który przyklad chcesz wyświetlić?");
		alert.setContentText("Wybier numer.");

		ButtonType buttonTypeOne = new ButtonType("Pierwszy");
		ButtonType buttonTypeTwo = new ButtonType("Drugi");
		ButtonType buttonTypeThree = new ButtonType("Trzeci");
		ButtonType buttonTypeFour = new ButtonType("Czwarty");
		ButtonType buttonTypeCancel = new ButtonType("Anuluj", ButtonData.CANCEL_CLOSE);

		alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, buttonTypeFour, buttonTypeCancel);

		Optional<ButtonType> result = alert.showAndWait();
		Scanner file = null;
		Scanner fileOpis = null;
		etykiety = new ArrayList();
		nazwySerri = new ArrayList();
		wartosciSerii = new ArrayList();
		
		if (result.get() == buttonTypeOne){
			file = new Scanner(new File("1.csv"));
			fileOpis = new Scanner(new File("1.txt"));
		}
		else if (result.get() == buttonTypeTwo){
			file = new Scanner(new File("2.csv"));
			fileOpis = new Scanner(new File("2.txt"));
		}
		else if (result.get() == buttonTypeTwo){
			file = new Scanner(new File("3.csv"));
			fileOpis = new Scanner(new File("3.txt"));
		}
		else if (result.get() == buttonTypeTwo){
			file = new Scanner(new File("4.csv"));
			fileOpis = new Scanner(new File("4.txt"));
		}
		else if(result.get() == buttonTypeCancel){
			// do dorobienia
		}
		//for(int i = 0 ; i < 3; i++){
			etykiety.add((fileOpis.nextLine()));
		//}
		String line = null;
		counter = 0;
		while(file.hasNext()){
			String linia = file.nextLine();
			System.out.println(linia);
			String liniaT[] = linia.split(",");
			nazwySerri.add(liniaT[0]);
			wartosciSerii.add(Double.parseDouble(liniaT[1]));
			counter++;
		}
		loadChart();
		
	}
	
	public <Int> void loadChart(){
		
				 final CategoryAxis xAxis = new CategoryAxis();
	        final NumberAxis yAxis = new NumberAxis();
	        final BarChart<String,Number> bc = bc1;
	        bc.setTitle(etykiety.get(0));
	        xYchartSeries = new ArrayList<XYChart.Series>();
	        for(int i = 0; i < counter; i++){
	        	XYChart.Series tym = new XYChart.Series();
		        tym.setName(nazwySerri.get(i));
		        tym.getData().add(new XYChart.Data("",  wartosciSerii.get(i)));
		        xYchartSeries.add(tym);  
		        bc.getData().addAll(xYchartSeries.get(i));
	        }   
	       
	        
	}
	@FXML
	public void backMenu(ActionEvent event) throws Exception{
		Parent loader1 =  FXMLLoader.load(getClass().getResource("menuScreen.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(loader1);
		stage.setScene(scene);
		stage.setTitle("Wykresy 3D");
		stage.show(); 
		((Node)(event.getSource())).getScene().getWindow().hide();
		//stage.close();
	}
}
