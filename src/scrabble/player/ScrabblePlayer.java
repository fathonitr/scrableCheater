package scrabble.player;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

import scrabble.data.HashWordList;
import scrabble.data.SimpleWordList;
import scrabble.data.WordList;

public class ScrabblePlayer {

	public static void main(String[] args) {
		long start1 = System.nanoTime();
		WordList wl = new HashWordList()
				.initFromFile("wordlists/sowpods.txt");
		long end1 = System.nanoTime();
		System.out.println("HashMap loadtime:" + (end1 - start1)/1000000 + "ms");
		
		long start2 = System.nanoTime();
		WordList wl2 = new SimpleWordList()
				.initFromFile("wordlists/sowpods.txt");
		long end2 = System.nanoTime();
		System.out.println("HashMap loadtime:" + (end2 - start2)/1000000 + "ms");
		
		try (Scanner sc = new Scanner(System.in)) {
			
			System.out.println("Enter word are you looking for:");
			String word = sc.nextLine();
			System.out.println("is that a complete word: (y/n)");
			String method = sc.nextLine();
			
			

			switch(method) {
			case "n":
				{
					long starta1 = System.nanoTime();
					System.out.println("HashMap: " + wl.allValidWords(word));
					long enda1 = System.nanoTime();
					System.out.println("Press enter to continue");
					sc.nextLine();
					
					long starta2 = System.nanoTime();
					System.out.println("Set: " + wl2.allValidWords(word));
					long enda2 = System.nanoTime();
					System.out.println("Press enter to continue");
					sc.nextLine();
					
					System.out.println("HashMap loadtime:" + (enda1 - starta1)/1000000 + "ms");
					System.out.println("Set loadtime:" + (enda2 - starta2)/1000000 + "ms");
					
				}
				break;
			 
			case "y":
				{
					long starta1 = System.nanoTime();
					System.out.println("HashMap: " + wl.validWordsUsingAllTiles(word));
					long enda1 = System.nanoTime();
					System.out.println("Press enter to continue");
					sc.nextLine();
					
					long starta2 = System.nanoTime();
					System.out.println("Set: " + wl2.validWordsUsingAllTiles(word));
					long enda2 = System.nanoTime();
					System.out.println("Press enter to continue");
					sc.nextLine();
					
					System.out.println("HashMap loadtime:" + (enda1 - starta1)/1000000 + "ms");
					System.out.println("Set loadtime:" + (enda2 - starta2)/1000000 + "ms");
					
				}
				break;
			}
		}
	    
	   	    
	}

}
