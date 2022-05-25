import java.util.ArrayList;
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
    public boolean addDominoToCorner(Domino piece, Domino corner) {
        boolean canPlace = false;

        Node c = getNode(corner);
        if (c == null) return false;

        List<Side> sides = this.canConectNode(piece, c);

        if (sides == null) return false;

        Node newPiece = new Node(piece);

        for (Side s : sides) {
            if (c.left == null && s == Side.LEFT) {
                assert c.piece.isPair() || !c.piece.isRotated();

                if (newPiece.piece.isPair()) newPiece.piece.rotate();
                else if (newPiece.piece.getHalf1() == c.piece.getHalf1()) newPiece.piece.flip();

                if (!c.piece.isRotated()) {
                    if (newPiece.piece.isRotated()) newPiece.piece.setXY(c.piece.getX() - 2, c.piece.getY());
                    else newPiece.piece.setXY(c.piece.getX() - 3, c.piece.getY());
                } else {
                    newPiece.piece.setXY(c.piece.getX() - 2, c.piece.getY());
                }

                if (this.calculateColision(newPiece.piece)){
                    c.left = new Node(new Pair(-1));
                } else {
                    c.left = newPiece;
                    newPiece.right = c;
                    canPlace = true;
                    break;
                }
            } else if (c.up == null && s == Side.UP) {
                assert c.piece.isPair() || c.piece.isRotated();

                if (!newPiece.piece.isPair()) newPiece.piece.rotate();

                if (newPiece.piece.getHalf1() == c.piece.getHalf1()) newPiece.piece.flip();

                if (!c.piece.isRotated()) {
                    newPiece.piece.setXY(c.piece.getX(), c.piece.getY() - 2);
                } else {
                    if (newPiece.piece.isRotated()) newPiece.piece.setXY(c.piece.getX(), c.piece.getY() - 3);
                    else newPiece.piece.setXY(c.piece.getX(), c.piece.getY() - 2);
                }

                if (this.calculateColision(newPiece.piece)){
                    c.up = new Node(new Pair(-1));
                } else {
                    c.up = newPiece;
                    newPiece.down = c;
                    canPlace = true;
                    break;
                }

                break;
            } else if (c.right == null && s == Side.RIGHT) {
                assert c.piece.isPair() || !c.piece.isRotated();

                if (newPiece.piece.isPair()) newPiece.piece.rotate();
                else if (newPiece.piece.getHalf2() == c.piece.getHalf2()) newPiece.piece.flip();

                if (!c.piece.isRotated()) {
                    if (newPiece.piece.isRotated()) newPiece.piece.setXY(c.piece.getX() + 2, c.piece.getY());
                    else newPiece.piece.setXY(c.piece.getX() + 3, c.piece.getY());
                } else {
                    newPiece.piece.setXY(c.piece.getX() + 2, c.piece.getY());
                }

                if (this.calculateColision(newPiece.piece)){
                    c.right = new Node(new Pair(-1));
                } else {
                    c.right = newPiece;
                    newPiece.left = c;
                    canPlace = true;
                    break;
                }

                break;
            } else if (c.down == null && s == Side.DOWN) {
                assert c.piece.isPair() || c.piece.isRotated();

                if (!newPiece.piece.isPair()) newPiece.piece.rotate();

                if (newPiece.piece.getHalf2() == c.piece.getHalf2()) newPiece.piece.flip();

                if (!c.piece.isRotated()) {
                    newPiece.piece.setXY(c.piece.getX(), c.piece.getY() + 2);
                } else {
                    if (newPiece.piece.isRotated()) newPiece.piece.setXY(c.piece.getX(), c.piece.getY() + 3);
                    else newPiece.piece.setXY(c.piece.getX(), c.piece.getY() + 2);
                }

                if (this.calculateColision(newPiece.piece)){
                    c.down = new Node(new Pair(-1));
                } else {
                    c.down = newPiece;
                    newPiece.up = c;
                    canPlace = true;
                    break;
                }

                break;
            }
        }

        if (canPlace) {
            this.dominos.add(newPiece.piece);

        }
        updateMinMaxCoordinates(newPiece);
        if (!c.isFull()) this.corners.add(c);
        if (!newPiece.isFull()) this.corners.add(newPiece);



        return canPlace;
    }

    public boolean calculateColision(Domino piece) {
        if(piece.isRotated()){
            if(Math.abs(piece.getX()) > width/2 || Math.abs(piece.getY())+1 > height/2) return true;
        }
        else{
            if(Math.abs(piece.getX())+1 > width/2 || Math.abs(piece.getY()) > height/2) return true;
        }

        String c1, c2, c3, dm1, dm2, dm3;
        if (piece.isRotated()) {
            c1 = piece.getX() + "" + (piece.getY() - 1);
            c2 = piece.getX() + "" + piece.getY();
            c3 = piece.getX() + "" + (piece.getY() + 1);
        } else {
            c1 = (piece.getX() + 1) + "" + piece.getY();
            c2 = piece.getX() + "" + piece.getY();
            c3 = (piece.getX() - 1) + "" + piece.getY();
        }

        for (Domino dm : this.dominos) {
            if (dm.isRotated()) {
                dm1 = dm.getX() + "" + (dm.getY() - 1);
                dm2 = dm.getX() + "" + dm.getY();
                dm3 = dm.getX() + "" + (dm.getY() + 1);
            } else {
                dm1 = (dm.getX() + 1) + "" + dm.getY();
                dm2 = dm.getX() + "" + dm.getY();
                dm3 = (dm.getX() - 1) + "" + dm.getY();
            }
            if (c1.equals(dm1) || c1.equals(dm2) || c1.equals(dm3)) return true;
            if (c2.equals(dm1) || c2.equals(dm2) || c2.equals(dm3)) return true;
            if (c3.equals(dm1) || c3.equals(dm2) || c3.equals(dm3)) return true;
        }
        return false;
    }

    private void updateMinMaxCoordinates(Node no) {
        int x = no.piece.getX();
        int y = no.piece.getY();

        if (x <= this.xMin) this.xMin = x - 2;
        if (x >= this.xMax) this.xMax = x + 2;

        if (y <= this.yMin) this.yMin = y - 2;
        if (y >= this.yMax) this.yMax = y + 2;
    }

    public void boardState() {
        String[][] result = new String[this.yMax + Math.abs(this.yMin)][this.xMax + Math.abs(this.xMin)];

        for (Domino dm : this.dominos) {
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

        for (int i = 0; i < this.yMax + Math.abs(this.yMin); i++) {
            for (int j = 0; j < this.xMax + Math.abs(this.xMin); j++) {
                if (result[i][j] == null) System.out.print(' ');
                else System.out.print(result[i][j]);
            }
            System.out.println();
        }

    }

    public LinkedList<Domino> getCornersDomino() {
        LinkedList<Domino> result = new LinkedList<>();
        for (Node n : this.corners) {
            result.add(n.piece);
        }
        return result;
    }

    public List<Side> canConectNode(Domino piece, Domino corner) {
        Node c = this.getNode(corner);
        List<Side> result = this.canConectNode(piece, c);
        this.corners.add(c);
        return result;
    }

    public List<Side> canConectNode(Domino piece, Node corner) {
        List<Side> sidesCorner = corner.piece.canConnect(piece);

        List<Side> result = new ArrayList<>();
        if (sidesCorner.size() == 0) return null;

        for (Side s : sidesCorner) {
            if (corner.left == null && s == Side.LEFT) {
                if (piece.isPair() && piece.getHalf1() == corner.piece.getHalf1()) {
                    result.add(Side.LEFT);
                } else if ((!piece.isPair() || corner.piece.isRotated()) && (piece.getHalf1() == corner.piece.getHalf1() || piece.getHalf2() == corner.piece.getHalf1())) {
                    result.add(Side.LEFT);
                }
            } else if (corner.up == null && s == Side.UP) {
                if (corner.piece.getHalf1() == piece.getHalf1() || corner.piece.getHalf1() == piece.getHalf2()) {
                    result.add(Side.UP);
                }
            } else if (corner.right == null && s == Side.RIGHT) {
                if (piece.isPair() && piece.getHalf1() == corner.piece.getHalf2()) {
                    result.add(Side.RIGHT);
                } else if ((!piece.isPair() || corner.piece.isRotated()) && (piece.getHalf1() == corner.piece.getHalf2() || piece.getHalf2() == corner.piece.getHalf2())) {
                    result.add(Side.RIGHT);
                }
            } else if (corner.down == null && s == Side.DOWN) {
                if (corner.piece.getHalf2() == piece.getHalf1() || corner.piece.getHalf2() == piece.getHalf2()) {
                    result.add(Side.DOWN);
                }
            }
        }

        return result;
    }

    /**
     * @return
     */

    private Node getNode(Domino dm) {
        int i = 0;
        for (Node nd : this.corners) {
            if (nd.piece.compareTo(dm) > 0) return this.corners.remove(i);
            else i++;
        }
        return null;
    }
}
