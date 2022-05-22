import java.util.LinkedList;
import java.util.List;

public class Board {
    private final Node firstDomino;
    private int width; //2*28
    private int height; //3*28
    private List<Domino> dominos;
    private  LinkedList<Domino> corners;
    private String print[][];
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
        this.corners = new LinkedList<>();
        this.print = new String [30][30];

    }

    /**
     *
     * @return
     */
    public void fillPrint(){
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
    }
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
    public String toString() {return super.toString();
    }
}
