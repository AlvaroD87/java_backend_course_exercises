package classexercises.model;

public class Person {
	
	private String rut;
	private String name;
	private String surname;
	private String email;
	private String address;
	
	public Person() {}
	
	public Person(String rut, String name, String surname, String email, String address) {
		this.rut = rut;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.address = address;
	}
	
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String personProfile() {
		return " - Nombre: " + name + "\n" + " - Apellido: " + surname + "\n" + " - Rut: " + rut + "\n" + " - Email: " + email + "\n" + " - Dirección: " + address;
	}

	@Override
	public String toString() {
		return "Person [rut=" + rut + ", name=" + name + ", surname=" + surname + ", email=" + email + ", address="
				+ address + "]";
	}
	
	
}
