package pl.karnas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static pl.karnas.Rank.*;
import static pl.karnas.Suit.*;

class DeckOfCards {

    private final Suit[] suits = {DIAMONDS, CLUBS, HEARTS, SPADES};
    private final Rank[] ranks = {DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE};

    List<Card> deck() {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < 52; i++) {
            Suit suit = suits[i / 13];
            Rank rank = ranks[i % 13];
            cards.add(new Card(suit, rank));
        }
        Collections.shuffle(cards);
        return cards;
    }

    public void dealCard(Player player) {
        Card removedCard = deck().remove(1);
        player.getHand().add(removedCard);
    }

    public Card dealCard(int i) {
        return deck().remove(i);
    }

    public int getSizeOfDeck() {
        return deck().size();
    }

}



