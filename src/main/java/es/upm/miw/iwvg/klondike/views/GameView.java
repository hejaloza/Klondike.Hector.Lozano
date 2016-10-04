package es.upm.miw.iwvg.klondike.views;

import java.util.ArrayList;
import java.util.Hashtable;

import es.upm.miw.iwvg.klondike.models.StackCard;
import es.upm.miw.iwvg.klondike.models.StackDeck;
import es.upm.miw.iwvg.klondike.models.StackLadder;
import es.upm.miw.iwvg.klondike.models.Suit;
import es.upm.miw.iwvg.klondike.utils.IO;

public class GameView {

	private StackDeck deck;
	private ArrayList<StackLadder> ladders;
	private Hashtable<Suit,StackCard> suitStacks;
	private StackCard discard;
	private IO io;


	public GameView(StackDeck deck, ArrayList<StackLadder> ladders, Hashtable<Suit,StackCard> suitStacks,
			StackCard discard) {

		this.deck = deck;
		this.ladders = ladders;
		this.suitStacks = suitStacks;
		this.discard = discard;
		io = new IO();
	}

	public void board() {
		if(deck.getStackCard().size()==0){
			io.writeln("Baraja: []");
		}else{
			io.writeln("Baraja: [X,X]");
		}
		

		System.out.println("Descarte:" + discard.toString());

		for (int i = 0; i < Suit.values().length; i++) {
			io.writeln("Palo " + Suit.values()[i] + ": " + suitStacks.get(Suit.values()[i]));
		}

		for (int i = 1; i <= 7; i++) {
			io.writeln("Escalera" + i + ": " + ladders.get(i - 1).toString());
		}

		io.writeln("--------------------------------------");
	}

	public void imprimirBoard() {
		board();
		io.writeln("1. Mover de baraja a descarte");
		io.writeln("2. Mover de descarte a baraja");
		io.writeln("3. Mover de descarte a palo");
		io.writeln("4. Mover de descarte a escalera");
		io.writeln("5. Mover de escalera a palo");
		io.writeln("6. Mover de escalera a escalera");
		io.writeln("7. Mover de palo a escalera");
		io.writeln("8. Voltear en escalera");
		io.writeln("9. Salir");

	}

}