import java.util.HashMap;
public class Card {
    private int value = -1;
    private int suit = -1;
    public static String suitConverter(int suit){
        HashMap<Integer,String> suits = new HashMap<Integer, String>();
        suits.put(1, "Clubs");
        suits.put(2, "Hearts");
        suits.put(3, "Spades");
        suits.put(4, "Diamonds");
        return suits.get(suit);
    }
    public Card(int value, int suit){
        this.setValue(value);
        this.setSuit(suit);
    }
    public void setValue(int value){
        if (value > 10){value = 10;}
        this.value = value;
    }
    public int getValue() {
        return this.value;
    }
    public void setSuit(int suit) {
        this.suit = suit;
    }
    public int getSuit(){
        return this.suit;
    }
    public String printCard(){
        if (this.value == 1){
            return "Suit: " + suitConverter(getSuit()) + ", Value: A";
        }
        return "Suit: " + suitConverter(getSuit()) + ", Value: " + Integer.toString(getValue());
    }
}
