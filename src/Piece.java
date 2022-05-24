import java.util.List;

public class Piece extends Domino{
    public Piece(int half1, int half2) {
        super(half1, half2);
    }

    @Override
    public List<Side> canConnect(Domino other) {
        if(other.half1 == half1 || other.half2 == half1) return List.of(Side.LEFT);
        if(other.half1 == half2 || other.half2 == half2) return List.of(Side.RIGHT);
        if(this.isRotated()){
            if(other.half1 == half1 || other.half2 == half1) return List.of(Side.UP);
            if(other.half1 == half2 || other.half2 == half2) return List.of(Side.DOWN);
        }
        //TODO: corrigir o return deste metodo, para dar o return correto consuante a rotação da peça
        return null;
    }

    public void flip(){
        int temp = this.half1;
        this.half1 = this.half2;
        this.half2 = temp;
    }
}
