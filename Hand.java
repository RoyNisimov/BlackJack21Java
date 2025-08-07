import java.util.ArrayList;
public class Hand {
    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<String> normalOrderCards = new ArrayList<>();
    private int Aces = 0;
    public Hand(ArrayList<Card> cards){
        for (Card card: cards){
            if(card.getValue() == 1){Aces++; continue;}
            this.cards.add(card);
        }
    }
    public Hand(){
        this.cards = new ArrayList<>();
        this.Aces = 0;
    }
    public void AddCard(Card c){
        if (c.getValue() == 1){Aces++;
            this.normalOrderCards.add("A");
            return;}
        cards.add(c);
        normalOrderCards.add(c.getFaceValue());
    }
    public void muckHand(Deck deck){
        for (Card c: cards) {
            deck.muckCard(c);
        }
        this.cards.clear();
        this.Aces = 0;
        this.normalOrderCards.clear();
    }
    public void printHand(){
        StringBuilder s = new StringBuilder();
        for (String str : normalOrderCards) {
            s.append(str).append(",");
        }
        System.out.println(s + " => " + Integer.toString(sum()));
    }
    public int sum(){
        int s = 0;
        for (Card card : cards) {
            s += card.getValue();
        }
        int currentAces = Aces;
        for (int i = 0; i < currentAces; i++) {
            if (s > 10) {
                s += currentAces;
                break;
            }
            s = s+11;
            currentAces--;
        }
        return s;
    }
    public boolean isBusted(){
        return sum() > 21;
    }
}
