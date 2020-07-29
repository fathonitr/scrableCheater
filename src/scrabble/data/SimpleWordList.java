package scrabble.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

import scrabble.util.Permutation;

public class SimpleWordList implements WordList {

	private ArrayList<String> wordCollection = new ArrayList<>();

	@Override
	public Set<String> validWordsUsingAllTiles(String tileRackPart) {

		Set<String> result = new HashSet<>();
		Permutation tiles = new Permutation(tileRackPart);
		for(String word: wordCollection) {
			if(new Permutation(word).equals(tiles)) {
				result.add(word);
			}
		}
		
		return result;
	}

	@Override
	public Set<String> allValidWords(String tileRack) {
		Set<String> result = new HashSet<>();
		for(String word : wordCollection) {
			if(new Permutation(word).getNormalized().contains(new Permutation(tileRack).getNormalized())) {
				result.add(word);
			}
		}
		
		return result;
	}

	@Override
	public boolean add(String word) {
		int colSize = wordCollection.size();
		wordCollection.add(word);
		if(colSize == wordCollection.size())
			return false;
		return true;
	}

	@Override
	public boolean addAll(Collection<String> words) {
		// TODO Auto-generated method stub
		return wordCollection.addAll(words);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return wordCollection.size();
	}

	@Override
	public WordList initFromFile(String fileName) {
		WordList wl = new SimpleWordList();

		try {
			File myObj = new File(fileName);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				wl.add(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return wl;
		// TODO Auto-generated method stub
	}

}
