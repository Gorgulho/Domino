import java.util.LinkedList;
import java.util.List;

public class Board {
    private final Node firstDomino;
    private int width; //2*28
    private int height; //3*28
    private List<Domino> dominos;
    private LinkedList<Node> corners;
    private String print[][];

    private static class Node {
        private Node left;
        private Node right;
        private Node up;
        private Node down;
        private final Domino piece;

        /**
         * @param piece
         */
        public Node(Domino piece) {
            this.piece = piece;
        }

        public boolean isFull() {
            if (this.piece instanceof Pair) {
                return left != null && right != null && up != null && down != null;
            } else {
                if (this.piece.isRotated()) return up != null && down != null;
                else return left != null && right != null;
            }
        }

        public String toString(Node other) {
            return "Node{" + "side1=" + (left == other ? "rec" : left) + ", side2=" + (right == other ? "rec" : right) + ", lat1=" + (up == other ? "rec" : up) + ", lat2=" + (down == other ? "rec" : down) + ", piece=" + piece + '}';
        }

        @Override
        public String toString() {
            return "Node{" + "side1=" + (left == null ? "null" : left.toString(this)) + ", side2=" + (right == null ? "nulll" : right.toString(this)) + ", lat1=" + (up == null ? "null" : up.toString(this)) + ", lat2=" + (down == null ? "null" : down.toString(this)) + ", piece=" + piece + '}';
        }
    }

    /**
     * @param first //firstDomino
     */
    public Board(Domino first, int width, int height) {
        if (!first.isRotated()) first.rotate();

        this.firstDomino = new Node(first);
        this.width = width;
        this.height = height;
        this.dominos = new LinkedList<Domino>();
        this.corners = new LinkedList<>();
        this.corners.add(this.firstDomino);
        this.print = new String[56][84];

    }

    /**
     * @return
     */
    public void fillPrint() {
        for (int i = 0; i < print.length; i++) {
            for (int j = 0; j < print[i].length; j++) {
                print[i][j] = " ";
            }
        }
    }

    public void printTurn(Domino a, int x, int y) {
        this.print[x][y] = a.getHalf1() + " " + a.getHalf2();
        for (int i = 0; i < print.length; i++) {
            System.out.println();
            for (int j = 0; j < print[i].length; j++) {
                System.out.print(this.print[i][j] + "  ");
            }
        }
    }

    public Domino getFirstDomino() {
        return firstDomino.piece;
    }

    /**
     * @param piece
     * @param corner
     */
    public void addDominoToCorner(Domino piece, Domino corner) {
        Node c = getNode(corner);
        if (c == null) return;

        List<Side> sides = c.piece.canConnect(piece);

        if (sides == null) return;

        Node newPiece = new Node(piece);

        for (Side s: sides) {
            if (c.left == null && s == Side.LEFT){
                assert c.piece.isPair() || !c.piece.isRotated();

                if (newPiece.piece.isPair()) newPiece.piece.rotate();

                if (newPiece.piece.getHalf1() == c.piece.getHalf1()) newPiece.piece.flip();

                c.left = newPiece;
                newPiece.right = c;

                break;
            }else if (c.up == null && s == Side.UP) {
                assert c.piece.isPair() || c.piece.isRotated();

                if (!newPiece.piece.isPair()) newPiece.piece.rotate();

                if (newPiece.piece.getHalf1() == c.piece.getHalf1()) newPiece.piece.flip();

                c.up = newPiece;
                newPiece.down = c;

                break;
            } else if (c.right == null && s == Side.RIGHT){
                assert c.piece.isPair() || !c.piece.isRotated();
                break;
            } else if (c.down == null && s == Side.DOWN) {
                assert c.piece.isPair() || c.piece.isRotated();
                break;
            }
        }

        //TODO: the validation to add again in linked list corners or not

    }

    @Override
    public String toString() {
        return "Board{" +
                "firstDomino=" + firstDomino +
                '}';
    }

    /**
     * @return
     */


    public Iterable<Domino> leftSide() {
        LinkedList<Domino> itr = new LinkedList<>();
        sideListGenerator();
        return itr;
    }

    private void sideListGenerator() {

    }

    private Node getNode(Domino dm) {
        int i = 0;
        for (Node nd : this.corners) {
            if (nd.piece.compareTo(dm) > 0) return this.corners.remove(i);
            else i++;
        }
        return null;
    }

    public Iterable<Domino> oQueTuQuiseres(Node n) {
        LinkedList<Domino> dominos = new LinkedList<>();
        oQueTuQuiseres(n, dominos);
        return dominos;
    }

    private void oQueTuQuiseres(Node n, LinkedList<Domino> list) {
        if (n.left != null) oQueTuQuiseres(n.left, list);
        list.add(n.piece);
    }
}
