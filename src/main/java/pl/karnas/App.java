package pl.karnas;

import java.util.LinkedList;

/**
 * War card game where higher card wins over lower. Wins player who collects all cards.
 *
 * @author pi0trk
 */
public class App {
    public static void main(String[] args) {

        DeckOfCards deck = new DeckOfCards();
        Player player1 = new Player();
        Player player2 = new Player();

        GameEngine.dealCardsForTwoPlayers(deck, player1, player2);

        LinkedList<Card> player1deck = new LinkedList<>(player1.getHand());
        LinkedList<Card> player2deck = new LinkedList<>(player2.getHand());

        LinkedList<Card> p1wonCards = new LinkedList<>();
        LinkedList<Card> p2wonCards = new LinkedList<>();

        while (true) {
            if (GameEngine.warExecutin(player1deck, player2deck, p1wonCards, p2wonCards)) return;
        }
    }

}
