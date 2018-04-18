package com.greg.wordit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorditServiceTest {

	@Autowired
	private WorditService service;

	@Test
	public void match() throws Exception {
		WordMatch wordMatch = service.getMatch("crepitus");
		assertEquals(3, wordMatch.getMatches().size());
		assertTrue(wordMatch.getMatches().contains("cuprites"));
		assertTrue(wordMatch.getMatches().contains("pictures"));
		assertTrue(wordMatch.getMatches().contains("piecrust"));
		wordMatch = service.getMatch("pictures");
		assertEquals(3, wordMatch.getMatches().size());
		assertTrue(wordMatch.getMatches().contains("cuprites"));
		assertTrue(wordMatch.getMatches().contains("crepitus"));
		assertTrue(wordMatch.getMatches().contains("piecrust"));
	}
}
