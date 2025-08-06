import java.util.HashMap;
public class Card {
    private int value = -1;

    public Card(int value){
        this.setValue(value);
    }
    public void setValue(int value){
        if (value > 10){value = 10;}
        this.value = value;
    }
    public int getValue() {
        return this.value;
    }

    public String printCard(){
        if (this.value == 1){
            return "Value: A";
        }
        return "Value: " + Integer.toString(getValue());
    }
}
