package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.models.StackCard;
import es.upm.miw.iwvg.klondike.models.StackDeck;
import es.upm.miw.iwvg.klondike.utils.IO;
import es.upm.miw.iwvg.klondike.views.GameView;

public class DiscardToDeckController {

	private StackDeck deck;
	private StackCard discard;
	private GameView gameView;
	private IO io;

	public DiscardToDeckController(StackCard discard, StackDeck deck, GameView gameView) {
		this.discard = discard;
		this.deck = deck;
		this.gameView = gameView;
		io = new IO();
	}

	public void execute() {
		if (discard.getStackCard().isEmpty()) {
			while (discard.getStackCard().size() != 0) {
				deck.getStackCard().push(discard.getStackCard().pop());
			}
		} else {
			io.writeln("El descarte aún tiene cartas");
		}
	}
}