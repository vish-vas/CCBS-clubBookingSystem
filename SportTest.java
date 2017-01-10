

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SportTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SportTest
{
    /**
     * Default constructor for test class SportTest
     */
    public SportTest()
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
    public void testSportSetters()
    {
        Sport sport1 = new Sport("Tennis", 12.4, 22.3, 5.4, 120);
        assertEquals("Tennis", sport1.getSportName());
        assertEquals(120, sport1.getSportTimeLimit());
    }
}

