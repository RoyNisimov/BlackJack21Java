import java.util.Random;
import java.util.ArrayList;
public class Deck {
    private ArrayList<Card> deck;
    private ArrayList<Card> muck;
    private ArrayList<Card> cards_out;
    public Deck(int shuffles){
        this.muck = new ArrayList<>();
        this.cards_out = new ArrayList<>();
        this.deck = initialiseDeck();
        for (int i = 0; i < shuffles; i++) {
            shuffleDeck(deck);
        }
    }
    public Deck(){
        this.muck = new ArrayList<>();
        this.cards_out = new ArrayList<>();

        this.deck = initialiseDeck();
        int shuffles = 5;
        for (int i = 0; i < shuffles; i++) {
            shuffleDeck(deck);
        }
    }
    public void printDeck(){
        for (int i = 0; i < 52; i++) {
            System.out.println(this.deck.get(i).printCard());
        }
    }
    public ArrayList<Card> initialiseDeck(){
        ArrayList<Card> deck = new ArrayList<>();
        for (int suit = 1; suit < 5; suit++) {
            for (int value = 1; value < 14; value++) {
                deck.add(new Card(value));
            }
        }
        return deck;
    }
    public void shuffleDeck(ArrayList<Card> ar)
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
    public Card draw(){
        Card top = deck.getFirst();
        deck.removeFirst();
        cards_out.add(top);
        return top;
    }

    public void burn(){
        muckCard(draw());
    }

    /**
     * Adds the card to the muck
     * @param c is the card we muck
     */
    public void muckCard(Card c){
        this.muck.add(c);
    }

    /**
     * Gets the current running count
     * @return the count
     */
    public int getCount(){
        int count = 0;
        for (Card c: this.muck){
            int cValue = c.getValue();
            if ((2 <= cValue) && (cValue <= 6)){
                count++;

            }else if(cValue == 10 || cValue == 1){
                count--;
            }
        }
        return count;
    }
}
