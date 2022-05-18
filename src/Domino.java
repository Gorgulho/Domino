public class Domino implements Comparable<Domino>{
    protected int x, y;
    protected int half1, half2;
    protected boolean rotated;

    /**
     *
     * @return
     */
    public int getHalf1() {
        return half1;
    }

    /**
     *
     * @return
     */
    public int getHalf2() {
        return half2;
    }

    /**
     *
     */
    public void rotate(){
        this.rotated = !this.rotated;
    }

    /**
     *
     * @return
     */
    public boolean isRotated(){
        return this.rotated;
    }

    /**
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     *
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Domino o) {
        return 0;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "<" + this.half1 + "|" + this.half2 + ">";
    }

    /**
     *
     * @return
     */
    public int sumPoints(){
        return 0;
    }
}