package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {

	private List<WordEnhanced> dictionary;

	public AlienDictionary() {
		dictionary = new ArrayList<WordEnhanced>();
	}
	
	public void resetDictionary(){
		dictionary.clear();
	}
	
	public void addWord(String alien, String trans) {
		WordEnhanced w = new WordEnhanced(alien);
		if (dictionary.contains(w)) {
			dictionary.get(dictionary.indexOf(w)).setTranslation(trans);
			return;
		}
		w.setTranslation(trans);
		dictionary.add(w);
	}

	public String translateWord(String alien) {
		WordEnhanced we = new WordEnhanced(alien);
		if (dictionary.contains(we))
			return dictionary.get(dictionary.indexOf(we)).getTranslation();
		return null;
	}

	public String translateWordWildCard(String alienWildCard) {

		// Utilizzo le regual expression di Java (posso usare stringa.matches())
		// Sostituisco "?" con "."
		// "." nelle regex indica un qualsiasi carattere
		alienWildCard = alienWildCard.replaceAll("\\?", ".");

		int matchCounter = 0;
		StringBuilder sb = new StringBuilder();

		for (WordEnhanced w : dictionary) {
			if (w.compareWild(alienWildCard)) {
				matchCounter++;
				sb.append(w.getTranslation() + "\n");
			}
		}
		
		if (matchCounter != 0)
			return sb.toString();
		else
			return null;
	}	
	
	
}
