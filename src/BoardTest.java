import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BoardTest {
    @Test
    void getFirstDomino(){
        Domino first = new Domino(6, 6);
        Board a = new Board(first, 57, 85);
        assertEquals(6, a.getFirstDomino().getHalf1());

        /*assertThrows(IllegalArgumentException.class, () -> {
            new Board(new Domino(5, 4), 56, 84);
        });*/
    }

    //@Test
    /*public void testfirstDomino() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Board(new Domino(5, 4), 56, 84);
        });*/
    //}
}