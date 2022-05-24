import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DominoTest {

    @Test
    void testcompareTo() {
        assertEquals(1, new Piece(1, 2).compareTo(new Piece(2, 1)));
        assertEquals(0, new Piece(3, 2).compareTo(new Piece(2, 1)));
        assertEquals(0, new Pair(3).compareTo(new Pair(2)));
    }

    @Test
    void testgetHalf1() {
        assertEquals(2, new Piece(2, 3).getHalf1());
    }

    @Test
    void testgetHalf2() {
        assertEquals(3, new Piece(2, 3).getHalf2());
    }

    @Test
    void testisRotated(){
        Domino a = new Piece(4, 5);
        assertFalse(a.isRotated());
        a.rotate();
        assertTrue(a.isRotated());
    }

    @Test
    void testisPair(){
        Domino a = new Pair(4);
        Domino b = new Piece(5, 4);
        assertTrue(a.isPair());
        assertFalse(b.isPair());
    }

    @Test
    void testsumPoints(){
        Domino a = new Pair(6);
        Domino b = new Piece(0, 0);
        assertEquals(12, a.sumPoints());
        assertEquals(0, b.sumPoints());
    }
}