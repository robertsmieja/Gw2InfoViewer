/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gw2InfoViewer.controllers;

import java.io.IOException;
import org.gw2InfoViewer.maps.EventNames;
import org.gw2InfoViewer.models.EventList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doReturn;

/**
 *
 * @author Robert Smieja
 */
public class MainControllerTest {

    public MainControllerTest() {
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
     * Test of getInstance method, of class MainController.
     */
    @Test
    public void testGetInstance() {
        MainController expResult = any(MainController.class);

        MainController result = MainController.getInstance();

        assertEquals(expResult, result);
    }

    /**
     * Test of getEventListWithoutNames method, of class MainController.
     */
    @Test
    public void testGetEventList() throws IOException {
        MainController mockController = mock(MainController.class);
        EventList eventList = any(EventList.class);
//        when(mockController.getEventListWithoutNames())();
        
        EventList result = mockController.getEventListWithoutNames();
        
//        assertEquals(expResult, result);
    }

    /**
     * Test of setEventList method, of class MainController.
     */
//    @Test
//    public void testSetEventList() {
//        MainController mockController = mock(MainController.class);
//
//        EventList eventList = any(EventList.class);
//
//        mockController.setEventList(eventList);
//
//        verify(mockController).setEventList(any(EventList.class));
//    }

    /**
     * Test of getEventNames method, of class MainController.
     */
    @Test
    public void testGetEventNameMap() throws IOException {
        System.out.println("getEventNameMap");
        MainController instance = null;
        EventNames expResult = null;
        EventNames result = instance.getEventNames();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEventNameMap method, of class MainController.
     */
//    @Test
//    public void testSetEventNameMap() {
//        System.out.println("setEventNameMap");
//        EventNames eventNameMap = null;
//        MainController instance = null;
//        instance.setEventNameMap(eventNameMap);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}