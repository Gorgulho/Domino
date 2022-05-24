import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairTest {
    @Test
    void testconstructorPair(){
        Domino a = new Pair(6);
        assertEquals(6, a.getHalf1());
        assertEquals(6, a.getHalf2());
    }
}