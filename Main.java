import java.util.Random;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args){
        ArrayList<Card> deck = initialiseDeck();
        int shuffles = 5;
        for (int i = 0; i < shuffles; i++) {
            shuffleArray(deck);
        }
        printDeck(deck);
    }
    public static void printDeck(ArrayList<Card> deck){
        for (int i = 0; i < 52; i++) {
            System.out.println(deck.get(i).printCard());
        }
    }
    public static ArrayList<Card> initialiseDeck(){
        ArrayList<Card> deck = new ArrayList<>();
        for (int suit = 1; suit < 5; suit++) {
            for (int value = 1; value < 14; value++) {
                deck.add(new Card(value));
            }
        }
        return deck;
    }
    static void shuffleArray(ArrayList<Card> ar)
    {
        Random rnd = new Random();
        for (int i = ar.size() - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Card a = ar.get(index);
            ar.set(index, ar.get(i));
            ar.set(i, a);
        }
    }
}
