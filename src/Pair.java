public class Pair extends Domino{
    private Domino lat1;
    private Domino lat2;
    public Pair(int half){
        this.half1 = half;
        this.half2 = half;
        this.x = 0;
        this.y = 0;
        this.side1 = null;
        this.side2 = null;
        this.lat1 = null;
        this.lat2 = null;
        this.rotated = false;
    }

    public Domino getLat1() {
        return lat1;
    }

    public Domino getLat2() {
        return lat2;
    }

    public void setLat1(Domino l){
        this.lat1 = l;
    }

    public void setLat2(Domino l){
        this.lat2 = l;
    }
}
