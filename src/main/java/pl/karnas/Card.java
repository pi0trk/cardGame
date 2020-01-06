package pl.karnas;

class Card {
    private final Suit suit;
    private final Rank rank;

    Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    Suit getSuit() {
        return suit;
    }

    int getRank() {
        return rank.getRankValue();
    }

    @Override
    public String toString() {
        return suit + " of " + rank;
    }
}
