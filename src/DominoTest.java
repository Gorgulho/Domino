import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DominoTest {

    @Test
    void compareTo() {
        assertEquals(0, new Piece(1, 2).compareTo(new Piece(2, 1)));
        assertEquals(-1, new Piece(3, 2).compareTo(new Piece(2, 1)));
        assertEquals(-1, new Pair(3).compareTo(new Pair(2)));
    }

    @Test
    void getHalf1() {
        assertEquals(2, new Piece(2, 3).getHalf1());
    }

    @Test
    void getHalf2() {
        assertEquals(3, new Piece(2, 3).getHalf2());
    }
}