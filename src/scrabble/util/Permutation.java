package scrabble.util;

import java.util.Arrays;

public class Permutation {

	String word;
	public Permutation(String word) {
		this.word=word;
	}

	@Override
	public int hashCode() {
		// TBD: implement this method
		return word.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if(obj == null || !obj.getClass().getName().equals(this.getClass().getName())) {
			return false;
		}

 
		// this instance check
		if (this == obj) {
			return true;
		}
 
		// instanceof Check and actual value check
		Permutation p = (Permutation) obj;
		if(p.getNormalized().compareTo(getNormalized()) == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "[" + getNormalized() + "] " + getWord();
	}

	public String getNormalized() {
		char[] normalized = word.toCharArray();
		Arrays.sort(normalized);
		
		return new String(normalized);
	}

	public String getWord() {
		return word;
	}

	public int length() {
		// TBD: implement this method
		return 0;
	}

}
