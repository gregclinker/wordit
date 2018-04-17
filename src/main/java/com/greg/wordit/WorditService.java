package com.greg.wordit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import org.apache.http.client.fluent.Request;
import org.springframework.stereotype.Service;

/**
 * Underlying service reads static word data once at startup.
 * 
 * @author greg
 *
 */
@Service
public class WorditService {

	private Map<String, List<String>> index = new HashMap<>();

	@PostConstruct
	private void init() throws Exception {
		// get the raw content
		String content = Request.Get("http://static.abscond.org/wordlist.txt").execute().returnContent().asString();

		// split into a list of words
		List<Word> words = Arrays
				.asList(Pattern.compile("\n").splitAsStream(content).map(Word::new).toArray(Word[]::new));

		// add the words to the index by sorted text
		for (Word word : words) {
			if (index.get(word.getSortedText()) == null) {
				index.put(word.getSortedText(), new ArrayList<>());
			}
			index.get(word.getSortedText()).add(word.getText());
		}

	}

	/**
	 * Lookup a match from the index by the alpha numerically sorted string
	 * 
	 * @param text
	 * @return
	 */
	public WordMatch getMatch(String text) {
		String sortedText = new Word(text).getSortedText();
		if (index.get(sortedText) != null) {
			return new WordMatch(text, index.get(sortedText));
		}
		return new WordMatch(text, new ArrayList<>());
	}
}