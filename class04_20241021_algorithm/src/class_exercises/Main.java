package class_exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		List<Integer> orderNumbers = new ArrayList<Integer>();
		int dim = 20;
		Random rand = new Random();
		
		while(dim > 0) {
			orderNumbers.add(rand.nextInt(100));
			dim--;
		}
		
		System.out.println(orderNumbers.toString());
		
		secuentialSearch(orderNumbers, 30);
		
		
	}
	
	static void method2N() {
		int[] randomElements = {30,35,40,45,50};
		
		List<Integer> index = new ArrayList<Integer>();
		index.add(0);
		index.add(1);
		index.add(2);
		index.add(3);
		index.add(4);
		
		int[] sortedElements = {0,0,0,0,0};
		
		Random rand = new Random();
		
		// iteración
		for(int number:randomElements) {
			int i = index.get(rand.nextInt(index.size()));
			System.out.println("indice seleccionado " + i);
			
			sortedElements[i] = number;
			System.out.println(Arrays.toString(sortedElements));
			
			index.remove(i);
			System.out.println(index.toString());
		}
		
		System.out.println(Arrays.toString(sortedElements));
		
	}
	
	static void sortedByAuxVariable() {
		int[] randomElements = {30,35,40,45,50};
		int auxNumber = 0;
		
		Random rand = new Random();
		
		System.out.println(Arrays.toString(randomElements));
		for(int i = 0; i < randomElements.length; i++) {
			int index = -1;
			
			do {
				index = rand.nextInt(randomElements.length);
			} while(index == i);
						
			auxNumber = randomElements[index];
			randomElements[index] = randomElements[i];
			randomElements[i] = auxNumber;
			
			System.out.println(Arrays.toString(randomElements));
		}
	}

	static void secuentialSearch(List<Integer> numbersList, int numberToSearch) {
		
		int dim = numbersList.size() - 1;
		boolean isInList = false;
		
		do {
			// comparar si el número está en la lista
			isInList = numbersList.get(dim) == numberToSearch;
			
			// disminuir la variable dim
			dim--;
			
		} while(!isInList || dim > 0);
	
		System.out.println(isInList);
	}
	
	static void binarySearch() {}
}
