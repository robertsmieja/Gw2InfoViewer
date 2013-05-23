/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gw2ApiTest;

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
public class MainWindowTest {
    
    public MainWindowTest() {
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
     * Test of getInstance method, of class MainWindow.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        MainWindow expResult = null;
        MainWindow result = MainWindow.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class MainWindow.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MainWindow.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}