package class_exercises;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	static Random random = new Random();
	
	public static void main(String[] args) {
		int totalElements = 10;
		
		ArrayList<Integer> arrayRandomInt = randomIntList(totalElements);
		System.out.println(arrayRandomInt.toString());
		ArrayList<Integer> imperativeOrderedArray = quickSortImperative(arrayRandomInt);
		System.out.println(imperativeOrderedArray.toString());
		
		System.out.println("\n");
		
		ArrayList<Integer> arrayRandomInt2 = randomIntList(totalElements);
		System.out.println(arrayRandomInt2.toString());
		ArrayList<Integer> declarativeOrderedArray = quickSortDeclarative(arrayRandomInt2);
		System.out.println(declarativeOrderedArray.toString());
		
		System.out.println("\n");
		
		ArrayList<Integer> arrayRandomInt3 = randomIntList(totalElements);
		System.out.println(arrayRandomInt3.toString());
		ArrayList<Integer> declarativeOrderedArray2 = quickSortDeclarative2(arrayRandomInt3);
		System.out.println(declarativeOrderedArray2.toString());
	}
	
	// método para crear arreglo random
	static ArrayList<Integer> randomIntList(int totalElements) {
		
		Set<Integer> randomSet = new HashSet<Integer>();
		
		while(randomSet.size() < totalElements) {
			randomSet.add(random.nextInt(300));
		}
		
		ArrayList<Integer> orderedList = new ArrayList<Integer>();
		for(int number : randomSet) {
			orderedList.add(number);
		}
		
		return orderedList;
	}
	
	
	static ArrayList<Integer> quickSortImperative(ArrayList<Integer> randomArrayInt) {
		
		// sacamos del arreglo el número pivote al azar
		int numberPivot = randomArrayInt.get(random.nextInt(randomArrayInt.size() - 1));
		
		// arreglos para almacenar numeros menores y mayores al pivot
		ArrayList<Integer> leftArray = new ArrayList<Integer>();
		ArrayList<Integer> rightArray = new ArrayList<Integer>();
		
		// iteramos sobre los números del arreglo y lo añadimos a left/right Array según sea mayor o menor al pivote 
		for(int number:randomArrayInt) {
			if(number < numberPivot) leftArray.add(number);
			else if(number > numberPivot) rightArray.add(number);
		}
		
		// creamos y formamos el arreglo ordenado
		ArrayList<Integer> orderedList = new ArrayList<Integer>();
		
		orderedList.addAll(leftArray.size() > 1 ? quickSortImperative(leftArray) : leftArray);
		orderedList.add(numberPivot);
		orderedList.addAll(rightArray.size() > 1 ? quickSortImperative(rightArray) : rightArray);
		
		return orderedList;
	}

	static ArrayList<Integer> quickSortDeclarative(ArrayList<Integer> randomArrayInt) {
		
		int numberPivot = randomArrayInt.get(random.nextInt(randomArrayInt.size() - 1));
		
		return randomArrayInt.stream().collect(Collectors.teeing(
					Collectors.filtering(number -> number < numberPivot, Collectors.toList()), 
					Collectors.filtering(number -> number > numberPivot, Collectors.toList()), 
					(cLeft, cRight) -> {
						ArrayList<Integer> orderedList = new ArrayList<Integer>();
						
						orderedList.addAll(cLeft.size() > 1 ? quickSortDeclarative((ArrayList<Integer>) cLeft) : cLeft);
						orderedList.add(numberPivot);
						orderedList.addAll(cRight.size() > 1 ? quickSortDeclarative((ArrayList<Integer>) cRight) : cRight);
						
						return orderedList;
					}
				));
	}
	
	static ArrayList<Integer> quickSortDeclarative2(ArrayList<Integer> randomArrayInt) {
		
		int numberPivot = randomArrayInt.get(random.nextInt(randomArrayInt.size() - 1));
		
		return randomArrayInt.stream().collect(Collectors.teeing(
					Collectors.filtering(number -> number < numberPivot, Collectors.toList()), 
					Collectors.filtering(number -> number > numberPivot, Collectors.toList()), 
					(cLeft, cRight) -> Stream.concat(
							Stream.concat(
									cLeft.size() > 1 ? quickSortDeclarative2((ArrayList<Integer>) cLeft).stream() : cLeft.stream(), 
									Stream.of(numberPivot)), 
							cRight.size() > 1 ? quickSortDeclarative2((ArrayList<Integer>) cRight).stream() : cRight.stream())
							.collect(Collectors.toCollection(ArrayList::new))
				));
	}

}

