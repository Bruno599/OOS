

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import junit.framework.Test;
import junit.framework.TestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({BenutzerTest.class, BenutzerVerwaltungAdminTest.class})
public class Tests {
    public static void benutzerTestSuite() {
        //TestSuite benutzerTestSuite = new TestSuite("Test Praktikum 3");
        //benutzerTestSuite.addTestSuite(BenutzerVerwaltungAdminTest.class);
        //benutzerTestSuite.addTestSuite(BenutzerTest.class);

        JUnitCore.runClasses(Tests.class);

        //return benutzerTestSuite;
    }
}
