package exercises;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

	static Random random = new Random();
	static Scanner scannerIn = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Ingrese la dimensión del arreglo a crear");
		int dimention = Integer.parseInt(scannerIn.nextLine());
		
		ArrayList<Integer> randomArray = randomArrayInt(dimention);
		
		System.out.println("ejercicio 1");
		printArray(randomArray);
		
		System.out.println("\nejercicio 2");
		// System.out.println(Math.round((100.0 * meanArray(randomArray)) / 100.0));
		System.out.println(meanArray(randomArray));
		
		System.out.println("\nejercicio 3");
		System.out.println(maxNumber(randomArray));
		
		System.out.println("\nejercicio 4");
		System.out.println(minNumber(randomArray));
		
		System.out.println("\nejercicio 5");
		System.out.println(rangeArray(randomArray));
	}
	
	// Ejercicio 1
	static ArrayList<Integer> randomArrayInt(int dimention) {
		ArrayList<Integer> randomArray = new ArrayList<Integer>();
		while(dimention > 0) {
			randomArray.add(random.nextInt());
			dimention--;
		}
		return randomArray;
	}
	
	static ArrayList<Integer> randomArrayInt() {
		int dimention = random.nextInt();
		return randomArrayInt(dimention);
	}
	
	static void printArray(ArrayList<Integer> arrayToPrint) {
		for (int number : arrayToPrint) {
			System.out.println(String.format("%d", number));
		}
	}
	
	// Ejercicio 2
	static double meanArray(ArrayList<Integer> arrayRandom) {
		int sum = 0;
		
		for (int number:arrayRandom) {
			sum += number;
		}
		
		return sum / arrayRandom.size();
	}
	
	// Ejercicio 3
	static int maxNumber(ArrayList<Integer> arrayRandom) {
		int maxNumber = Integer.MIN_VALUE;
		
		for (int number:arrayRandom) {
			maxNumber = maxNumber < number ? number : maxNumber;
		}
		
		return maxNumber;
	}
	
	// Ejercicio 4
	static int minNumber(ArrayList<Integer> arrayRandom) {
		int minNumber = Integer.MAX_VALUE;
		
		for (int number:arrayRandom) {
			minNumber = minNumber > number ? number : minNumber;
		}
		
		return minNumber;
	}
	
	// Ejercicio 5
	static double rangeArray(ArrayList<Integer> arrayRandom) {
		int max = maxNumber(arrayRandom);
		int min = minNumber(arrayRandom);
		
		System.out.println(max);
		System.out.println(min);
		
		return (double)(max - min);
		
	}

}