package babysitter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


public class BabysitterKataTest {

    @Test
    public void payTestEndBeforeMidnight() throws Exception {
        assertEquals(48, BabysitterKata.income(6, Time.PM, 8, Time.PM, 11, Time.PM));
        assertEquals(52, BabysitterKata.income(5, Time.PM, 8, Time.PM, 10, Time.PM));
        assertEquals(36, BabysitterKata.income(5, Time.PM, 6, Time.PM, 9, Time.PM));
        assertEquals(36, BabysitterKata.income(5, Time.PM, 8, Time.PM, 8, Time.PM));
    }

    @Test
    public void payTestSameStartAndBedTime() throws Exception {
        assertEquals(56, BabysitterKata.income(5, Time.PM, 5, Time.PM, 12, Time.AM));
        assertEquals(48, BabysitterKata.income(6, Time.PM, 6, Time.PM, 12, Time.AM));
        assertEquals(40, BabysitterKata.income(7, Time.PM, 7, Time.PM, 12, Time.AM));
        assertEquals(32, BabysitterKata.income(8, Time.PM, 8, Time.PM, 12, Time.AM));
    }

    @Test
    public void payTestSameBedTimeAndEndTime() throws Exception {
        assertEquals(84, BabysitterKata.income(5, Time.PM, 12, Time.AM, 12, Time.AM));
        assertEquals(24, BabysitterKata.income(6, Time.PM, 8, Time.PM, 8, Time.PM));
        assertEquals(36, BabysitterKata.income(7, Time.PM, 10, Time.PM, 10, Time.PM));
    }

    @Test
    public void payTestLateNight() throws Exception {
        assertEquals(124, BabysitterKata.income(5, Time.PM, 6, Time.PM, 4, Time.AM));
        assertEquals(108, BabysitterKata.income(5, Time.PM, 6, Time.PM, 3, Time.AM));
        assertEquals(80, BabysitterKata.income(6, Time.PM, 6, Time.PM, 2, Time.AM));
        assertEquals(60, BabysitterKata.income(7, Time.PM, 8, Time.PM, 1, Time.AM));
    }

    @Test
    public void notValidStartTimes() {
        assertThrows(Exception.class, () -> BabysitterKata.income(7, Time.AM, 5, Time.PM, 12, Time.AM));
        assertThrows(Exception.class, () -> BabysitterKata.income(10, Time.AM, 5, Time.PM, 12, Time.AM));
        assertThrows(Exception.class, () -> BabysitterKata.income(3, Time.PM, 5, Time.PM, 12, Time.AM));
        assertThrows(Exception.class, () -> BabysitterKata.income(13, Time.PM, 5, Time.PM, 12, Time.AM));
        assertThrows(Exception.class, () -> BabysitterKata.income(12, Time.PM, 5, Time.PM, 12, Time.AM));
        assertThrows(Exception.class, () -> BabysitterKata.income(-1, Time.PM, 5, Time.PM, 12, Time.AM));
    }

    @Test
    public void notValidBedTimes() {
        assertThrows(Exception.class, () -> BabysitterKata.income(7, Time.PM, 5, Time.PM, 4, Time.AM));
        assertThrows(Exception.class, () -> BabysitterKata.income(5, Time.PM, 13, Time.PM, 4, Time.AM));
        assertThrows(Exception.class, () -> BabysitterKata.income(5, Time.PM, 12, Time.PM, 4, Time.AM));
        assertThrows(Exception.class, () -> BabysitterKata.income(5, Time.PM, 10, Time.AM, 4, Time.AM));
        assertThrows(Exception.class, () -> BabysitterKata.income(5, Time.PM, -1, Time.PM, 4, Time.AM));
    }

    @Test
    public void notValidEndTimes() {
        assertThrows(Exception.class, () -> BabysitterKata.income(5, Time.PM, 5, Time.PM, 5, Time.AM));
        assertThrows(Exception.class, () -> BabysitterKata.income(5, Time.PM, 5, Time.PM, 13, Time.PM));
        assertThrows(Exception.class, () -> BabysitterKata.income(5, Time.PM, 5, Time.PM, 12, Time.PM));
        assertThrows(Exception.class, () -> BabysitterKata.income(5, Time.PM, 5, Time.PM, 4, Time.PM));
        assertThrows(Exception.class, () -> BabysitterKata.income(5, Time.PM, 9, Time.PM, 8, Time.PM));
        assertThrows(Exception.class, () -> BabysitterKata.income(5, Time.PM, 9, Time.PM, -1, Time.PM));
    }

    @Test
    public void noPayException() {
        assertThrows(Exception.class, () -> BabysitterKata.income(6, Time.PM, 6, Time.PM, 6, Time.PM));
        assertThrows(Exception.class, () -> BabysitterKata.income(7, Time.PM, 7, Time.PM, 7, Time.PM));
        assertThrows(Exception.class, () -> BabysitterKata.income(12, Time.AM, 12, Time.AM, 12, Time.AM));
    }

}
