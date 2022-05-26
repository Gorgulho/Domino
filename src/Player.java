import java.util.LinkedList;

public abstract class Player {
    protected LinkedList<Domino> hand;
    protected int points;

    /**
     *  Sets the player's hand and initializes the player's points as 0
     * @param hand - LinkedList with the 7 Dominoes for the player to use
     */
    public Player(LinkedList<Domino> hand) {
        this.hand = hand;
        this.points = 0;
    }

    /**
     *
     * @return value of points
     */
    public int getPoints() {
        return points;
    }

    /**
     * adds up all dominoes' points
     */
    public void calculatePoints(){
        for (Domino domino : hand) {
            this.points += domino.sumPoints();
        }
    }

    /**
     *
     * @return true if hand isn´t empty, otherwise false
     */
    public boolean hasPieces(){
        return !hand.isEmpty();
    }

    /**
     *
     * @return linked list of dominoes (player's hand)
     */
    public LinkedList<Domino> getHand() {
        return hand;
    }

    /**
     *
     * @param p domino being searched
     * @return true if player's hand contains 'p', otherwise false
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
     * @param a domino being searched
     * @return true if player's hand contains 'a', otherwise false
     */
    public boolean canPlay(Domino a){
        return this.hasPiece(a);
    }

    /**
     *
     * @param h1 value given for half1 of a new domino
     * @param h2 value given for half2 of a new domino
     * @return  domino removed from hand, null if the domino isn't found in player's hand
     */
    public Domino givePiece(int h1, int h2){
        Domino piece = new Piece(h1, h2);
        int i = 0;
        for(Domino dm: this.hand){
            if (dm.compareTo(piece) > 0) return this.hand.remove(i);
            else i++;
        }

        return null;
    }

    /**
     * adds dominoes from a linked list to the player's hand
     * @param back linked list of dominoes
     */
    public void recivePiecesBack(LinkedList<Domino> back){
        while (!back.isEmpty()){
            this.hand.add(back.remove());
        }
    }

    /**
     *
     * @param corners list of dominoes that are "open" to play
     * @return array of dominoes containing the domino connected and the corner domino being connected to, null if play isn't valid
     */
    public abstract Domino[] play(LinkedList<Domino> corners);

    /**
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return this.getClass().getName() + " com " + this.points + " pontos!";
    }
}