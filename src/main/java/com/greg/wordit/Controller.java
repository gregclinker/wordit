package com.greg.wordit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Wraps the basic service
 * 
 * @author greg
 *
 */
@RestController
public class Controller {

	@Autowired
	private WorditService service;

	/**
	 * Splits words and creates a list of matches
	 * 
	 * @param words
	 * @return
	 */
	@RequestMapping("/{words}")
	public List<WordMatch> match(@PathVariable("words") String words) {
		List<WordMatch> matches = new ArrayList<>();
		for (String text : words.split(",")) {
			matches.add(service.getMatch(text));
		}
		return matches;
	}
}
