public class Board {

    private final Domino firstDomino;

    public Board(Domino first){
        this.firstDomino = new Pair(6);
    }

    public Domino getFirstDomino() {
        return firstDomino;
    }
}
