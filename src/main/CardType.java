/**
 * A class representing the card type
 */
public class CardType {
    private String type;
    /**
     * Constructing a card type
     * @param num
     */
    public CardType(int num) {
        switch(num) {
            case 1:
                this.type = "A";
                break;
            case 2:
                this.type = "2";
                break;
            case 3:
                this.type = "3";
                break;
            case 4:
                this.type = "4";
                break;
            case 5:
                this.type = "5";
                break;
            case 6:
                this.type = "6";
                break;
            case 7:
                this.type = "7";
                break;
            case 8:
                this.type = "8";
                break;
            case 9:
                this.type = "9";
                break;
            case 10:
                this.type = "10";
                break;
            case 11:
                this.type = "J";
                break;
            case 12:
                this.type = "Q";
                break;
            case 13:
                this.type = "K";
                break;
        }
    }

    public String getType() {
        return this.type;
    }

    public int getValue() {
        int value = 0;
        switch(this.type) {
            case "A":
                value = 1;
                break;
            case "2":
                value = 2;
                break;
            case "3":
                value = 3;
                break;
            case "4":
                value = 4;
                break;
            case "5":
                value = 5;
                break;
            case "6":
                value = 6;
                break;
            case "7":
                value = 7;
                break;
            case "8":
                value = 8;
                break;
            case "9":
                value = 9;
                break;
            default:
                value = 10;
                break;
        }
        return value;
    }
}
