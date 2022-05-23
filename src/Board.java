import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Board {
    private final Node firstDomino;
    private int width; //2*28
    private int height; //3*28
    private List<Domino> dominos;
    private  LinkedList<Node> corners;
    private String print[][];
    private static class Node{
        private Node side1;
        private Node side2;
        private Node lat1;
        private Node lat2;
        private final Domino piece;

        /**
         *
         * @param piece
         */
        public Node(Domino piece){
            this.piece = piece;
        }

        public boolean isFull(){
            if(this.piece instanceof Pair){
                return side1 != null && side2 != null && lat1 != null && lat2 != null;
            } else {
                return side1 != null && side2 != null;
            }
        }
    }

    /**
     *
     * @param first //firstDomino
     */
    public Board(Domino first){
        this.firstDomino = new Node(first);
        this.width = 56;
        this.height = 84;
        this.dominos = new LinkedList<Domino>();
        this.corners = new LinkedList<>();
        this.corners.add(this.firstDomino);
        //this.print = new String [30][30];

    }

    /**
     *
     * @return
     */
    /*public void fillPrint(){
        for(int i = 0; i < print.length; i++){
            for(int j = 0; j < print[i].length; j++){
                print[i][j] = "   ";
            }
        }
    }
    public void printTurn(Domino a, int x, int y){
        this.print[x][y] =  a.getHalf1() + " " + a.getHalf2();
        this.print[15][15] = 7 + " " + 7;
        System.out.println(this.print[15][15]);
        for(int i = 0; i < print.length; i++){
            System.out.println();
            for(int j = 0; j < print[i].length; j++){
                System.out.print(this.print[i][j] + "  ");
            }
        }
    }*/
    public Domino getFirstDomino() {return firstDomino.piece;}

    /**
     *
     * @param piece
     * @param corner
     */
    public void addDominoToCorner(Domino piece, Domino corner){
        Node c = getNode(corner);
        if (c == null) return;

        if (c.piece instanceof Pair){
            if(c.lat1 == null) c.lat1 = new Node(piece);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {return super.toString();
    }

    public Iterable<Domino> leftSide() {
        LinkedList<Domino> itr = new LinkedList<>();
        sideListGenerator();
        return itr;
    }

    private void sideListGenerator(){

    }

    private Node getNode(Domino dm){
        int i = 0;
        for(Node nd: this.corners){
            if (nd.piece.compareTo(dm) > 0) return this.corners.remove(i);
            else i++;
        }
        return null;
    }

    public Iterable<Domino> oQueTuQuiseres(Node n){
        LinkedList<Domino> dominos = new LinkedList<>();
        oQueTuQuiseres(n, dominos);
        return dominos;
    }
    private void oQueTuQuiseres(Node n, LinkedList<Domino> list){
        if(n.side1 != null) oQueTuQuiseres(n.side1,list);
        list.add(n.piece);
    }
}
