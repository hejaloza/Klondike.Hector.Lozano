package es.upm.miw.iwvg.klondike.controllers;

import java.util.ArrayList;

import es.upm.miw.iwvg.klondike.models.Card;
import es.upm.miw.iwvg.klondike.models.StackLadder;
import es.upm.miw.iwvg.klondike.utils.IO;
import es.upm.miw.iwvg.klondike.views.GameView;

public class FlipCardController {

	private ArrayList<StackLadder> ladders;
	private GameView gameView;
	private IO io;

	public FlipCardController(ArrayList<StackLadder> ladders, GameView gameView) {
		this.ladders = ladders;
		this.gameView = gameView;
		io = new IO();
	}

	public void execute() {
		int ladderPosition = io.readInt("En que Escalera? [1-7]:");
		Card card = ladders.get(ladderPosition - 1).getStackCard().lastElement();
		if (card.isHidden()) {
			card.setHidden(false);
		} else {
			io.writeln("Carta ya está volteada");
		}
	}

}
