package pl.karnas;

/**
 * War card game where higher card wins over lower. Wins player who collects all cards. 
 *
 * @author pi0trk
 *
 */
public class App {
    public static void main( String[] args ) {

        DeckOfCards deck = new DeckOfCards();

        Player player1 = new Player();
        Player player2 = new Player();

        deck.dealCard(player1);
        deck.dealCard(player2);

        System.out.println("Hand of player 1 is "+player1.getHand());
        System.out.println("Hand of player 2 is "+player2.getHand());

        player1.getHand().add(deck.dealCard(1));
        System.out.println("Hand of player 1 is "+player1.getHand());

        player2.getHand().add(deck.dealCard(1));
        System.out.println("Hand of player 2 is "+player2.getHand());




    }
}
