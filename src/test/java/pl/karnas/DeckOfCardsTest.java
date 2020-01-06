package pl.karnas;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DeckOfCardsTest {

    @Test
    public void testShuffledDeckShouldReturn52Cards() {
        DeckOfCards deck = new DeckOfCards();
        assertEquals(deck.cards.size(), 52   );
    }
}