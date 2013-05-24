/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gw2InfoViewer.models;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Robert Smieja
 */
public class EventList {

    @SerializedName("events")
    private List<Event> eventList;

    public EventList(ArrayList<Event> eventList) {
        this.eventList = eventList;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    @Override
    public String toString() {
        String result = "";   
        for(Event event: eventList){
            result = event.toString() + "\n";
        }
        
        return result;
    }
}
