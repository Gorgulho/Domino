import java.util.LinkedList;

public class Player {
    protected LinkedList<Domino> hand;
    protected int points;

    /**
     *
     * @return
     */
    public int calculatePoints(){
        for(int i = 0; i < hand.size(); i++) {
            this.points += hand.get(i).sumPoints();
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
        for(int i = 0; i < hand.size(); i++){
            if(p.compareTo(hand.get(i)) == 1){return true;}
        }
        return false;
    }

    /**
     *
     * @return
     */
    public boolean canPlay(Domino a){
        if(this.hasPiece(a)) return true;
        return false;
    }
}