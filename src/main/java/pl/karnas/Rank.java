package pl.karnas;

enum Rank {
    DEUCE(2, "Deuce"),
    THREE(3, "Three"),
    FOUR(4, "Four"),
    FIVE(5, "Five"),
    SIX(6, "Six"),
    SEVEN(7, "Seven"),
    EIGHT(8, "Eight"),
    NINE(9, "Nine"),
    TEN(10, "Ten"),
    JACK(11, "Jack"),
    QUEEN(12, "Queen"),
    KING(13, "King"),
    ACE(14, "Ace");

    private final int rankValue;
    private final String rankName;

    Rank(int rank, String rankName) {
        this.rankValue = rank;
        this.rankName = rankName;
    }

    int getRankValue() {
        return rankValue;
    }

    String getRankName() {
        return rankName;
    }

    @Override
    public String toString() {
        return rankValue+"";
    }
}
