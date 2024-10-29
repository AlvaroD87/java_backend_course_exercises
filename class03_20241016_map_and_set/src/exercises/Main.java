package exercises;

import java.util.TreeSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Main {

	static Random random = new Random();
	
	public static void main(String[] args) {
		Set<Integer> setRandomIntA = randomTreeSetInt(10);
		Set<Integer> setRandomIntB = randomTreeSetInt(10);
		
		printSet(setRandomIntA, "Set A");
		printSet(setRandomIntB, "Set B");
		
		//Ejercicio 1
		intersectionSet(setRandomIntA, setRandomIntB);
		
		//Ejercicio 2
		differenceSet(setRandomIntA, setRandomIntB);
		
		//Ejercicio 3
		Set<Integer> setRandomIntC = randomTreeSetInt(10,15);
		Set<Integer> setRandomIntD = randomTreeSetInt(2,15);
		printSet(setRandomIntC, "\nSet C");
		printSet(setRandomIntD, "Set D");
		
		subSet(setRandomIntC, setRandomIntD);
		
		//Ejercicio 4
		String phrase = "Esta es la casa que construyó Jack. Esta es la malta que yacía en la casa que construyó Jack. Esta es la rata que se comió la malta que yacía en la casa que construyó Jack.";
		uniqueWord(phrase);
		
		//Ejercicio 5
		countUniqueWord(phrase);
	}
	
	static TreeSet<Integer> randomTreeSetInt(int totalElements) {
		TreeSet<Integer> randomSet = new TreeSet<Integer>();
		while(randomSet.size() < totalElements) {
			randomSet.add(random.nextInt(30));
		}
		return randomSet;
	}
	
	static TreeSet<Integer> randomTreeSetInt(int totalElements, int rangeNumbers) {
		TreeSet<Integer> randomSet = new TreeSet<Integer>();
		while(randomSet.size() < totalElements) {
			randomSet.add(random.nextInt(rangeNumbers));
		}
		return randomSet;
	}
	
	static <E> void printSet(Set<E> setToPrint, String nameOfSet) {
		String strElements = "";
		
		for (E element : setToPrint) {
			if (element instanceof Integer) strElements += String.format("%02d ", element);
			else if (element instanceof String) strElements += String.format("%s ", element);
		}
		
		System.out.println(String.format("%s : %s", nameOfSet, strElements));
	}
	
	
	
	// Ejercicio 1
	static void intersectionSet(Set<Integer> setA, Set<Integer> setB) {
		Set<Integer> auxSet = new TreeSet<Integer>(setA);
		
		auxSet.retainAll(setB);
		
		printSet(auxSet,"\nIntersection");
	}
	
	// Ejercicio 2
	static void differenceSet(Set<Integer> setA, Set<Integer> setB) {
		Set<Integer> auxSet = new TreeSet<Integer>(setA);
		
		auxSet.removeAll(setB);
		
		printSet(auxSet,"\nDifference");
	}
	
	
	// Ejercicio 3
	static void subSet(Set<Integer> setA, Set<Integer> setB) {
		Set<Integer> auxSet = new TreeSet<Integer>(setA);
		
		String response = auxSet.containsAll(setB) ? "is subset" : "isn't subset";
		
		System.out.println(response);
	}
	
	
	// Ejercicio 4
	static void uniqueWord(String phrase) {
		String[] splitPhrase = phrase.toLowerCase().replace(".", "").split(" ");
		
		Set<String> uniqueWord = new TreeSet<String>();
		
		for (String word : splitPhrase) {uniqueWord.add(word);}
		
		printSet(uniqueWord, "\nUnique Words");
	}
	
	// Ejercicio 5
	static void countUniqueWord(String phrase) {
		phrase = phrase.toLowerCase().replace(".", "") + " ";
		String[] splitPhrase = phrase.split(" ");
		
		Set<String> uniqueWord = new TreeSet<String>();
		for (String word : splitPhrase) {uniqueWord.add(word);}
		
		Map<String, Integer> countUniqueWord = new HashMap<String, Integer>();
		for (String word : uniqueWord) {
			int total = phrase.endsWith(word+" ") ? 0 : -1;
			total += phrase.split(word+" ").length;
			
			countUniqueWord.put(word, total);
		}
		
		System.out.println("\nCount Unique Word:");
		countUniqueWord.forEach((word, total) -> {System.out.println(String.format("%s - %d", word, total));});
	}
	
	// Ejercicio 6	
}