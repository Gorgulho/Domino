import java.util.LinkedList;
import java.util.List;

public class Board {

    private final Node firstDomino;
    private final int width;
    private final int height;
    private List<Domino> dominos;
    //private Domino firstDomino = new Domino(6, 6, 0, 0);
    private static class Node {
        private Domino side1;
        private Domino side2;
        private Domino lat1;
        private Domino lat2;
        private final Domino piece;
        private boolean isPair;


        /**
         *
         * @param piece
         */
        public Node(Domino piece){
            this.piece = piece;
            if (this.piece instanceof Pair){
                this.isPair = true;
            } else if (this.piece instanceof Piece) {
                this.isPair = false;
            }

        }

        public boolean isPair() {
            return isPair;
        }
    }


    /**
     *
     * @param first //firstDomino
     */
    public Board(Domino first /*Domino firstDomino*/, int width, int height){
        //this.firstDomino = firstDomino;
        this.firstDomino = new Node(first);
        this.width = width;
        this.height = height;
        this.dominos = new LinkedList<Domino>();

    }

    /**
     *
     * @return
     */
    public Domino getFirstDomino() {
        return firstDomino.piece;
    }

    /**
     *
     * @param d
     */
    public void addDomino(Domino d){

    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
