package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.models.StackCard;
import es.upm.miw.iwvg.klondike.models.StackDeck;
import es.upm.miw.iwvg.klondike.utils.IO;

public class DiscardToDeckController {

	private StackDeck deck;
	private StackCard discard;
	private IO io;

	public DiscardToDeckController(StackCard discard, StackDeck deck) {
		this.discard = discard;
		this.deck = deck;
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