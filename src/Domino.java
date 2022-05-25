import java.util.List;

public abstract class Domino implements Comparable<Domino>{
    protected int x, y;
    protected int half1, half2;
    protected boolean rotated;
    //private boolean isPair;

    /**
     * By default, rotated is false, witch means, each domino is oriented horizontally
     * In case half1 == -1 and half2 == -1, it means we are creating an invalid domino, to block possible plays in the board
     * @param half1 value for half1 of the domino
     * @param half2 value for half2 of the domino
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

    /**
     *
     * @return value of half1 of the domino
     */
    public int getHalf1() {
        return this.half1;
    }

    /**
     *
     * @return value of half2 of the domino
     */
    public int getHalf2() {
        return this.half2;
    }

    /**
     * rotates domino from its previous state
     */
    public void rotate(){
        this.rotated = !this.rotated;
    }

    /**
     * Indicates whether the domino is rotated or not
     * @return true if the domino is rotated(vertical), otherwise false
     */
    public boolean isRotated(){
        return this.rotated;
    }

    /**
     *
     * @return true if values of half1 and half2 are equal, otherwise false
     */
    public boolean isPair() {
        return half1 == half2;
    }

    /**
     * Sets domino's x and y values to the parameters given
     * @param x new x value
     * @param y new y value
     */
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @return domino´s x value
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return domino´s y value
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param other domino the object is connecting to
     * @return list of possible sides of 'other' to which the object can connect
     */
    public abstract List<Side> canConnect(Domino other);

    /**
     * switches half1 and half2
     */
    public abstract void flip();

    /**
     *
     * @param p the object to be compared.
     * @return 0 if the dominoes are different and 1 if they are the same
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

    /**
     *
     * @return sum of values of half1 and half2
     */
    public int sumPoints(){
        return (this.half1 + this.half2);
    }
}