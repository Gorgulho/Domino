import java.util.LinkedList;

public class Player {
    protected LinkedList<Domino> hand;
    protected int points;

    /**
     *
     * @return
     */
    public int calculatePoints(){
        for(int i = 0; i < hand.size(); i++){
            this.points += (hand[i].getHalf1() + hand[i].getHalf2());
        }
        return this.points;
    }

    /**
     *
     * @return
     */
    public LinkedList<Domino> getHand() {
        return hand;
    }

    /**
     *
     * @param p
     * @return
     */
    public boolean hasPiece(Domino p){
        return false;
    }

    /**
     *
     * @return
     */
    public boolean canPlay(){
        return false;
    }
}
