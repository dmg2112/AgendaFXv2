package Vista;

import java.net.URL;
import java.util.ResourceBundle;

import Modelo.Persona;
import application.Main;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class VentanaController {
	@FXML
	private TableView<Persona> table;
	@FXML
	private Button btnNuevo;
	@FXML
	private TextField name;
	@FXML
	private TextField lastName;
	@FXML
	private TextField mail;
	@FXML
	private Button btnBorrar;
	@FXML
	private TableColumn<Persona, String> fName;

	@FXML
	private TableColumn<Persona, String> lName;

	@FXML
	private TableColumn<Persona, String> email;

	private ObservableList<Persona> Contactos;
	private Main ProgramaPrincipal;

	public void setProgramaPrincipal(Main ProgramaPrincipal) {
		this.ProgramaPrincipal = ProgramaPrincipal;
	}

	@SuppressWarnings("rawtypes")
	public void initialize(URL url, ResourceBundle rb) {
		

	}
	public void creaTabla(){
		Contactos =ProgramaPrincipal.getDatos();
		for (Persona persona : Contactos) {
			System.out.println(persona.getEmail());
			
		}
		
		table.setItems(Contactos);
		table.getSortOrder().add(fName);
		
		fName.setCellValueFactory(new PropertyValueFactory("firstName"));
		lName.setCellValueFactory(new PropertyValueFactory("lastName"));
		email.setCellValueFactory(new PropertyValueFactory("email"));
		
	}

	@FXML
	public void nueva() {
		System.out.println(lastName.getText());
		if(lastName.getText().isEmpty() || name.getText().isEmpty() || mail.getText().isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("There was an error");
			alert.setContentText("Fields cant be empty");

			alert.showAndWait();
			
		}
		
		Persona item = new Persona(name.getText(),lastName.getText(),mail.getText());
		añade(item);
		
	}


		

	
	public void elimina() {
		Boolean seleccionado = table.getItems().isEmpty();
		if (!seleccionado) {
			Persona item = table.getSelectionModel().getSelectedItem();

			this.quita(item);
			this.actualiza();
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("There was no selection");
			alert.setContentText("There must be a contact selected");

			alert.showAndWait();
		}
	}

	public void nuevoContacto(Persona item) {
		this.añade(item);
		this.actualiza();

	}

	public void añade(Persona contacto) {
		Contactos.add(contacto);

	}

	private void quita(Persona item) {
		Contactos.remove(item);
	}

	private void actualiza() {
		table.setItems(Contactos);
	}

	

	
}
