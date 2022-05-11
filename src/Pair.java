public class Pair extends Domino{
    private Domino lat1, lat2;
    public Pair(int half){
        this.half1 = half;
        this.half2 = half;
        this.x = 0;
        this.y = 0;
        this.side1 = null;
        this.side2 = null;
        this.lat1 = null;
        this.lat2 = null;
        this.flip = false;
    }
}
