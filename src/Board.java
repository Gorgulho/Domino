import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Board {
    private final Node firstDomino;
    private int width; //2*28
    private int height; //3*28
    private ArrayList<Domino> dominos;
    private LinkedList<Node> corners;
    //private String print[][];
    private int xMin, xMax;
    private int yMin, yMax;

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

        /*public String toString(Node other) {
            return "Node{" + "left=" + (left == other ? "rec" : left) + ", right=" + (right == other ? "rec" : right) + ", up=" + (up == other ? "rec" : up) + ", down=" + (down == other ? "rec" : down) + ", piece=" + piece + '}';
        }

        @Override
        public String toString() {
            return "Node{" + "left=" + (left == null ? "null" : left.toString(this)) + ", right=" + (right == null ? "nulll" : right.toString(this)) + ", up=" + (up == null ? "null" : up.toString(this)) + ", up=" + (down == null ? "null" : down.toString(this)) + ", piece=" + piece +'}';
        }*/
    }

    /**
     * @param first //firstDomino
     */
    public Board(Domino first, int width, int height) {
        if (!first.isRotated()) first.rotate();

        first.setXY(0, 1);
        this.xMin = 0;
        this.xMax = 1;
        this.yMin = 0;
        this.yMax = 3;

        this.firstDomino = new Node(first);
        this.width = width;
        this.height = height;
        this.dominos = new ArrayList<>();
        this.dominos.add(first);
        this.corners = new LinkedList<>();
        this.corners.add(this.firstDomino);
        //this.print = new String[56][84];

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

        for (Side s: sides) {  //TODO: still need to implement the coordinates for the print
            if (c.left == null && s == Side.LEFT){
                assert c.piece.isPair() || !c.piece.isRotated();

                if (newPiece.piece.isPair()) newPiece.piece.rotate();
                else if (newPiece.piece.getHalf1() == c.piece.getHalf1()) newPiece.piece.flip();

                c.left = newPiece;
                newPiece.right = c;

                if (!c.piece.isRotated()){
                    if (newPiece.piece.isRotated()) newPiece.piece.setXY(c.piece.getX() - 2, c.piece.getY());
                    else newPiece.piece.setXY(c.piece.getX() - 3, c.piece.getY());
                } else {
                    newPiece.piece.setXY(c.piece.getX() - 2, c.piece.getY());
                }

                break;
            }else if (c.up == null && s == Side.UP) {
                assert c.piece.isPair() || c.piece.isRotated();

                if (!newPiece.piece.isPair()) newPiece.piece.rotate();

                if (newPiece.piece.getHalf1() == c.piece.getHalf1()) newPiece.piece.flip();

                c.up = newPiece;
                newPiece.down = c;

                if (!c.piece.isRotated()){
                    newPiece.piece.setXY(c.piece.getX(), c.piece.getY() - 2);
                } else {
                    if (newPiece.piece.isRotated()) newPiece.piece.setXY(c.piece.getX(), c.piece.getY() - 3);
                    else newPiece.piece.setXY(c.piece.getX(), c.piece.getY() - 2);
                }

                break;
            } else if (c.right == null && s == Side.RIGHT){
                assert c.piece.isPair() || !c.piece.isRotated();

                if (newPiece.piece.isPair()) newPiece.piece.rotate();
                else if (newPiece.piece.getHalf2() == c.piece.getHalf2()) newPiece.piece.flip();

                c.right = newPiece;
                newPiece.left = c;

                if (!c.piece.isRotated()){
                    if (newPiece.piece.isRotated()) newPiece.piece.setXY(c.piece.getX() + 2, c.piece.getY());
                    else newPiece.piece.setXY(c.piece.getX() + 3, c.piece.getY());
                } else {
                    newPiece.piece.setXY(c.piece.getX() + 2, c.piece.getY());
                }

                break;
            } else if (c.down == null && s == Side.DOWN) {
                assert c.piece.isPair() || c.piece.isRotated();

                if (!newPiece.piece.isPair()) newPiece.piece.rotate();

                if (newPiece.piece.getHalf2() == c.piece.getHalf2()) newPiece.piece.flip();

                c.down = newPiece;
                newPiece.up = c;

                if (!c.piece.isRotated()){
                    newPiece.piece.setXY(c.piece.getX(), c.piece.getY() - 2);
                } else {
                    if (newPiece.piece.isRotated()) newPiece.piece.setXY(c.piece.getX(), c.piece.getY() - 3);
                    else newPiece.piece.setXY(c.piece.getX(), c.piece.getY() - 2);
                }

                break;
            }
        }

        this.dominos.add(newPiece.piece);

        if (!c.isFull()) this.corners.add(c);
        if (!newPiece.isFull()) this.corners.add(newPiece);
        updateMinMaxCoordinates(newPiece);
    }

    private void updateMinMaxCoordinates(Node no){
        int x = no.piece.getX();
        int y = no.piece.getY();

        if (x < this.xMin) this.xMin = x - 1;
        if (x > this.xMax) this.xMax = x + 1;

        if (y < this.yMin) this.yMin = y - 1;
        if (y > this.yMax) this.yMax = y + 1;
    }

    public void boardState() {
        String[][] result = new String[this.yMax + Math.abs(this.yMin)][this.xMax + Math.abs(this.xMin)];

        for (Domino dm : this.dominos){
            if (dm.isRotated()) {
                result[dm.getY() + Math.abs(this.yMin) - 1][dm.getX() + Math.abs(this.xMin)] = String.valueOf(dm.getHalf1());
                result[dm.getY() + Math.abs(this.yMin)][dm.getX() + Math.abs(this.xMin)] = "-";
                result[dm.getY() + Math.abs(this.yMin) + 1][dm.getX() + Math.abs(this.xMin)] = String.valueOf(dm.getHalf2());
            } else {
                result[dm.getY() + Math.abs(this.yMin)][dm.getX() + Math.abs(this.xMin) + 1] = String.valueOf(dm.getHalf2());
                result[dm.getY() + Math.abs(this.yMin)][dm.getX() + Math.abs(this.xMin)] = "|";
                result[dm.getY() + Math.abs(this.yMin)][dm.getX() + Math.abs(this.xMin) - 1] = String.valueOf(dm.getHalf1());
            }
        }

        for (int i = 0; i < this.yMax + Math.abs(this.yMin); i++){
            for (int j = 0; j < this.xMax + Math.abs(this.xMin); j++){
                if (result[i][j] == null) System.out.print(' ');
                else System.out.print(result[i][j]);
            }
            System.out.println();
        }

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
