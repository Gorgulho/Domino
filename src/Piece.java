public class Piece extends Domino{
    public Piece(int half1, int half2) {
        super(half1, half2);
    }

    public void flip(){
        int temp = this.half1;
        this.half1 = this.half2;
        this.half2 = temp;
    }
}
