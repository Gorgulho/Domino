import java.util.List;

public class Pair extends Domino{
    public Pair(int half) {
        super(half, half);
    }

    @Override
    public List<Side> canConnect(Domino other) {
        if(other.half1 != half1 && other.half2 != half1) return null;
        return List.of(Side.LEFT, Side.UP, Side.RIGHT, Side.DOWN);
    }

    @Override
    public void flip() {

    }
}
