package pl.karnas;

import java.util.Collections;
import java.util.LinkedList;

class GameEngine {

    private GameEngine() {
    }

    private static boolean gameOverCheck(LinkedList<Card> player1deck, LinkedList<Card> player2deck, LinkedList<Card> p1wonCards, LinkedList<Card> p2wonCards) {
        if (player1deck.isEmpty()) {
            if (deckOverCheck(player1deck, p1wonCards, "Game over\nPlayer 2 wins the game")) return true;
        }
        if (player2deck.isEmpty()) {
            if (deckOverCheck(player2deck, p2wonCards, "Game over\nPlayer 1 wins the game")) return true;
        }
        return false;
    }

    private static boolean deckOverCheck(LinkedList<Card> playerDeck, LinkedList<Card> playerWonCards, String s) {
        if (playerWonSomeCards(playerWonCards, s)) return true;
        playerDeck.addAll(playerWonCards);
        playerWonCards.clear();
        Collections.shuffle(playerDeck);
        return false;
    }

    private static boolean playerWonSomeCards(LinkedList<Card> playerWonCards, String s) {
        if (playerWonCards.isEmpty()) {
            System.out.println(s);
            return true;
        }
        return false;
    }

    static void dealCardsForTwoPlayers(DeckOfCards deck, Player player1, Player player2) {
        while (deck.getSizeOfDeck() != 0) {
            player1.getHand().add(deck.dealCard());
            player2.getHand().add(deck.dealCard());
        }
    }

    static boolean warExecutin(LinkedList<Card> player1deck, LinkedList<Card> player2deck, LinkedList<Card> p1wonCards, LinkedList<Card> p2wonCards) {
        if (gameOverCheck(player1deck, player2deck, p1wonCards, p2wonCards)) return true;

        Card p1Card = player1deck.pop();
        Card p2Card = player2deck.pop();

        System.out.println("Player 1 played card is " + p1Card.toString());
        System.out.println("Player 2 played card is " + p2Card.toString());

        if (p1Card.getRank() > p2Card.getRank()) {
            p1wonCards.addLast(p1Card);
            p1wonCards.addLast(p2Card);
            System.out.println("PLayer 1 wins the round");
        } else if (p1Card.getRank() < p2Card.getRank()) {
            p2wonCards.addLast(p1Card);
            p2wonCards.addLast(p2Card);
            System.out.println("PLayer 2 wins the round");
        } else {

            System.out.println("WAR is executed:\n");

            LinkedList<Card> war1 = new LinkedList<>();
            LinkedList<Card> war2 = new LinkedList<>();
            war1.add(p1Card);
            war2.add(p2Card);

            if (playCards(player1deck, player2deck, p1wonCards, p2wonCards, war1, war2, "War card for player1 is xx\nWar card for player2 is xx"))
                return true;

            while (war1.get(0).getRank() == war2.get(0).getRank()) {
                if (playCards(player1deck, player2deck, p1wonCards, p2wonCards, war1, war2, "\n\nREMIS IN WAR\n\n"))
                    return true;
            }

            if (war1.size() == war2.size()) {
                System.out.println("War card for player1 is " + war1.get(0).toString());
                System.out.println("War card for player2 is " + war2.get(0).toString());
                if (war1.get(0).getRank() > war2.get(0).getRank()) {
                    p1wonCards.addAll(war1);
                    p1wonCards.addAll(war2);
                    System.out.println("Player 1 wins the war round");
                } else if (war1.get(0).getRank() < war2.get(0).getRank()) {
                    p2wonCards.addAll(war1);
                    p2wonCards.addAll(war2);
                    System.out.println("Player 2 wins the war round");
                }
            }
        }
        return false;
    }

    private static boolean playCards(LinkedList<Card> player1deck, LinkedList<Card> player2deck,
                                     LinkedList<Card> p1wonCards, LinkedList<Card> p2wonCards,
                                     LinkedList<Card> war1, LinkedList<Card> war2, String s) {
        System.out.println(s);
        for (int i = 0; i < 2; i++) {
            if (gameOverCheck(player1deck, player2deck, p1wonCards, p2wonCards)) return true;
            war1.addFirst(player1deck.pop());
            war2.addFirst(player2deck.pop());
        }
        return false;
    }
}
