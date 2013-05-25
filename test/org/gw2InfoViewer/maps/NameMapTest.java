/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gw2InfoViewer.maps;

import java.util.Map;
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
public class NameMapTest {
    
    public NameMapTest() {
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
     * Test of getNameMap method, of class NameMap.
     */
    @Test
    public void testGetNameMap() {
        System.out.println("getNameMap");
        NameMap instance = null;
        Map expResult = null;
        Map result = instance.getNameMap();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNameMap method, of class NameMap.
     */
    @Test
    public void testSetNameMap() {
        System.out.println("setNameMap");
        Map<String, String> nameMap = null;
        NameMap instance = null;
        instance.setNameMap(nameMap);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}