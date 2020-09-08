import java.util.*;
public class deckofcards
{
public static void main(String args[])
{
final Deck deck = new Deck();
System.out.println("Shuffled Deck:");
System.out.println(deck.shuffle());
System.out.println("Sorted Deck:");
System.out.println(deck.sort());
}
}