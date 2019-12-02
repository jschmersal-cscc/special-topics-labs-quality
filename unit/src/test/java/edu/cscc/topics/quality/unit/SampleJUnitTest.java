package edu.cscc.topics.quality.unit;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SampleJUnitTest {
    @Test
    public void simpleTest() {
        // JUnit has some convenience methods (like assertEquals) that compares to objects and gives a reasonable
        // error message if they are not (and fails the test)
        assertEquals("a.b", new SimpleJoiner().join(".", "a", "b"));
    }

    @Test
    public void shouldSkipNulls() {

        assertEquals("a.b", new SimpleJoiner().join(".", "a", null, "b"));
    }

    @Test
    public void thisShouldRunAsATest() {
        assertTrue(new SimpleJoiner().join("|", "a", "b").length() == 3);
    }

    @Test
    public void thisShouldSkipAllNullErrors() {
        assertEquals("a.", new SimpleJoiner().join(".", "a", null));
    }
}
