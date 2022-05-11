import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DominoTest {

    @Test
    void rotate() {

    }

    @Test
    void compareTo() {
    }

    Domino a = new Piece(2, 3);
    @Test
    void getHalf1() {
        assertEquals(2, a.getHalf1());
    }

    @Test
    void getHalf2() {
        assertEquals(3, a.getHalf2());
    }
}