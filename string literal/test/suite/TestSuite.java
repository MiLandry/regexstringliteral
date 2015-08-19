package suite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import testClasses.ExtractTest;
import testClasses.SwapTest;

/**
 * JUnit Suite Test
 * @author Michael Landry
 *
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ExtractTest.class,
        SwapTest.class
})
public class TestSuite {
}
