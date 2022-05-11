public class Board {

    private final Domino firstDomino;

    public Board(){
        this.firstDomino = new Pair(6);
    }

    public Domino getFirstDomino() {
        return firstDomino;
    }
}
