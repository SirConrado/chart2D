package controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class GenerateChartController extends MenuController {
	private MainController mainController;
	private MenuController menuController;
	private Label customerName;
	private ArrayList <String> etykiety;
	private ArrayList <String> nazwySerri;
	private List <Double> wartosciSerii;
	private List<XYChart.Series> xYchartSeries;
	int counter;
	BarChart<String,Number> bc;
	@FXML
	TextField title;
	@FXML
	private BarChart<String,Number> bc1;
	@FXML
	void onKeyReleasedTitle(){
		bc.setTitle(title.getText());
	}
	@FXML
	private Pane anchorPane;
	
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
		
		etykiety = new ArrayList();
		nazwySerri = new ArrayList();
		wartosciSerii = new ArrayList();
		
	
		etykiety.add(title.getText());
		String line = null;
		counter = 0;
		FileChooser fileChooser = new FileChooser();
		selectedFile = fileChooser.showOpenDialog(null);
		//System.out.println(selectedFile.getName());
		Scanner fileWithChart = new Scanner(new File(selectedFile.getName()));
		//etykiety.add(selectedFile.getName());
		while(fileWithChart.hasNext()){
			String linia = fileWithChart.nextLine();
			//System.out.println(linia);
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
	        bc = bc1;
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
