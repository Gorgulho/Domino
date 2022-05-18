import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BoardTest {
    @Test
    void getFirstDomino(){
        Domino first = new Pair(6);
        Board a = new Board(first, 20, 20);
        assertEquals(6, a.getFirstDomino().getHalf1());

        assertThrows(IllegalArgumentException.class, () -> {
            new Board(new Piece(5, 4), 20, 20);
        });
    }

    /*@Test
    public void testfirstDomino() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Board(new Domino(5, 4));
        });
    }*/
}