public class Domino implements Comparable<Domino>{
    private int x, y;
    private int half1, half2;
    private boolean rotated;
    private boolean isPair;

    public Domino(int half1, int half2){
        if ((half1 >= 0 && half1 <= 6) && (half2 >= 0 && half2 <= 6)) {
            this.isPair = half1 == half2;

            this.half1 = half1;
            this.half2 = half2;
            this.rotated = false;
            this.x = 0;
            this.y = 0;
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

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

    public boolean isPair() {
        return isPair;
    }
}