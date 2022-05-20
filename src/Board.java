import java.util.LinkedList;
import java.util.List;

public class Board {
    private final Node firstDomino;
    private int width; //2*28
    private int height; //3*28
    private List<Domino> dominos;
    private static class Node{
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
        }
    }

    /**
     *
     * @param first //firstDomino
     */
    public Board(Domino first, int width, int height){
        this.firstDomino = new Node(first);
        this.width = width;
        this.height = height;
        this.dominos = new LinkedList<Domino>();

    }

    /**
     *
     * @return
     */
    public Domino getFirstDomino() {return firstDomino.piece;}

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
    public String toString() {return super.toString();
    }
}
