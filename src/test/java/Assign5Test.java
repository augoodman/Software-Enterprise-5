package test.java;

import static org.junit.Assert.*;

import org.junit.Test;
import main.java.SampleClass;
public class Assign5Test {

    @Test
    public void simpleTest() {
        assertEquals(SampleClass.getTestResult(), 0);
    }

}
