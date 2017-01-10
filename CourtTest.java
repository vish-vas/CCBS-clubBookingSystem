

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CourtTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CourtTest
{
    /**
     * Default constructor for test class CourtTest
     */
    public CourtTest()
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
    public void testCourtSetters()
    {
        Court court1 = new Court("24");
        assertEquals("24", court1.getCourtNumber());
    }
}

