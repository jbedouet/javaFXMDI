package br.com.supremeforever.mdi;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    br.com.supremeforever.mdi.MDICanvasTest.class,
    br.com.supremeforever.mdi.PlacementStrategy.DefaultTest.class
})
public class SupremeForeverMdiTestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
}
