package es.upm.miw.iwvg.klondike.models;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CardTest {
	private Card card1;
	private Card card2;

	@Before
	public void initialize() {
		card1 = new Card(Number.ACE, Suit.BRILLO, false);
		card2 = new Card(Number.EIGHT, Suit.CORAZON, false);
	}

	@Test
	public void getSuitTest() {
		assertEquals(Suit.BRILLO, card1.getSuit());
		assertEquals(Suit.CORAZON, card2.getSuit());
	}

	@Test
	public void getNumberTest() {
		assertEquals(Number.ACE, card1.getNumber());
		assertEquals(Number.EIGHT, card2.getNumber());
	}

	@Test
	public void isHiddenTest() {
		assertEquals(false, card1.isHidden());
	}

}
