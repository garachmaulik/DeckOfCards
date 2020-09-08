import java.util.*;
public class Deck
{
	private final ArrayList<Card> deckCards;

	public Deck(){this.deckCards = initDeck();}

	private ArrayList<Card> initDeck()
	{
		final ArrayList<Card> deckCards = new ArrayList<>();
		for(final Card.Suit suit: Card.Suit.values())
		{
			for(final Card.Rank rank: Card.Rank.values())
			{
				deckCards.add(Card.getCard(rank,suit));
			}
		}
		return deckCards;
	}

	public ArrayList<Card> getDeck()
	{
		return deckCards;
	}

	public ArrayList<Card> shuffle()
	{
		Collections.shuffle(deckCards);
		return deckCards;
	}

	public ArrayList<Card> sort()
	{
		Collections.sort(deckCards);
		return deckCards;
	}

}