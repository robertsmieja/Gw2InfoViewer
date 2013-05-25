/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gw2InfoViewer.models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Robert Smieja
 */
public class EventStateTest {

    public EventStateTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of values method, of class EventState.
     */
    @Test
    public void testValues() {
        EventState[] expResult = {EventState.Active,
            EventState.Success,
            EventState.Fail,
            EventState.Warmup,
            EventState.Preperation};

        EventState[] result = EventState.values();

        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class EventState.
     */
    @Test
    public void testValueOf() {
        String name = "Warmup";
        EventState expResult = EventState.Warmup;

        EventState result = EventState.valueOf(name);

        assertEquals(expResult, result);
    }
}