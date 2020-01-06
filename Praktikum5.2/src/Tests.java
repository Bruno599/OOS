

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import prak4client.BenutzerVerwaltungAdminTest;
import prak4gemklassen.BenutzerTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({BenutzerTest.class, BenutzerVerwaltungAdminTest.class})
public class Tests {
    public static void benutzerTestSuite() {
        //TestSuite benutzerTestSuite = new TestSuite("Test Praktikum 3");
        //benutzerTestSuite.addTestSuite(prak4client.BenutzerVerwaltungAdminTest.class);
        //benutzerTestSuite.addTestSuite(prak4gemklassen.BenutzerTest.class);

        JUnitCore.runClasses(Tests.class);

        //return benutzerTestSuite;
    }
}
