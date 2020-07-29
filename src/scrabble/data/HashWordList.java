package scrabble.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

import scrabble.util.Permutation;

public class HashWordList implements WordList {

	private HashMap<String, Set<String>> wordCollection = new HashMap<>();

	@Override
	public Set<String> validWordsUsingAllTiles(String tileRackPart) {
		return wordCollection.get(new Permutation(tileRackPart).getNormalized());
	}

	@Override
	public Set<String> allValidWords(String tileRack) {
		
		Set<String> result = new HashSet<>();
		
		for(String key : wordCollection.keySet()) {
			if(new Permutation(key).getNormalized().contains(new Permutation(tileRack).getNormalized())) {
				result.addAll(wordCollection.get(key));
			}
		}
		return result;
	}

	@Override
	public boolean add(String word) {
		Permutation p = new Permutation(word);
		
		if(wordCollection.containsKey(p.getNormalized())){
			wordCollection.get(p.getNormalized()).add(word);
		} else {
			Set<String> words = new HashSet<>();
			words.add(word);
			wordCollection.put(p.getNormalized(), words);
		}

		return true;
	}

	@Override
	public boolean addAll(Collection<String> words) {
		// TODO Auto-generated method stub
		for(String word: words) {
			this.add(word);
		}
		return true;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		for(int i = 0; i<5; i++) {
			System.out.println(wordCollection.keySet().toArray()[i]);
		}
		return wordCollection.size();
	}

	@Override
	public WordList initFromFile(String fileName) {
		WordList wl = new HashWordList();

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
