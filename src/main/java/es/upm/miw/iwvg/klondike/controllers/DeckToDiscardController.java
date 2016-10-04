package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.models.Card;
import es.upm.miw.iwvg.klondike.models.StackCard;
import es.upm.miw.iwvg.klondike.models.StackDeck;
import es.upm.miw.iwvg.klondike.utils.IO;
import es.upm.miw.iwvg.klondike.views.GameView;

public class DeckToDiscardController {

	private StackDeck deck;
	private StackCard discard;
	private GameView gameView;
	private IO io;

	public DeckToDiscardController(StackCard discard, StackDeck deck, GameView gameView) {
		this.discard = discard;
		this.deck = deck;
		this.gameView = gameView;
		io = new IO();
	}

	public void execute() {
		if (deck.getStackCard().isEmpty()) {
			io.writeln("La baraja está vacía");
		} else {
			Card card = deck.getStackCard().pop();
			card.setHidden(false);
			discard.getStackCard().push(card);
		}
	}
}
