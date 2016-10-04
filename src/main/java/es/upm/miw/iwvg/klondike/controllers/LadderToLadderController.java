package es.upm.miw.iwvg.klondike.controllers;

import java.util.ArrayList;

import es.upm.miw.iwvg.klondike.models.StackCard;
import es.upm.miw.iwvg.klondike.models.StackLadder;
import es.upm.miw.iwvg.klondike.utils.IO;
import es.upm.miw.iwvg.klondike.views.GameView;

public class LadderToLadderController {

	private ArrayList<StackLadder> ladders;
	private GameView gameView;
	private IO io;

	public LadderToLadderController(ArrayList<StackLadder> ladders, GameView gameView) {
		this.ladders = ladders;
		this.gameView = gameView;
		io = new IO();
	}

	public void execute() {
		int fromLadder = io.readInt("De que Escalera? [1-7]:");
		int howManyCards = io.readInt("Cuantas Cartas?:");
		int toLadder = io.readInt("A que Escalera? [1-7]:");
		StackLadder from = ladders.get(fromLadder - 1);
		StackLadder to = ladders.get(toLadder - 1);
		int valueFromLadder = from.getStackCard().lastElement().getNumber().getCardValue() - howManyCards;
		int valueToLadder = to.getStackCard().lastElement().getNumber().getCardValue();
		if (valueFromLadder == valueToLadder + 1) {
			StackCard stackCard = new StackCard();
			for (int i = 0; i < howManyCards; i++) {
				stackCard.getStackCard().push(ladders.get(fromLadder - 1).getStackCard().pop());
			}
			while (stackCard.getStackCard().size() != 0) {
				ladders.get(toLadder - 1).getStackCard().push(stackCard.getStackCard().pop());
			}
		} else {
			io.writeln("Selección no válida");
		}
	}
}
