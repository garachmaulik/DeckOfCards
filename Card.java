import java.util.*;
public class Card implements Comparable<Card>
{

	private final Rank rank;
	private final Suit suit;

	enum Rank
	{
		TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),NINE(9),TEN(10),JACK(11),QUEEN(12),KING(13),ACE(14);
		private final int rankValue;
		Rank(final int rankValue)
		{
			this.rankValue = rankValue;
		}
		public int getRankValue(){return this.rankValue;}
	};

	enum Suit
	{
		DIAMOND(1),CLUB(2),HEART(3),SPADE(4);
		private final int suitValue;
		Suit(final int suitValue)
		{
			this.suitValue = suitValue;
		}
		public int getSuitValue()
		{
			return this.suitValue;
		} 
	};

	public Card(final Rank rank, final Suit suit)
	{
		this.rank = rank; this.suit = suit;
	}

	private final static Map<String, Card> card_cache = initCache();

	private static Map<String, Card> initCache()
	{
		final Map<String, Card> cache = new HashMap<>();
		for(final Suit suit: Suit.values())
		{
			for(final Rank rank: Rank.values())
			{
				cache.put(cardKey(rank,suit),new Card(rank,suit));
			}
		}
		return cache;
	}

	public int compareTo(final Card o)
	{
		final int comparison = Integer.compare(this.rank.getRankValue(),o.rank.getRankValue());
		return comparison;
	}

	public String toString()
	{
		return String.format("%s of %s",this.rank,this.suit);
	}

	private static String cardKey(final Rank rank, final Suit suit)
	{
		return rank +" of "+suit;
	}

	public static Card getCard(final Rank rank, final Suit suit)
	{
		final Card card = card_cache.get(cardKey(rank,suit));
		return card;
	}
	
}
