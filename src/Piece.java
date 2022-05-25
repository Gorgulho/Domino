import java.util.List;

public class Piece extends Domino{
    public Piece(int half1, int half2) {
        super(half1, half2);
    }

    /**
     *
     * @param other domino the object is connecting to
     * @return list of possible sides of 'other' to which the object can connect
     */
    @Override
    public List<Side> canConnect(Domino other) {
        if((this.half1 == other.half1 || this.half1 == other.half2) || (this.half2 == other.half1 || this.half2 == other.half2)) return this.isRotated() ? List.of(Side.UP, Side.DOWN) : List.of(Side.LEFT, Side.RIGHT);
        return null;
    }

    /**
     * switches half1 and half2
     */
    @Override
    public void flip(){
        int temp = this.half1;
        this.half1 = this.half2;
        this.half2 = temp;
    }
}
