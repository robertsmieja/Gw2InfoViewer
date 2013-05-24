/*
 *  Gw2InfoViewer - Java Swing based application that reads the Guild Wars 2 JSON API
 *  Copyright (C) 2013 Robert Smieja
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.gw2InfoViewer.models;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Robert Smieja
 */
public class Event {

    private String eventName;
    @SerializedName("world_id")
    private int worldId;
    @SerializedName("map_id")
    private int mapId;
    @SerializedName("event_id")
    private String eventId;
    @SerializedName("state")
    private EventState state;

    public Event() {
        this("N/A", 0, 0, null, null);
    }

    public Event(String eventName, int worldId, int mapId, String eventId, EventState state) {
        this.eventName = eventName;
        this.worldId = worldId;
        this.mapId = mapId;
        this.eventId = eventId;
        this.state = state;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Integer getWorldId() {
        return worldId;
    }

    public void setWorldId(Integer worldId) {
        this.worldId = worldId;
    }

    public Integer getMapId() {
        return mapId;
    }

    public void setMapId(Integer mapId) {
        this.mapId = mapId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public EventState getState() {
        return state;
    }

    public void setState(EventState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return eventName;
    }
}
