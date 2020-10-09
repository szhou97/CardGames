package CS611Assignment3.src;

public class CardType {
    private String type;
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
}
