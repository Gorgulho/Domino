public class Board {

    private static class Node {
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

    /**
     *
     * @param first
     */
    public Board(Domino first){
        this.firstDomino = new Node(first);
    }

    /**
     *
     * @return
     */
    public Domino getFirstDomino() {
        return firstDomino.piece;
    }

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
    public String toString() {
        return super.toString();
    }
}
