public class Piece extends Domino{

    /**
     * @param h1
     * @param h2
     */
    public Piece(int h1, int h2){
        if (h1 != h2 && (h1 >= 0 && h1 <= 6) && (h2 >= 0 && h2 <= 6)) {
            this.half1 = h1;
            this.half2 = h2;
            this.x = 0;
            this.y = 0;
            this.rotated = false;
        } else System.exit(0);
    }

    /**
     *
     */
    public void switchSides(){

    }
}
