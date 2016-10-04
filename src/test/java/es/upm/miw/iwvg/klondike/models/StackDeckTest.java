package es.upm.miw.iwvg.klondike.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StackDeckTest {
	private StackDeck stackDeck;

	@Before
	public void init() {
		stackDeck = new StackDeck();
	}

	@Test
	public void testConstructor() {
		assertEquals(52, stackDeck.getStackCard().size());
	}
}