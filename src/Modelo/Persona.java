package Modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Persona {
	 private StringProperty firstName;
	 private StringProperty email;
	 private StringProperty lastName;
	 public Persona(String fName,String lName,String mail) {
		 this.setFirstName(fName);
		 this.setLastName(lName);
		 this.setEmail(mail);
		 
	 }
     public void setFirstName(String value) { 
    	 firstNameProperty().set(value); 
    	 }
     public String getFirstName() {
    	 return firstNameProperty().get();
    	 }
     public StringProperty firstNameProperty() { 
         if (firstName == null)
        	 firstName = new SimpleStringProperty(this, "firstName");
         return firstName; 
     }
 
     
     public void setLastName(String value) { 
    	 lastNameProperty().set(value); 
    	 }
     public String getLastName() { return lastNameProperty().get(); }
     public StringProperty lastNameProperty() { 
         if (lastName == null) lastName = new SimpleStringProperty(this, "lastName");
         return lastName; 
     } 
     
     public void setEmail(String value) {
    	 emailProperty().set(value); 
    	 }
     
     public String getEmail() { 
    	 return emailProperty().get();
    	 }
     
     public StringProperty emailProperty() { 
         if (email == null) email = new SimpleStringProperty(this, "email");
         return email; 
     } 
}
