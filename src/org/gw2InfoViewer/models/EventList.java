/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gw2InfoViewer.models;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Robert Smieja
 */
public class EventList {

    private ArrayList<Event> eventList;

    public EventList(ArrayList<Event> eventList) {
        this.eventList = eventList;
    }

    public ArrayList<Event> getEventList() {
        return eventList;
    }

    public void setEventList(ArrayList<Event> eventList) {
        this.eventList = eventList;
    }

    @Override
    public String toString() {
        String result = "";
        Iterator it = eventList.iterator();
        while (it.hasNext()) {
            result = it.next().toString() + "\n";
        }

        return result;
    }
}
