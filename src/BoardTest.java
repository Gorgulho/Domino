import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BoardTest {
    @Test
    void getFirstDomino(){
        Domino first = new Pair(6);
        Board a = new Board(first,57, 85);
        assertEquals(6, a.getFirstDomino().getHalf1());
        assertEquals(6, a.getFirstDomino().getHalf2());
    }

    //@Test
    /*public void testfirstDomino() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Board(new Domino(5, 4), 56, 84);
        });*/
    //}
}