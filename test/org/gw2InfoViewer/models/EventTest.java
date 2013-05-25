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
public class EventTest {
    
    public EventTest() {
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
     * Test of getEventName method, of class Event.
     */
    @Test
    public void testGetEventName() {
        System.out.println("getEventName");
        Event instance = new Event();
        String expResult = "";
        String result = instance.getEventName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEventName method, of class Event.
     */
    @Test
    public void testSetEventName() {
        System.out.println("setEventName");
        String eventName = "";
        Event instance = new Event();
        instance.setEventName(eventName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWorldId method, of class Event.
     */
    @Test
    public void testGetWorldId() {
        System.out.println("getWorldId");
        Event instance = new Event();
        Integer expResult = null;
        Integer result = instance.getWorldId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWorldId method, of class Event.
     */
    @Test
    public void testSetWorldId() {
        System.out.println("setWorldId");
        Integer worldId = null;
        Event instance = new Event();
        instance.setWorldId(worldId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMapId method, of class Event.
     */
    @Test
    public void testGetMapId() {
        System.out.println("getMapId");
        Event instance = new Event();
        Integer expResult = null;
        Integer result = instance.getMapId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMapId method, of class Event.
     */
    @Test
    public void testSetMapId() {
        System.out.println("setMapId");
        Integer mapId = null;
        Event instance = new Event();
        instance.setMapId(mapId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEventId method, of class Event.
     */
    @Test
    public void testGetEventId() {
        System.out.println("getEventId");
        Event instance = new Event();
        String expResult = "";
        String result = instance.getEventId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEventId method, of class Event.
     */
    @Test
    public void testSetEventId() {
        System.out.println("setEventId");
        String eventId = "";
        Event instance = new Event();
        instance.setEventId(eventId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getState method, of class Event.
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        Event instance = new Event();
        EventState expResult = null;
        EventState result = instance.getState();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setState method, of class Event.
     */
    @Test
    public void testSetState() {
        System.out.println("setState");
        EventState state = null;
        Event instance = new Event();
        instance.setState(state);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Event.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Event instance = new Event();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}