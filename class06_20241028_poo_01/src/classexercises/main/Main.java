package classexercises.main;

import java.util.Scanner;

import classexercises.model.Person;

public class Main {
	 
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		Person person = new Person();
		
		System.out.println("Registro de nueva persona");
		
		System.out.println("Ingrese el Rut (11.222.333-k):");
		person.setRut(input.nextLine());
		//person.setRut("11.111.111-1");
		
		System.out.println("Ingrese el Nombre:");
		person.setName(input.nextLine());
		
		System.out.println("Ingrese el Apellido:");
		person.setSurname(input.nextLine());
		
		System.out.println("Ingrese el Email:");
		person.setEmail(input.nextLine());
		
		System.out.println("Ingrese el Dirección:");
		person.setAddress(input.nextLine());
		
		System.out.println("\nPerfil de la persona registrada:");
		System.out.println(person.personProfile());
	}
	
}
