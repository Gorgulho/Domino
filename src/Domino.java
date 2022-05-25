import java.util.List;

public abstract class Domino implements Comparable<Domino>{
    protected int x, y;
    protected int half1, half2;
    protected boolean rotated;
    //private boolean isPair;

    /**
     * By default, rotated is false, witch means, each piece is oriented horizontaly
     * In case half1 == -1 and half2 == -1, it means we are creating an invalid piece, to block possible plays in the board
     * @param half1 value for half1 of the piece
     * @param half2 value for half2 of the piece
     */
    public Domino(int half1, int half2){
        if ((half1 >= 0 && half1 <= 6) && (half2 >= 0 && half2 <= 6)) {
            this.half1 = half1;
            this.half2 = half2;
            this.rotated = false;
            this.x = 0;
            this.y = 0;
        } else if (half1 == -1 && half2 == -1) {
            this.half1 = half1;
            this.half2 = half2;
        } else System.exit(0);
    }

    public int getHalf1() {
        return this.half1;
    }

    public int getHalf2() {
        return this.half2;
    }

    public void rotate(){
        this.rotated = !this.rotated;
    }

    public boolean isRotated(){
        return this.rotated;
    }

    public boolean isPair() {
        return half1 == half2;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract List<Side> canConnect(Domino other);

    public abstract void flip();

    /**
     *
     * @param p the object to be compared.
     * @return 0 if the pieces are diferent and 1 if the pieces are the same
     */
    @Override
    public int compareTo(Domino p) {
        boolean firstComp = (p.getHalf1() == this.getHalf1()) && (p.getHalf2() == this.getHalf2());
        boolean secondComp = (p.getHalf1() == this.getHalf2()) && (p.getHalf2() == this.getHalf1());
        if(firstComp || secondComp) {
            return 1;
        }
        return 0;
    }

    /**
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "<" + this.half1 + "|" + this.half2 + ">";
    }


    public int sumPoints(){
        return (this.half1 + this.half2);
    }
}