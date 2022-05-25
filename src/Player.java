import java.util.LinkedList;

public abstract class Player {
    protected LinkedList<Domino> hand;
    protected int points;

    /**
     *
     * @param hand - LinkedList with the 7 Dominos for the player to use
     */
    public Player(LinkedList<Domino> hand) {
        this.hand = hand;
        this.points = 0;
    }

    public int getPoints() {
        return points;
    }

    /**
     *
     * @return
     */
    public void calculatePoints(){
        for (Domino domino : hand) {
            this.points += domino.sumPoints();
        }
    }
    public boolean hasPieces(){
        return !hand.isEmpty();
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
        for (Domino domino : hand) {
            if (p.compareTo(domino) > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return
     */
    public boolean canPlay(Domino a){
        return this.hasPiece(a);
    }

    public Domino givePiece(int h1, int h2){
        Domino piece = new Piece(h1, h2);
        int i = 0;
        for(Domino dm: this.hand){
            if (dm.compareTo(piece) > 0) return this.hand.remove(i);
            else i++;
        }

        return null;
    }

    public void recivePiecesBack(LinkedList<Domino> back){
        while (!back.isEmpty()){
            this.hand.add(back.remove());
        }
    }

    public abstract Domino[] play(LinkedList<Domino> corners);

    @Override
    public String toString() {
        return this.getClass().getName() + " com " + this.points + "pontos!";
    }
}