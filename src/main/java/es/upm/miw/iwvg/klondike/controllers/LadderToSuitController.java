package es.upm.miw.iwvg.klondike.controllers;

import java.util.ArrayList;
import java.util.Hashtable;

import es.upm.miw.iwvg.klondike.models.Card;
import es.upm.miw.iwvg.klondike.models.StackCard;
import es.upm.miw.iwvg.klondike.models.StackLadder;
import es.upm.miw.iwvg.klondike.models.Suit;
import es.upm.miw.iwvg.klondike.utils.IO;
import es.upm.miw.iwvg.klondike.views.GameView;

public class LadderToSuitController {

	private ArrayList<StackLadder> ladders;
	private Hashtable<Suit, StackCard> suitStacks;
	private GameView gameView;
	private IO io;

	public LadderToSuitController(ArrayList<StackLadder> ladders, Hashtable<Suit, StackCard> suitStacks,
			GameView gameView) {
		this.ladders = ladders;
		this.suitStacks = suitStacks;
		this.gameView = gameView;
		io = new IO();
	}

	public void execute() {
		int fromLadder = io.readInt("De que Escalera? [1-7]:");
		StackLadder ladder = ladders.get(fromLadder - 1);
		Card card = ladder.getStackCard().lastElement();
		StackCard stackSuit = suitStacks.get(card.getSuit());
		if (stackSuit.getStackCard().isEmpty()) {
			if (card.getNumber().getCardValue() == 1) {
				stackSuit.getStackCard().push(ladder.getStackCard().pop());
			} else {
				io.writeln("La carta no corresponde");
			}
		} else {
			int previousCardValue = stackSuit.getStackCard().lastElement().getNumber().getCardValue();
			if (previousCardValue == card.getNumber().getCardValue() - 1) {
				stackSuit.getStackCard().push(ladder.getStackCard().pop());
			} else {
				io.writeln("La carta no corresponde");
			}
		}
	}
}
