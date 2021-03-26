package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class WordEnhanced {
	
	private String alienWord;
	private List<String> translations;
	
	
	public WordEnhanced(String alienWord) {
		this.translations = new ArrayList<String>();
		this.alienWord = alienWord;
	}

	public WordEnhanced(String alienWord, String translation) {
		this.translations = new ArrayList<String>();
		this.alienWord = alienWord;
		this.translations.add(translation);
	}

	public boolean compareWild(String alienWild) {
		if (alienWord.matches(alienWild))
			return true;
		return false;
	}

	public String getTranslation() {
		String s = "";
		for (String a : translations) {
			s += a + "\n";
		}
		return s;
	}

	public void setTranslation(String translation) {
		if (!translations.contains(translation)) {
			translations.add(translation);
		}
	}

	public String getAlien() {
		return alienWord;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordEnhanced other = (WordEnhanced) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}
	
	

}
