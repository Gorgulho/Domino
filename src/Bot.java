import java.util.LinkedList;

public class Bot extends Player{

    /**
     *
     * @param hand - LinkedList with the 7 Dominos for the Bot to use
     */
    public Bot(LinkedList<Domino> hand){
        super(hand);
    }

    @Override
    public Domino[] play(LinkedList<Domino> corners) {
        for (Domino dm : this.hand){
            for (Domino corner : corners){
                if (corner.canConnect(dm) != null) return new Domino[]{dm, corner};
            }
        }

        return null;
    }

}
