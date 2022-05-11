import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DealerTest {

    @Test
    void giveHand() {
        Dealer dl = new Dealer();

        assertEquals(7, dl.giveHand().size());
        dl.giveHand();
        dl.giveHand();
        dl.giveHand();
        assertThrows(NullPointerException.class, dl::giveHand);
    }
}