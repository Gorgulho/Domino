import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class DealerTest {

    @Test
    void giveHand() throws NoMorePiecesToGive {
        Dealer dl = new Dealer();

        assertEquals(7, dl.giveHand().size());
        dl.giveHand();
        dl.giveHand();
        dl.giveHand();
        assertThrows(NoMorePiecesToGive.class, (Executable) dl.giveHand());
    }
}