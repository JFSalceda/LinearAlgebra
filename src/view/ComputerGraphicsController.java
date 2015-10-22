package linearalgebra.view;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
	import javafx.scene.control.CheckBox;
	import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import linearalgebra.LinearAlgebra;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
	
	
	
public class ComputerGraphicsController {
	private LinearAlgebra linearAlgebra;
	
	@FXML private Button point;
	@FXML private Button circle;
	@FXML private Button elipse;
	@FXML private Button vector;
	@FXML private Button polygon;
	@FXML private Button hyperbola;
	@FXML private Button lineSegment;
	
	public ComputerGraphicsController(){
		
	}
	
	public void initialize(){
	//	point.
	}
	/*
	public void handleToggleBox(){
		textField1.setVisible(false);
		textField2.setVisible(true);
	}
	
	public void handleToggleBox2(){
		textField1.setVisible(true);
		textField2.setVisible(false);
	}
	*/
	public void handlePointBox(ActionEvent e)throws IOException{
		System.out.println("you have clicked on point box. " );
		/*loadNewStage("Enter points",
    			"PointsView.fxml", false);
		*/
		//Parent root = FXMLLoader.load(getClass().getResource("PointsView.fxml"));
		
		FXMLLoader loader = new FXMLLoader(getClass()
				.getResource("PointsView.fxml"));
		Parent root = loader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.setTitle("Points");
		stage.show();
	}
	public void handleCircleBox(ActionEvent e)throws IOException{
		System.out.println("you have clicked on Circle box. " );
		/*loadNewStage("Enter points",
    			"PointsView.fxml", false);
		*/
		//Parent root = FXMLLoader.load(getClass().getResource("PointsView.fxml"));
		
		FXMLLoader loader = new FXMLLoader(getClass()
				.getResource("PointsView.fxml"));
		Parent root = loader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.setTitle("Circle");
		stage.show();
	}
	public void handleElipseBox(ActionEvent e)throws IOException{
		System.out.println("you have clicked on Elipse box. " );
		/*loadNewStage("Enter points",
    			"PointsView.fxml", false);
		*/
		//Parent root = FXMLLoader.load(getClass().getResource("PointsView.fxml"));
		
		FXMLLoader loader = new FXMLLoader(getClass()
				.getResource("EllipseView.fxml"));
		Parent root = loader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.setTitle("Ellipse");
		stage.show();
	}
	
	public void handleVectorBox(ActionEvent e)throws IOException{
		System.out.println("you have clicked on Vector box. " );
		/*loadNewStage("Enter points",
    			"PointsView.fxml", false);
		*/
		//Parent root = FXMLLoader.load(getClass().getResource("PointsView.fxml"));
		
		FXMLLoader loader = new FXMLLoader(getClass()
				.getResource("VectorView.fxml"));
		Parent root = loader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.setTitle("Vector");
		stage.show();
	}
	public void handlePolygonBox(ActionEvent e)throws IOException{
		System.out.println("you have clicked on Polygon box. " );
		/*loadNewStage("Enter points",
    			"PointsView.fxml", false);
		*/
		//Parent root = FXMLLoader.load(getClass().getResource("PointsView.fxml"));
		
		FXMLLoader loader = new FXMLLoader(getClass()
				.getResource("PolygonView.fxml"));
		Parent root = loader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.setTitle("Polygon");
		stage.show();
	}	
	public void handleHyperbolaBox(ActionEvent e)throws IOException{
		System.out.println("you have clicked on Hyperbola box. " );
		/*loadNewStage("Enter points",
    			"PointsView.fxml", false);
		*/
		//Parent root = FXMLLoader.load(getClass().getResource("PointsView.fxml"));
		
		FXMLLoader loader = new FXMLLoader(getClass()
				.getResource("HyperbolaView.fxml"));
		Parent root = loader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.setTitle("Hyperbola");
		stage.show();
	}	
	public void handleLineSegmentBox()throws IOException{
		System.out.println("you have clicked on Line Segment box. " );
		/*loadNewStage("Enter points",
    			"PointsView.fxml", false);
		*/
		//Parent root = FXMLLoader.load(getClass().getResource("PointsView.fxml"));
		
		FXMLLoader loader = new FXMLLoader(getClass()
				.getResource("LineSegmentView.fxml"));
		Parent root = loader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.setTitle("LineSegment");
		stage.show();
	}	
	
	public void setLinearAlgebra(LinearAlgebra linearAlgebra){
		this.linearAlgebra=linearAlgebra;
		
	}
	}


