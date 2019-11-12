package pl.karnas;

enum Suit {

    DIAMONDS("Diamonds"),
    CLUBS("Clubs"),
    HEARTS("Hearts"),
    SPADES("Spades");

    private final String suitName;

    Suit(String suitName) {
        this.suitName = suitName;
    }

    String getSuitName() {
        return suitName;
    }

    @Override
    public String toString() {
        return suitName;
    }
}
