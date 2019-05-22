package application;

import Modelo.Datos;
import Modelo.Persona;
import Vista.VentanaController;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private Stage stagePrincipal;
	private AnchorPane rootPane;
	private VentanaController controller;
	private Datos datos = new Datos();
	

	@Override
	public void start(Stage stagePrincipal) throws Exception {
		this.stagePrincipal = stagePrincipal;
		
		mostrarVentanaPrincipal();
	}
	
	public void mostrarVentanaPrincipal() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vista/Ventana.fxml"));
			rootPane = (AnchorPane) loader.load();
			Scene scene = new Scene(rootPane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			stagePrincipal.setScene(scene);
			
		
			controller = loader.getController();
			controller.setProgramaPrincipal(this);
			controller.creaTabla();
			
			stagePrincipal.show();
		
		} catch (Exception e) {
			e.printStackTrace();
		
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public ObservableList<Persona> getDatos() {
		
		
		
		
		return datos.getData();
	}
}
