package es.upm.miw.iwvg.klondike;

import es.upm.miw.iwvg.klondike.controllers.DeckToDiscardController;
import es.upm.miw.iwvg.klondike.controllers.DiscardToDeckController;
import es.upm.miw.iwvg.klondike.controllers.DiscardToLadderController;
import es.upm.miw.iwvg.klondike.controllers.DiscardToSuitController;
import es.upm.miw.iwvg.klondike.controllers.FlipCardController;
import es.upm.miw.iwvg.klondike.controllers.LadderToLadderController;
import es.upm.miw.iwvg.klondike.controllers.LadderToSuitController;
import es.upm.miw.iwvg.klondike.controllers.SuitToLadderController;
import es.upm.miw.iwvg.klondike.models.Game;
import es.upm.miw.iwvg.klondike.utils.IO;
import es.upm.miw.iwvg.klondike.views.GameView;

public class Klondike {

	private Game game;
	boolean ok;
	private GameView gameView;
	private IO io;

	public Klondike() {
		game = new Game();
		gameView = new GameView(game.getDeck(), game.getLadders(), game.getSuitStacks(), game.getDiscard());
		io = new IO();
		init();
		play();
	}

	public void init() {
		gameView.imprimirBoard();
	}

	public void play() {
		do {
			ok = false;
			int opcion = io.readInt("Opcion= [1-9]:");
			if (opcion == 1) {
				new DeckToDiscardController(game.getDiscard(), game.getDeck(), gameView).execute();
				gameView.imprimirBoard();
			} else if (opcion == 2) {
				new DiscardToDeckController(game.getDiscard(), game.getDeck(), gameView).execute();
				gameView.imprimirBoard();
			} else if (opcion == 3) {
				new DiscardToSuitController(game.getDiscard(), game.getSuitStacks(), gameView).execute();
				gameView.imprimirBoard();
			} else if (opcion == 4) {
				new DiscardToLadderController(game.getDiscard(), game.getLadders(), gameView).execute();
				gameView.imprimirBoard();
			} else if (opcion == 5) {
				new LadderToSuitController(game.getLadders(), game.getSuitStacks(), gameView).execute();
				gameView.imprimirBoard();
			} else if (opcion == 6) {
				new LadderToLadderController(game.getLadders(), gameView).execute();
				gameView.imprimirBoard();
			} else if (opcion == 7) {
				new SuitToLadderController(game.getLadders(), game.getSuitStacks(), gameView).execute();
				gameView.imprimirBoard();
			} else if (opcion == 8) {
				new FlipCardController(game.getLadders(), gameView).execute();
				gameView.imprimirBoard();
			}
		} while (!ok);
	}

	public static void main(String[] args) {
		new Klondike();
	}
}