import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {
    @Test

    void testContructorPiece(){
        Domino a = new Piece(3, 4);
        assertEquals(3, a.getHalf1());
        assertEquals(4, a.getHalf2());
    }

    @Test

    void testflip(){
        Domino a = new Piece(3, 4);
        a.flip();
        assertEquals(4, a.getHalf1());
        assertEquals(3, a.getHalf2());
    }
}