public class Domino implements Comparable<Domino>{
    protected int x, y;
    protected int half1, half2;
    protected boolean rotated;

    public Domino(int half1, int half2, int x, int y){
        this.half1 = half1;
        this.half2 = half2;
        this.rotated = false;
        this.x = x;
        this.y = y;
    }

    public int getHalf1() {return this.half1;}

    public int getHalf2() {return this.half2;}

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


    public int sumPoints(){
        return (this.half1 + this.half2);
    }
}