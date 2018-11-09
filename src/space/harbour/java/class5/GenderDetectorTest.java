package space.harbour.java.class5;

import junit.framework.TestCase;

import static org.junit.Assert.*;

public class GenderDetectorTest extends TestCase {
    GenderDetector gDetector;

    @org.junit.Before
    public void setUp() throws Exception {
        super.setUp();
        gDetector = new GenderDetector();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        gDetector = null;
    }

    @org.junit.Test
    public void testDetectMaleGenderByName() {
        String gender = gDetector.detectGenderByName("John");
        assertEquals("male", gender);
    }

    @org.junit.Test
    public void testDetectFemaleGenderByName() {
        String gender = gDetector.detectGenderByName("Sabrina");
        assertEquals("female", gender);
    }
}