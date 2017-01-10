

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MemberTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MemberTest
{
    /**
     * Default constructor for test class MemberTest
     */
    public MemberTest()
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
    public void testMemberDetailSetters()
    {
        Member member1 = new Member("123", "Vova", true);
        assertEquals("Vova", member1.getMemberName());
        assertEquals("123", member1.getMemberNumber());
        assertEquals(true, member1.getMemberFinancial());
    }
}

