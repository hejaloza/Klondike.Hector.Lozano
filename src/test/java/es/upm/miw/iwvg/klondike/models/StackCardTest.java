package es.upm.miw.iwvg.klondike.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StackCardTest {
	private StackCard stackCard;

	@Before
	public void init() {
		stackCard = new StackCard();
	}

	@Test
	public void testToStringEmpty() {
		assertTrue(stackCard.toString().equals(""));
	}

	@Test
	public void testToStringNotEmpty() {
		Card card = new Card(Number.ACE, Suit.BRILLO, false);
		stackCard.getStackCard().push(card);
		assertTrue(stackCard.toString().equals("[ACE BRILLO]"));
	}

}