package pl.karnas;

import java.util.ArrayList;
import java.util.List;

class Player {
    private final List<Card> hand;

    Player() {
        this.hand = new ArrayList<>();
    }

    List<Card> getHand() {
        return hand;
    }

    @Override
    public String toString() {
        return hand.toString();
    }

}
