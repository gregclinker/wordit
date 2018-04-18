package com.greg.wordit;

import java.util.ArrayList;
import java.util.List;

public class WordMatch {

	private String text;
	private List<String> matches;

	public WordMatch(String text, List<String> matches) {
		this.text = text;
		this.matches = new ArrayList<String>(matches);
		this.matches.remove(text);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<String> getMatches() {
		return matches;
	}

	public void setMatches(List<String> matches) {
		this.matches = matches;
	}

	@Override
	public String toString() {
		return "WordMatch [text=" + text + ", matches=" + matches + "]";
	}

}
