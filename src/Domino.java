public class Domino implements Comparable<Domino>{
    protected int x, y;
    protected int half1, half2;
    protected Domino side1, side2;
    protected boolean rotated;

    public int getHalf1() {
        return half1;
    }

    public int getHalf2() {
        return half2;
    }

    public void rotate(){
        this.rotated = !this.rotated;
    }

    public boolean isRotated(){
        return this.rotated;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int compareTo(Domino o) {
        return 0;
    }

    @Override
    public String toString() {
        return "<" + this.half1 + "|" + this.half2 + ">";
    }
}