import java.util.LinkedList;

public class Player {
    protected LinkedList<Domino> hand;
    protected int points;

    /**
     *
     * @return
     */
    public int calculatePoints(){
        return 0;
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
