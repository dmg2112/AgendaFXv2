package Modelo;

import java.util.Random;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Datos {
	
	private ObservableList<Persona> data = FXCollections.observableArrayList();
	private String[] nombres = {"Kurt","Chuck","Glenn","Axl","Ozzy","Ronnie","Michale","Kirk"};
	private String[] apellidos = {"Cobain","Danzig","Graves","Rose","Osbourne","James Dio","Schuldiner","Wahmett"};
	private String[] emailNombre = {"HeavyMetal66@","Ibanez4Life@","GibsonLesPaul@","Wahwah@","Borntoride@","OldSkul@"};
	private String[] emailDominio = {"metal.hammer","mariskal.rock","pellentesque.co.uk"};
	public Datos() {
		genera(5);
		
	}
	

	public void genera(int i) {
		data = FXCollections.observableArrayList();
		for (int j = 0; j < i; j++) {
			String nombre = this.getRnd(nombres);
			System.out.println(nombre);
			String apellido = this.getRnd(apellidos);
			String email = this.getRnd(emailNombre)+this.getRnd(emailDominio);
			data.add(new Persona(nombre,apellido,email));
			System.out.println(j);
	
			
		}
		System.out.println(data.size());
		
		
		
		
	}
	

	private String getRnd(String[] arr) {
		Random r=new Random();
        int rnd=r.nextInt(arr.length);
        
        
		return arr[rnd];
	}


	public ObservableList<Persona> getData() {
		return data;
	}
	

}
