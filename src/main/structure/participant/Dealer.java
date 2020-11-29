/******************************************************************************
 * Class: Dealer
 * Author: Shuaike Zhou
 * Email: szhou97@bu.edu
 *****************************************************************************/

package structure.participant;

/**
 * Dealer class
 */
public class Dealer extends Participant {
    private DealerHand hand;
    public Dealer(String name) {
        super(name);
        this.hand = new DealerHand();
    }

    public DealerHand getHand() {
        return hand;
    }
}
