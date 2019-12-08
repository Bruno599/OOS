package Aufgabe1;

//import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//import static org.junit.Assert.*;

//import junit.framework.TestCase;

public class BenutzerTest { //extends TestCase{

    private Benutzer b1, b2, b3;

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {

        b1 = new Benutzer("user", "123456".toCharArray());
        b2 = new Benutzer("user", "123456".toCharArray());
        b3 = new Benutzer("user2", "654321".toCharArray());
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Testen der Equals Methode
     * @see Benutzer equals
     */
    @Test
    public void testEquals() {

        Assert.assertEquals(b1, b2);
        Assert.assertNotEquals(b2, b3);
    }

}