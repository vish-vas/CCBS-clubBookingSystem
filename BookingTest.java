

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BookingTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BookingTest
{
    /**
     * Default constructor for test class BookingTest
     */
    public BookingTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testBookingDetailsSetter()
    {
        Booking booking1 = new Booking(900, 60);
        assertEquals(900, booking1.getBookingStartTime());
        assertEquals(60, booking1.getBookingDuration());
    }
}

