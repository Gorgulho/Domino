import java.util.LinkedList;
import java.util.List;

public class Board {
    private Node firstDomino;
    private int width; //2*28
    private int height; //3*28
    private List<Domino> dominos;

    private LinkedList<Domino> corners;

    private static class Node{
        private Domino side1;
        private Domino side2;
        private Domino lat1;
        private Domino lat2;
        private final Domino piece;

        /**
         *
         * @param piece
         */
        public Node(Domino piece){
            this.piece = piece;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "side1=" + side1 +
                    ", side2=" + side2 +
                    ", lat1=" + lat1 +
                    ", lat2=" + lat2 +
                    ", piece=" + piece +
                    '}';
        }
    }

    /**
     *
     * @param first - first Domino, in case <6|6>
     * @param width - width limit for the board
     * @param height - height limit for the board
     */
    public Board(Domino first, int width, int height){
        if (first.compareTo(new Domino(6, 6)) > 0) {
            this.firstDomino = new Node(first);
            this.width = width;
            this.height = height;
            this.dominos = new LinkedList<Domino>(); //Tomás isto serve para quê??
            this.corners = new LinkedList<>();
        } else System.exit(0);
    }

    /**
     *
     * @return
     */
    public Domino getFirstDomino() {return firstDomino.piece;}

    /**
     *
     * @param piece
     * @param Corner
     */
    public void addDominoToCorner(Domino piece, Domino Corner){

    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Board{" +
                "firstDomino=" + firstDomino +
                ", width=" + width +
                ", height=" + height +
                ", dominos=" + dominos +
                '}';
    }

    public LinkedList<Domino> getCorners() {
        return corners;
    }
}
