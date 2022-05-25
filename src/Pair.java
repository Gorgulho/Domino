import java.util.List;

public class Pair extends Domino{
    public Pair(int half) {
        super(half, half);
    }

    /**
     *
     * @param other domino the object is connecting to
     * @return list of possible sides of 'other' to which the object can connect
     */
    @Override
    public List<Side> canConnect(Domino other) {
        if(other.half1 != half1 && other.half2 != half1) return null;
        return List.of(Side.LEFT, Side.UP, Side.RIGHT, Side.DOWN);
    }

    /**
     * since half1 and hal2 are equal, the domino isn´t required to flip in order to be connected
     */
    @Override
    public void flip() {

    }
}
