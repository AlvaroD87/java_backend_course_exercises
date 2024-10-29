package bloque01;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Exercise 1
	static double rectanglePerimeter(double sideA, double sideB) {
		return 2.0 * (sideA + sideB);
	}
	
	static double rectangleArea(double sideA, double sideB) {
		return sideA * sideB;
	}
	
	// Exercise 2
	static double circlePerimeter(double radius) {
		return 2.0 * Math.PI * radius;
	}
	
	static double circleArea(double radius) {
		return Math.PI * radius * radius;
	}
	
	// Exercise 3
	static double cylinderArea(double radius, double height) {
		double basalAreas = 2 * circleArea(radius);
		double sideArea = rectangleArea(height, circlePerimeter(radius));
		
		return basalAreas + sideArea;
	}
	
	static double cylinderVolume(double radius, double height) {
		return height * circleArea(radius);
	}
	
	// Exercise 4
	static double arithmeticAverage(double n1, double n2, double n3) {
		return (n1 + n2 + n3) / 3.0;
	}
	
	static double harmonicAverage(double n1, double n2, double n3) {
		return 3.0 / (1/n1 + 1/n2 + 1/n3);
	}
	
	// Exercise 5
	static double meterToMile(double distance) {
		return distance * 62.0E-5;
	}
	
	
}
