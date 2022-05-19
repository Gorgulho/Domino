import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DominoTest {

    @Test
    void compareTo() {
        assertEquals(0, new Domino(1, 2).compareTo(new Domino(2, 1)));
        assertEquals(-1, new Domino(3, 2).compareTo(new Domino(2, 1)));
        assertEquals(-1, new Domino(3, 3).compareTo(new Domino(2, 2)));
    }

    @Test
    void getHalf1() {
        assertEquals(2, new Domino(2, 3).getHalf1());
    }

    @Test
    void getHalf2() {
        assertEquals(3, new Domino(2, 3).getHalf2());
    }
}