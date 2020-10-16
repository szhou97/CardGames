public class PlayerMoves {
    private BlackJackTable bt;
    private Player player;
    private inputPrompt in;
    public PlayerMoves(Player player, BlackJackTable bt) {
        this.bt = bt;
        this.player = player;
        this.in = new inputPrompt();
    }

    public int prompt(boolean d) {
        int min = 1, max = 1;
        System.out.print("1: Hit");
        if (this.player.getPlayerType().equals("player")) {
            System.out.print(", 2: Stand, 3: Double up");
            max = 3;
            if (d) {
                System.out.println(", 4: Split");
                max = 4;
            } else {
                System.out.println("");
            }
        }
        return this.in.singleIntegerInput(min, max);
    }
  
    public void makeMove() {
        System.out.println("Player " + this.player.getPlayerIndex() 
                        + " please make a move");
        boolean d = player.checkDouble();
        int selection = this.prompt(d);
        switch(selection) {
            case 1:
                this.hit();
            case 2:
                this.stand();
            case 3:
                this.doubleUp();
            case 4:
                this.split();
        }
    }

    public void hit() {
        bt.dealCards(this.player, true);
    }

    public void stand() {
        this.player.setStatus(false);
    }

    public void doubleUp() {
        int bet = player.getCurrentBet();
        this.player.setBet(2*bet);
        bt.dealCards(this.player,true);
        this.player.setStatus(false);
    }

    public void split() {
        this.player.split();
    }

    
}
