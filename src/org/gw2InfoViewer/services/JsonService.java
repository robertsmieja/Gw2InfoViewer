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
package org.gw2InfoViewer.services;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.gw2InfoViewer.models.Event;
import org.gw2InfoViewer.models.EventList;
import org.gw2InfoViewer.maps.IdNamePair;
import org.gw2InfoViewer.maps.NameMap;

/**
 *
 * @author Robert Smieja
 */
public class JsonService {

    private Gson gson;
    private JsonParser jsonParser;

    public JsonService() {
        this.gson = new Gson();
        this.jsonParser = new JsonParser();
    }

    public EventList parseEventListJson(String json) {
        ArrayList<Event> eventArray;
        JsonArray jsonArray;
        JsonObject jsonObject;

        eventArray = new ArrayList<>();
        jsonObject = jsonParser.parse(json).getAsJsonObject();
        jsonArray = jsonObject.get("events").getAsJsonArray();

        for (int i = 0; i < jsonArray.size(); i++) {
            Event event;
            event = gson.fromJson(jsonArray.get(i), Event.class);
            eventArray.add(event);
        }
        
        return new EventList(eventArray);
    }

    public NameMap parseNameMapJson(String json) {
        Map<String, String> nameHashMap;
        JsonArray jsonArray;
        JsonObject jsonObject;

        nameHashMap = new HashMap<>();
        jsonArray = jsonParser.parse(json).getAsJsonArray();

        for (int i = 0; i < jsonArray.size(); i++) {
            IdNamePair namePair;
            namePair = gson.fromJson(jsonArray.get(i), IdNamePair.class);
            nameHashMap.put(namePair.getEventId(), namePair.getName());
        }
        
        return new NameMap(nameHashMap);
    }
}
