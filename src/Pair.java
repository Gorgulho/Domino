public class Pair extends Domino{
    /**
     *
     * @param half
     */
    public Pair (int half){
        if (half >= 0 && half <= 6) {
            this.half1 = half;
            this.half2 = half;
            this.x = 0;
            this.y = 0;
            this.rotated = false;
        } else System.exit(0);
    }
}
