import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BoardTest {
    @Test
    void getFirstDomino(){
        Domino first = new Pair(6);
        Board a = new Board(first);
        assertEquals(6, a.getFirstDomino().getHalf1());
        assertEquals(6, a.getFirstDomino().getHalf2());
    }

}