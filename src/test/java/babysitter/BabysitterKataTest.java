package babysitter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


public class BabysitterKataTest {

    @Test
    public void payTestEndBeforeMidnight() throws Exception {
        assertEquals(60, BabysitterKata.income(5, 6, 12));
        assertEquals(48, BabysitterKata.income(6, 8, 11));
        assertEquals(48, BabysitterKata.income(5, 7, 10));
        assertEquals(40, BabysitterKata.income(7, 7, 12));
    }

    @Test
    public void payTestSameStartAndBedTime() throws Exception {
        assertEquals(56, BabysitterKata.income(5, 5, 12));
        assertEquals(48, BabysitterKata.income(6, 6, 12));
        assertEquals(40, BabysitterKata.income(7, 7, 12));
        assertEquals(32, BabysitterKata.income(8, 8, 12));
    }

    @Test
    public void payTestLateNight() throws Exception {
        assertEquals(124, BabysitterKata.income(5, 6, 4));
        assertEquals(108, BabysitterKata.income(5, 6, 3));
        assertEquals(80, BabysitterKata.income(6, 6, 2));
        assertEquals(60, BabysitterKata.income(7, 8, 1));
    }

    @Test
    public void noPay() throws Exception {
        assertEquals(0, BabysitterKata.income(5, 5, 5));
        assertEquals(0, BabysitterKata.income(12, 12, 12));
    }

    @Test
    public void notValidStartTimes() throws Exception {
        assertThrows(Exception.class, () -> BabysitterKata.income(3, 5, 12));
        assertThrows(Exception.class, () -> BabysitterKata.income(13, 5, 12));
    }

    @Test
    public void notValidBedTimes() throws Exception {
        assertThrows(Exception.class, () -> BabysitterKata.income(6, 5, 12));
        assertThrows(Exception.class, () -> BabysitterKata.income(7, 13, 1));
    }

    @Test
    public void notValidEndTimes() throws Exception {
        assertThrows(Exception.class, () -> BabysitterKata.income(6, 8, 5));
        assertThrows(Exception.class, () -> BabysitterKata.income(6, 8, 7));
    }

}
