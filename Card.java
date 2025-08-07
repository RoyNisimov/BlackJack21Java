import java.util.HashMap;
public class Card {
    private int value = -1;
    private String faceValue = "";
    public Card(int value){
        this.setValue(value);
        this.setFaceValue(value);
    }
    public void setValue(int value){
        if (value > 10){value = 10;}
        this.value = value;
    }
    public int getValue() {
        return this.value;
    }

    public String printCard(){
        return "Face Value" + getFaceValue() + "Value: " + Integer.toString(getValue());
    }

    public String getFaceValue() {
        return faceValue;
    }
    public void setFaceValue(int faceValue) {
        if (faceValue == 1){this.faceValue = "A"; return;}
        if (faceValue == 11){this.faceValue = "J"; return;}
        if (faceValue == 12){this.faceValue = "Q"; return;}
        if (faceValue == 13){this.faceValue = "K"; return;}
        this.faceValue = Integer.toString(faceValue);

    }
    public void setFaceValue(String faceValue) {
        this.faceValue = faceValue;
    }
}
