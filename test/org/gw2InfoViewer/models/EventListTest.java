/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gw2InfoViewer.models;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.anyListOf;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.mock;

/**
 *
 * @author Robert Smieja
 */
public class EventListTest {

    public EventListTest() {
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
     * Test of getEventList method, of class EventList.
     */
    @Test
    public void testEventList() {
        List<Event> mockEvents = anyListOf(Event.class);
        EventList eventList = new EventList(mockEvents);

        assertNotNull(eventList);
    }

    /**
     * Test of getEventList method, of class EventList.
     */
    @Test
    public void testGetEventList() {
        List<Event> mockEvents = anyListOf(Event.class);
        EventList eventList = new EventList(mockEvents);

        List<Event> result = eventList.getEventList();

        assertNotNull(eventList);
        assertSame(result, mockEvents);
    }

    /**
     * Test of setEventList method, of class EventList.
     */
    @Test
    public void testSetEventList() {
        List<Event> mockEvents = mock(List.class);
        List<Event> differentMockEvents = anyListOf(Event.class);

        assertFalse(mockEvents.equals(differentMockEvents));

        EventList eventList = new EventList(mockEvents);
        eventList.setEventList(differentMockEvents);

        List<Event> result = eventList.getEventList();

        assertNotNull(eventList);
        assertSame(result, differentMockEvents);
    }

    /**
     * Test of toString method, of class EventList.
     */
    @Test
    public void testToString() {
        EventList eventList = new EventList(anyListOf(Event.class));

        String result = eventList.toString();

        assertEquals(anyString(), result);
    }
}