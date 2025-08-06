import java.util.Random;
public class Main {
    public static void main(String[] args){
        Card[] deck = initialiseDeck();
        int shuffles = 5;
        for (int i = 0; i < shuffles; i++) {
            shuffleArray(deck);
        }
        printDeck(deck);
    }
    public static void printDeck(Card[] deck){
        for (int i = 0; i < 52; i++) {
            System.out.println(deck[i].printCard());
        }
    }
    public static Card[] initialiseDeck(){
        Card[] deck = new Card[52];
        int index = 0;
        for (int suit = 1; suit < 5; suit++) {
            for (int value = 1; value < 14; value++) {
                deck[index] = new Card(value, suit);
                index++;
            }
        }
        return deck;
    }
    static void shuffleArray(Object[] ar)
    {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Object a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}
