package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {

	private List<Word> dictionary;

	public AlienDictionary() {
		dictionary = new ArrayList<Word>();
	}
	
	public void resetDictionary(){
		dictionary.clear();
	}
	
	public void addWord(String alien, String trans) {
		Word w = new Word(alien, trans);
		if (dictionary.contains(w)) {
			dictionary.get(dictionary.indexOf(w)).setTranslation(trans);
			return;
		}
		dictionary.add(w);
	}
	
	public String translateWord(String alien) {
		Word w = new Word(alien);
		if (dictionary.contains(w)) {
			return dictionary.get(dictionary.indexOf(w)).getTranslation();
		}
		return null;
	}
	
	
	
	
}
