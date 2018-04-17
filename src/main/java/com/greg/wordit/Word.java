package com.greg.wordit;

import java.util.Arrays;

public class Word {

	private String text;
	private String sortedText;

	public Word(String text) {
		this.text = text;
		char[] charArray = text.toCharArray();
		Arrays.sort(charArray);
		sortedText = new String(charArray);
	}

	public String getText() {
		return text;
	}

	public String getSortedText() {
		return sortedText;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sortedText == null) ? 0 : sortedText.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
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
		Word other = (Word) obj;
		if (sortedText == null) {
			if (other.sortedText != null)
				return false;
		} else if (!sortedText.equals(other.sortedText))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Word [hashIndex=" + "text=" + text + ", sortedText=" + sortedText + "]";
	}
}
