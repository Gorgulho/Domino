public class Board {

    private static class Node {
        private Domino side1;
        private Domino side2;
        private Domino lat1;
        private Domino lat2;
        private final Domino piece;
        private boolean isPair;
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
    private final Node firstDomino;

    public Board(Domino first){
        this.firstDomino = new Node(first);
    }

    public Domino getFirstDomino() {
        return firstDomino.piece;
    }
}
