public class PlayerType {
    private int type;
    public PlayerType(int type) {
        this.type = type;
    }    

    public String getPlayerType() {
        String playerType = null;
        switch(this.type){
            case 0:
                playerType = "dealer";
                break;
            case 1:
                playerType = "player";
                break;
        }
        return playerType;
    }

    public void setPlayerType(int type) {
        this.type = type;
    }

    public boolean equals(PlayerType type) {
        return this.getPlayerType().equals(type.getPlayerType());
    }
}
