import java.util.LinkedList;

public class Bot extends Player{

    /**
     * Sets the player's hand and initializes the player's points as 0
     * @param hand - LinkedList with the 7 Dominos for the Bot to use
     */
    public Bot(LinkedList<Domino> hand){
        super(hand);
    }

    /**
     *
     * @param corners list of dominoes that are "open" to play
     * @return array of dominoes containing the domino connected and the corner domino being connected to, null if play isn't valid
     */
    @Override
    public Domino[] play(LinkedList<Domino> corners) {
        for (Domino dm : this.hand){
            for (Domino corner : corners){
                if (corner.canConnect(dm) != null) {
                    Domino[] arr = new Domino[]{this.givePiece(dm.getHalf1(), dm.getHalf2()), corner};
                    return arr;
                }
            }
        }

        return null;
    }

}
