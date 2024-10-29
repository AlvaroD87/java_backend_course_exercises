package classexercises.model;

public class Calculator {

	/*
	 * Constructor vacío
	 * Método sumar (recibe 2 decimales y retorna la suma de ambos)
	 * Método restar (recibe 2 decimales y retorna la resta de ambos)
	 * Método multiplicar (recibe 2 decimales y retorna la multiplicación de ambos)
	 * Método dividir (recibe 2 decimales y retorna la división de ambos)
	 * Método potencia (recibe 2 decimales y retorna el primer elemento elevado al segundo)
	 * 
	 * */
	
	public Calculator() {}
	
	static double add(double n1, double n2) { return n1 + n2;}
	static double substract(double n1, double n2) { return n1 - n2;}
	static double multiplicate(double n1, double n2) { return n1 * n2;}
	static double divide(double n1, double n2) { return n1 / n2;}
	static double power(double n1, double n2) { return Math.pow(n1, n2);}
}
