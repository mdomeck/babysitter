package babysitter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


public class BabysitterKataTest {

    @Test
    public void payTestEndBeforeMidnight() throws Exception {
        assertEquals(60, BabysitterKata.income(5,"PM", 6,"PM", 12, "AM"));
        assertEquals(48, BabysitterKata.income(6,"PM",8, "PM", 11, "PM"));
        assertEquals(52, BabysitterKata.income(5, "PM", 8, "PM", 10, "PM"));
    }

    @Test
    public void payTestSameStartAndBedTime() throws Exception {
        assertEquals(56, BabysitterKata.income(5, "PM", 5, "PM", 12, "AM"));
        assertEquals(48, BabysitterKata.income(6, "PM", 6, "PM", 12, "AM"));
        assertEquals(40, BabysitterKata.income(7, "PM", 7, "PM", 12, "AM"));
        assertEquals(32, BabysitterKata.income(8, "PM", 8, "PM", 12, "AM"));
    }

    @Test
    public void payTestSameBedTimeAndEndTime() throws Exception {
        assertEquals(84, BabysitterKata.income(5, "PM", 12, "AM", 12, "AM"));
        assertEquals(24, BabysitterKata.income(6, "PM", 8, "PM", 8, "PM"));
        assertEquals(36, BabysitterKata.income(7, "PM", 10, "PM", 10, "PM"));
    }

    @Test
    public void payTestLateNight() throws Exception {
        assertEquals(124, BabysitterKata.income(5, "PM", 6, "PM", 4, "AM"));
        assertEquals(108, BabysitterKata.income(5, "PM", 6, "PM", 3, "AM"));
        assertEquals(80, BabysitterKata.income(6, "PM", 6, "PM", 2, "AM"));
        assertEquals(60, BabysitterKata.income(7, "PM", 8, "PM", 1, "AM"));
    }

    @Test
    public void notValidStartTimes() {
        assertThrows(Exception.class, () -> BabysitterKata.income(7, "AM", 5, "PM", 12, "AM"));
        assertThrows(Exception.class, () -> BabysitterKata.income(10, "AM", 5, "PM", 12, "AM"));
        assertThrows(Exception.class, () -> BabysitterKata.income(3, "PM", 5, "PM", 12, "AM"));
        assertThrows(Exception.class, () -> BabysitterKata.income(13, "PM", 5, "PM", 12, "AM"));
        assertThrows(Exception.class, () -> BabysitterKata.income(12, "PM", 5, "PM", 12, "AM"));
    }

    @Test
    public void notValidBedTimes() {
        assertThrows(Exception.class, () -> BabysitterKata.income(7, "PM", 5, "PM", 4, "AM"));
        assertThrows(Exception.class, () -> BabysitterKata.income(5, "PM", 13, "PM", 4, "AM"));
        assertThrows(Exception.class, () -> BabysitterKata.income(5, "PM", 12, "PM", 4, "AM"));
        assertThrows(Exception.class, () -> BabysitterKata.income(12, "PM", 10, "AM", 4, "AM"));
    }

    @Test
    public void notValidEndTimes() {
        assertThrows(Exception.class, () -> BabysitterKata.income(5, "PM", 5, "PM", 5, "AM"));
        assertThrows(Exception.class, () -> BabysitterKata.income(5, "PM", 5, "PM", 13, "PM"));
        assertThrows(Exception.class, () -> BabysitterKata.income(5, "PM", 5, "PM", 12, "PM"));
        assertThrows(Exception.class, () -> BabysitterKata.income(5, "PM", 9, "PM", 4, "PM"));
        assertThrows(Exception.class, () -> BabysitterKata.income(5, "PM", 9, "PM", 8, "PM"));
    }

    @Test
    public void noPayException() {
        assertThrows(Exception.class, () -> BabysitterKata.income(6, "PM", 6, "PM", 6, "PM"));
        assertThrows(Exception.class, () -> BabysitterKata.income(7, "PM", 7, "PM", 7, "PM"));
        assertThrows(Exception.class, () -> BabysitterKata.income(12, "PM", 12, "PM", 12, "PM"));
    }

}
