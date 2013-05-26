/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gw2InfoViewer.maps;

import org.gw2InfoViewer.services.json.models.IdNamePair;
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
public class IdNamePairTest {
    
    public IdNamePairTest() {
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
     * Test of getId method, of class IdNamePair.
     */
    @Test
    public void testGetEventId() {
        System.out.println("getEventId");
        IdNamePair instance = new IdNamePair();
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class IdNamePair.
     */
    @Test
    public void testSetEventId() {
        System.out.println("setEventId");
        String eventId = "";
        IdNamePair instance = new IdNamePair();
        instance.setId(eventId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class IdNamePair.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        IdNamePair instance = new IdNamePair();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class IdNamePair.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        IdNamePair instance = new IdNamePair();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}